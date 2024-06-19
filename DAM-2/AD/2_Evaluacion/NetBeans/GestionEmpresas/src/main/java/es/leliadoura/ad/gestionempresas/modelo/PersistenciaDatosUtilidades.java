/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo;

import es.leliadoura.ad.gestionempresas.errores.ControlEmpresasException;
import es.leliadoura.ad.gestionempresas.errores.ErrorBD;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contacto;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contrato;
import es.leliadoura.ad.gestionempresas.modelo.entity.Empresa;
import es.leliadoura.ad.gestionempresas.modelo.entity.Trabajador;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author dam220
 */
public class PersistenciaDatosUtilidades implements PersistenciaDatos {

    //comprobar si el contrato ya esta guardado
    @Override
    public void guardaEmpresa(Empresa empresa) throws ControlEmpresasException {
        try {
            Session sesion = HibernateSession.getSession();
            sesion.beginTransaction();
            sesion.persist(empresa);
            sesion.getTransaction().commit();
        } catch (HibernateException ex) {
            throw new ControlEmpresasException(ErrorBD.ERROR_ENTRIES_CODE, ErrorBD.ERROR_ENTRIES_DESC);
        }
    }

    @Override
    public void modificarEmpresa(Empresa empresa) throws ControlEmpresasException {
        try {
            Session sesion = HibernateSession.getSession();
            sesion.beginTransaction();
            sesion.merge(empresa);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new ControlEmpresasException(ErrorBD.ERROR_INEXIST_CODE, ErrorBD.ERROR_INEXIST_DESC);
        }

    }

    @Override
    public Empresa consultaEmpresa(String NIF) throws ControlEmpresasException {
        Empresa empresa = new Empresa();
        try {
            Session sesion = HibernateSession.getSession();
            sesion.beginTransaction();
            empresa = sesion.find(Empresa.class, NIF);
            sesion.merge(empresa);
        } catch (Exception ex) {
            throw new ControlEmpresasException(ErrorBD.ERROR_INEXIST_CODE, ErrorBD.ERROR_INEXIST_DESC);
        }
        return empresa;
    }

    @Override
    public void guardaTrabajador(Trabajador trabajador) throws ControlEmpresasException {
        try {
            Session sesion = HibernateSession.getSession();
            sesion.beginTransaction();
            sesion.persist(trabajador);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new ControlEmpresasException(ErrorBD.ERROR_ENTRIES_CODE, ErrorBD.ERROR_ENTRIES_DESC);
        }
    }

    @Override
    public void modificarTrabajador(Trabajador trabajador) throws ControlEmpresasException {
        try {
            Session sesion = HibernateSession.getSession();
            sesion.beginTransaction();
            sesion.merge(trabajador);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new ControlEmpresasException(ErrorBD.ERROR_MODOFY_CODE, ErrorBD.ERROR_MODOFY_DESC);
        }
    }

    @Override
    public Trabajador consultaTrabajador(String DNI) throws ControlEmpresasException {
        Trabajador trabajador = new Trabajador();
        try {
            Session sesion = HibernateSession.getSession();
            sesion.beginTransaction();
            trabajador = sesion.find(Trabajador.class,
                    DNI);
            sesion.merge(trabajador);

        } catch (Exception ex) {
            throw new ControlEmpresasException(ErrorBD.ERROR_FIND_CODE, ErrorBD.ERROR_FIND_DESC);
        }
        return trabajador;
    }

    @Override
    public void guardarContacto(Contacto contacto) throws ControlEmpresasException {
        try {
            Session sesion = HibernateSession.getSession();
            sesion.beginTransaction();
            sesion.persist(contacto);
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new ControlEmpresasException(ErrorBD.ERROR_ENTRIES_CODE, ErrorBD.ERROR_ENTRIES_DESC);
        }
    }

