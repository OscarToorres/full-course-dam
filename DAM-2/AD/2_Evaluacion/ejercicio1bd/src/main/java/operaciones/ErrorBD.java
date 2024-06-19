/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

/**
 *
 * @author dam220
 */
public class ErrorBD {

    public static final String ERROR_OPEN_DESC = "No se pudo abrir";
    public static final int ERROR_OPEN_CODE = 1;

    public static final String ERROR_CLOSE_DESC = "No se pudo cerrar";
    public static final int ERROR_CLOSE_CODE = 10;

    public static final String ERROR_CONECTION_DESC = "La conexion está cerrada";
    public static final int ERROR_CONECTION_CODE = 11;

    public static final String ERROR_CLOSED_DESC = "La conexión ya estaba cerrada";
    public static final int ERROR_CLOSED_CODE = 12;

    public static final String ERROR_PASS_DESC = "Usuario y contraseña incorrectos";
    public static final int ERROR_PASS_CODE = 2;

    public static final String ERROR_TIME_DESC = "Tiempo de espera de la conexión agotado.";
    public static final int ERROR_TIME_CODE = 3;

    public static final String ERROR_PRIMARYKEY_DESC = "El dni ya esta registrado";
    public static final int ERROR_PRIMARYKEY_CODE = 4;

    public static final String ERROR_FORMAT_DESC = "Alguno de los datos tiene un formato incoherente";
    public static final int ERROR_FORMAT_CODE = 5;
    
    public static final String ERROR_EMPTYVALUE_DESC = "No se ha introducido ningun dato o el DNI introducido no es valido";
    public static final int ERROR_EMPTYVALUE_CODE = 6;
    
    public static final String ERROR_GENERIC_DESC = "Ups, algo salio mal";
    public static final int ERROR_GENERIC_CODE = 7;
}
