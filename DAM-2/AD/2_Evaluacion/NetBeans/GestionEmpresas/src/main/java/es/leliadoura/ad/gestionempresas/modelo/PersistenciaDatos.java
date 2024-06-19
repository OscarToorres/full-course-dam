package es.leliadoura.ad.gestionempresas.modelo;

import es.leliadoura.ad.gestionempresas.errores.ControlEmpresasException;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contacto;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contrato;
import es.leliadoura.ad.gestionempresas.modelo.entity.Empresa;
import es.leliadoura.ad.gestionempresas.modelo.entity.Trabajador;
import java.util.Date;
import java.util.List;

/**
 * Acceso a la capa de persistencia
 *
 * @author marco
 */
public interface PersistenciaDatos {

    /**
     * Guarda una empresa
     *
     * @param empresa objeto a guardar
     */
    public void guardaEmpresa(Empresa empresa) throws ControlEmpresasException;

    /**
     * Modifica una empresa
     *
     * @param empresa objeto a modificar
     */
    public void modificarEmpresa(Empresa empresa)throws ControlEmpresasException;

    /**
     * Busca y devuelve la empresa por su NIF
     *
     * @param NIF identificador de la empresa
     * @return objeto empresa recuperado o null si no existe
     */
    public Empresa consultaEmpresa(String NIF)throws ControlEmpresasException;

    /**
     * Guarda un trabajador
     *
     * @param trabajador objeto a guardar
     */
    public void guardaTrabajador(Trabajador trabajador)throws ControlEmpresasException;

    /**
     * Modifica un trabajador
     *
     * @param trabajador objeto a modificar
     */
    public void modificarTrabajador(Trabajador trabajador)throws ControlEmpresasException;

    /**
     * Busca y devuelve la empresa por su DNI
     *
     * @param DNI identificador del trabajador
     * @return objeto empresa recuperado o null si no existe
     */
    public Trabajador consultaTrabajador(String DNI)throws ControlEmpresasException;

    /**
     * Guarda un contacto
     *
     * @param contacto objeto a guardar
     */
    public void guardarContacto(Contacto contacto)throws ControlEmpresasException;

    /**
     * Modificar un contacto
     *
     * @param contacto objeto a modificar
     * @param contactoMod objeto modificado
     */
    public void modificarContacto(Contacto contacto, Contacto contactoMod)throws ControlEmpresasException;

    /**
     * Borra un contacto
     *
     * @param contacto objeto a borrar
     */
    public void borrarContacto(Contacto contacto)throws ControlEmpresasException;

    /**
     * Recupera un contacto a partir de su correo electrónico
     *
     * @param correo
     * @param nombre
     * @param apellidos
     * @return objeto contacto recuperado o null si no existe
     */
    public Contacto recuperaContacto(String correo, String nombre, String apellidos)throws ControlEmpresasException;

    /**
     * Guarda un contrato
     *
     * @param contrato objeto a guardar
     */
    public void guardarContrato(Contrato contrato)throws ControlEmpresasException;

    /**
     * Modifica un contrato
     *
     * @param contrato objeto a modificar
     * @param contratoMod objeto modificado
     */
    public void modificarContrato(Contrato contrato, Contrato contratoMod)throws ControlEmpresasException;

    /**
     * Recupera un contrato a partir de su id
     *
     * @param DNI identificador del trabajador
     * @param NIF identificador de la empresa
     * @param fechaINicio fecha de inicio del contrato
     * @return el objeto contrato recuperado o null si no existe
     */
    public Contrato recuperaContrato(String dni, String nif, Date fechaInicio)throws ControlEmpresasException;

    /**
     * Recupera la lista de contratos de una empresa
     *
     * @param NIF identificador de la empresa
     * @return listado de contratos
     */
    public List<Contrato> consultaContratosEmpresa(String NIF)throws ControlEmpresasException;

    /**
     * Recupera la lista de contratos vigentes de una empresa
     *
     * @param NIF identificador de la empresa
     * @return listado de contratos
     */
    public List<Contrato> consultaContratosActualesEmpresa(String NIF)throws ControlEmpresasException;

    /**
     * Recupera la lista de contratos de un trabajador
     *
     * @param DNI identificador del trabajador
     * @return listado de contratos
     */
    public List<Contrato> consultaContratosTrabajador(String DNI)throws ControlEmpresasException;

    /**
     * Recupera el listado completo de empresas
     *
     * @return
     */
    public List<Empresa> consultaEmpresas()throws ControlEmpresasException;

    /**
     * Recupera el listado completo de trabjadores
     *
     * @return
     */
    public List<Trabajador> consultaTrabajadores()throws ControlEmpresasException;

    /**
     * Recupera el listado completo de contratos
     *
     * @return
     */
    public List<Contrato> consultaContratos()throws ControlEmpresasException;

    /**
     * Recupera el listado completo de contactos
     *
     * @return
     */
    public List<Contacto> consultaContactos()throws ControlEmpresasException;

}
