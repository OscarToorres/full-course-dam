/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.vista;

import es.leliadoura.ad.gestionempresas.errores.ControlEmpresasException;
import es.leliadoura.ad.gestionempresas.modelo.Fechas;
import es.leliadoura.ad.gestionempresas.modelo.HibernateSession;
import es.leliadoura.ad.gestionempresas.modelo.PersistenciaDatos;
import es.leliadoura.ad.gestionempresas.modelo.PersistenciaDatosUtilidades;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contacto;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contrato;
import es.leliadoura.ad.gestionempresas.modelo.entity.Empresa;
import es.leliadoura.ad.gestionempresas.modelo.entity.Trabajador;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author dam220
 */
public class AppEmpresa {

    Fechas date;
    PersistenciaDatos persistencia;

    public void generarDatos() throws ControlEmpresasException {
        date = new Fechas();
        persistencia = new PersistenciaDatosUtilidades();

        Contacto contacto1 = new Contacto("nombre1", "apellidos1", "correo1@gmail.com", 123456789);
        Contacto contacto2 = new Contacto("nombre2", "apellidos2", "correo2@gmail.com", 987654321);
        Contacto contacto3 = new Contacto("nombre3", "apellidos3", "correo3@gmail.com", 213215487);
        Contacto contacto4 = new Contacto("nombre4", "apellidos4", "correo4@gmail.com", 818656132);

        List<Contacto> contactos1 = new ArrayList<>();
        contactos1.add(contacto2);
        contactos1.add(contacto1);
        List<Contacto> contactos2 = new ArrayList<>();
        contactos1.add(contacto3);
        contactos1.add(contacto4);

        Empresa empresa1 = new Empresa("nif", "razon social", "iban", contactos1);
        Empresa empresa2 = new Empresa("nif2", "sin razon social", "iban2", contactos2);
        Empresa empresa3 = new Empresa("nif3", "razon social", "iban3", null);

        Trabajador trb1 = new Trabajador("11111111A", "Luis", "Lustres", "iban", "no tiene", "luiselguapo@gmail.com", 654321654);
        Trabajador trb2 = new Trabajador("22222222A", "Alvaro", "Regueira", "iban 2", "si tiene", "alvaroelguapo@gmail.com", 974521685);
        Trabajador trb3 = new Trabajador("33333333A", "Oscar", "Torres", "iban 3", "si tiene", "oscarelguapo@gmail.com", 648512034);

        Contrato contrato1 = new Contrato(date.stringToDate("2002-12-21"), null, 23000, 40, trb2, empresa1);
        Contrato contrato2 = new Contrato(date.stringToDate("2006-7-14"), date.stringToDate("2020-10-13"), 56000, 38, trb2, empresa1);
        Contrato contrato3 = new Contrato(date.stringToDate("2006-2-12"), null, 40000, 38, trb3, empresa1);
        Contrato contrato4 = new Contrato(date.stringToDate("2012-6-30"), null, 70000, 40, trb1, empresa2);
        Contrato contrato5 = new Contrato(date.stringToDate("2017-7-7"), null, 56000, 38, trb2, empresa3);

        persistencia.guardarContacto(contacto1);
        persistencia.guardarContacto(contacto2);
        persistencia.guardarContacto(contacto3);
        persistencia.guardarContacto(contacto4);
        
        persistencia.guardaEmpresa(empresa1);
        persistencia.guardaEmpresa(empresa2);
        persistencia.guardaEmpresa(empresa3);
        
        persistencia.guardaTrabajador(trb1);
        persistencia.guardaTrabajador(trb2);
        persistencia.guardaTrabajador(trb3);
        
        persistencia.guardarContrato(contrato1);
        persistencia.guardarContrato(contrato2);
        persistencia.guardarContrato(contrato3);
        persistencia.guardarContrato(contrato4);
        persistencia.guardarContrato(contrato5);
    }

    public static void main(String[] args) throws ControlEmpresasException {
        AppEmpresa app = new AppEmpresa();
        HibernateSession utilidades = new HibernateSession();
        PersistenciaDatos persistencia = new PersistenciaDatosUtilidades();
        Empresa empresa = new Empresa();
        
        app.generarDatos();
        Contacto contacto1 = new Contacto("nombre1", "apellidos1", "correo1@gmail.com", 123456789);
        Contacto contacto2 = new Contacto("nombre2", "apellidos2", "correo2@gmail.com", 987654321);
        Contacto contacto3 = new Contacto("nombre3", "apellidos3", "correo3@gmail.com", 213215487);
        Contacto contacto4 = new Contacto("nombre4", "apellidos4", "correo4@gmail.com", 818656132);
//        Contacto contacto = persistencia.recuperaContacto("correo1@gmail.com", "nombre1", "apellidos1");
//        System.out.println(contacto.toString());
        persistencia.borrarContacto(contacto1);
//        Empresa modificada = new Empresa("nif", "razon no social", "iban", contactos1);
//            
//        persistencia.modificarEmpresa(modificada);
//        String nif = "nif";
//        empresa = persistencia.consultaEmpresa(nif);
//        System.out.println(empresa.toString());
//        
//        trb1.setSegSocial("Ahora si tiene");
//        persistencia.modificarTrabajador(trb1);
//        String dni = "11111111A";
//        Trabajador trb2 = persistencia.consultaTrabajador(dni);
//        System.out.println(trb2.toString());
//        Contacto contactoMod = contacto2;
//        contactoMod.setNombre("Hugo");
//        persistencia.modificarContacto(contacto2, contactoMod);
//        
//        persistencia.borrarContacto(contacto1);
//        Contacto contacto = persistencia.recuperaContacto("correo2@gmail.com", "", "");
//        System.out.println(contacto.toString());
//        persistencia.modificarContrato(contrato, contratoMod);
//        List<Contrato> contratos = new ArrayList<>();
//        contratos = persistencia.consultaContratosEmpresa("nif");
//        contratos = persistencia.consultaContratosActualesEmpresa("nif");
//        contratos = persistencia.consultaContratosTrabajador("22222222A");
//        List<Empresa> empresas = persistencia.consultaEmpresas();
//        List<Trabajador> trabajadores = persistencia.consultaTrabajadores();
//        for (int i = 0; i < trabajadores.size(); i++) {
//            System.out.println("Contrato: " + trabajadores.get(i).toString());
//        }
    }
}
