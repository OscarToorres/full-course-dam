/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.errores;

/**
 *
 * @author dam220
 */
public class ErrorBD {

    public ErrorBD() {
    }

    public static final String ERROR_ENTRIES_DESC = "El objeto que quieres guardar tiene clausulas que ya estan insertadas o campos no validos";
    public static final int ERROR_ENTRIES_CODE = 1;

    public static final String ERROR_INEXIST_DESC = "El objeto que buscas no existe";
    public static final int ERROR_INEXIST_CODE = 2;

    public static final String ERROR_MODOFY_DESC = "No se pudo realizar la modificacion";
    public static final int ERROR_MODOFY_CODE = 3;

    public static final String ERROR_FIND_DESC = "No se encontro el objeto en cuestión";
    public static final int ERROR_FIND_CODE = 4;

    public static final String ERROR_DELETE_DESC = "No se pudo borrar el objeto";
    public static final int ERROR_DELETE_CODE = 5;
}