    @Override
    public void modificarContacto(Contacto contacto, Contacto contactoMod) throws ControlEmpresasException {
        try {

            Contacto contactoRecuperado = this.recuperaContacto(contacto.getCorreo(), contacto.getNombre(), contacto.getApellidos());

            contactoRecuperado.setApellidos(contactoMod.getApellidos());
            contactoRecuperado.setCorreo(contactoMod.getCorreo());
            contactoRecuperado.setNombre(contactoMod.getNombre());
            contactoRecuperado.setTelefono(contactoMod.getTelefono());

            Session sesion = HibernateSession.getSession();
            sesion.beginTransaction();
            sesion.merge(contactoRecuperado);
            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw new ControlEmpresasException(ErrorBD.ERROR_MODOFY_CODE, ErrorBD.ERROR_MODOFY_DESC);
        }
    }

    @Override
//Borra el contacto
    public void borrarContacto(Contacto contacto) throws ControlEmpresasException {
        try {
            Contacto contactoEliminar = this.borrarContantoEnEmpresas(contacto);
            Session sesion = HibernateSession.getSession();
            sesion.beginTransaction();
            sesion.remove(contactoEliminar);
            sesion.getTransaction().commit();
            sesion.close();

        } catch (Exception ex) {
            throw new ControlEmpresasException(ErrorBD.ERROR_DELETE_CODE, ErrorBD.ERROR_DELETE_DESC);
        }
    }

    //Obtiene el id del contacto que se le pase, recorre todas las empresas con sus contactos correspondientes
    //buscando si existe el contacto introducido, si esta lo borra y actualiza la empresa, despues devuelve el 
    //contacto a borrar con el id
    private Contacto borrarContantoEnEmpresas(Contacto contacto) throws ControlEmpresasException {
        Contacto contactoEliminar = this.recuperaContacto(contacto.getCorreo(), contacto.getNombre(), contacto.getApellidos());
        Integer idEliminar = contactoEliminar.getId();
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        List<Empresa> empresas = this.consultaEmpresas();

        List<Contacto> contactos = new ArrayList<>();
        for (int i = 0; i < empresas.size(); i++) {
            contactos = empresas.get(i).getContactos();
            for (int j = 0; j < contactos.size(); j++) {
                if (contactoEliminar.getId() == contactos.get(j).getId()) {
                    contactos.remove(j);
                }
            }
            empresas.get(i).setContactos(contactos);
            sesion.merge(empresas.get(i));
        }
        
//        for (Empresa emp : empresas) {
//            for (Contacto cont : emp.getContactos()) {
//                if (idEliminar == cont.getId()) {
//                    emp.getContactos().remove(cont);
//                }
//            }
//            sesion.merge(emp);
//        }
        sesion.getTransaction().commit();

        return contactoEliminar;
    }

    @Override
    public Contacto recuperaContacto(String correo, String nombre, String apellidos) throws ControlEmpresasException {
        Contacto contacto = new Contacto();
        try {
            Session sesion = HibernateSession.getSession();
            sesion.beginTransaction();
            String querry = "FROM Contacto WHERE correo LIKE '" + correo + "' AND nombre LIKE '" + nombre + "' AND apellidos LIKE '" + apellidos + "'";
            contacto = sesion.createQuery(querry, Contacto.class).uniqueResult();
        } catch (Exception ex) {
            throw new ControlEmpresasException(ErrorBD.ERROR_FIND_CODE, ErrorBD.ERROR_FIND_DESC);
        }
        return contacto;
    }

    //Tengo que recuperar primero la empresa y el trabajadaor, despues pasarlo al contrato y despues se introduce
    @Override
    public void guardarContrato(Contrato contrato) throws ControlEmpresasException {
        try {
            Session sesion = HibernateSession.getSession();
            sesion.beginTransaction();
            Contrato contratoComprobacion = this.recuperaContrato(contrato.getTrabajador().getDni(), contrato.getEmpresa().getNif(), contrato.getFechaInicio());
            if (contratoComprobacion == null) {
                sesion.persist(contrato);
                sesion.getTransaction().commit();
            }
        } catch (Exception ex) {

        }

    }

    @Override
    public void modificarContrato(Contrato contrato, Contrato contratoMod) throws ControlEmpresasException {
        Contrato contratoRecuperado = this.recuperaContrato(contrato.getTrabajador().getDni(), contrato.getEmpresa().getNif(), contrato.getFechaInicio());

        contratoRecuperado.setEmpresa(contratoMod.getEmpresa());
        contratoRecuperado.setFechaFin(contratoMod.getFechaFin());
        contratoRecuperado.setFechaInicio(contratoMod.getFechaInicio());
        contratoRecuperado.setJornada(contratoMod.getJornada());
        contratoRecuperado.setSalario(contratoMod.getSalario());
        contratoRecuperado.setTrabajador(contratoMod.getTrabajador());

        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        sesion.merge(contratoRecuperado);
        sesion.getTransaction().commit();
    }

    @Override
    public Contrato recuperaContrato(String dni, String nif, Date fechaInicio) throws ControlEmpresasException {
        Fechas date = new Fechas();
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        String querry = "FROM Contrato c "
                + "JOIN c.trabajador t "
                + "JOIN c.empresa e "
                + "WHERE c.fechaInicio LIKE '" + date.dateToString(fechaInicio) + "' "
                + "AND t.dni LIKE '" + dni + "' "
                + "AND e.nif LIKE '" + nif + "'";
        Contrato contratoRecuperado = sesion.createQuery(querry, Contrato.class
        ).uniqueResult();
        sesion.getTransaction().commit();
        sesion.close();
        return contratoRecuperado;
    }

    //Preguntar porque si pongo el sesion.close() peta salu2
    @Override
    public List<Contrato> consultaContratosEmpresa(String NIF) throws ControlEmpresasException {
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        String querry = "FROM Contrato c "
                + "JOIN c.empresa e "
                + "WHERE e.nif LIKE '" + NIF + "'";
        List<Contrato> contratos = sesion.createQuery(querry, Contrato.class
        ).list();
        sesion.getTransaction().commit();
        return contratos;
    }

    @Override
    public List<Contrato> consultaContratosActualesEmpresa(String NIF) throws ControlEmpresasException {
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        String querry = "FROM Contrato c "
                + "JOIN c.empresa e "
                + "WHERE e.nif LIKE '" + NIF + "' "
                + "AND c.fechaFin is null";
        List<Contrato> contratos = sesion.createQuery(querry, Contrato.class
        ).list();
        sesion.getTransaction().commit();
        return contratos;
    }

    @Override
    public List<Contrato> consultaContratosTrabajador(String DNI) throws ControlEmpresasException {
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        String querry = "FROM Contrato c "
                + "JOIN c.trabajador t "
                + "WHERE t.dni LIKE '" + DNI + "'";
        List<Contrato> contratos = sesion.createQuery(querry, Contrato.class
        ).list();
        sesion.getTransaction().commit();
        return contratos;
    }

    @Override
    public List<Empresa> consultaEmpresas() throws ControlEmpresasException {
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        String querry = "FROM Empresa";
        List<Empresa> empresas = sesion.createQuery(querry, Empresa.class
        ).list();
        sesion.getTransaction().commit();
        return empresas;
    }

    @Override
    public List<Trabajador> consultaTrabajadores() throws ControlEmpresasException {
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        String querry = "FROM Trabajador";
        List<Trabajador> trabajadores = sesion.createQuery(querry, Trabajador.class
        ).list();
        sesion.getTransaction().commit();
        return trabajadores;
    }

    @Override
    public List<Contrato> consultaContratos() throws ControlEmpresasException {
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        String querry = "FROM Contrato";
        List<Contrato> contratos = sesion.createQuery(querry, Contrato.class
        ).list();
        sesion.getTransaction().commit();
        return contratos;
    }

    @Override
    public List<Contacto> consultaContactos() throws ControlEmpresasException {
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        String querry = "FROM Contacto";
        List<Contacto> contactos = sesion.createQuery(querry, Contacto.class
        ).list();
        sesion.getTransaction().commit();
        return contactos;
    }

}
