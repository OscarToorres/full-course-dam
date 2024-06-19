/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.errores;

/**
 *
 * @author marco
 */
public class ControlEmpresasException extends Exception{
    
    int codError;

    public ControlEmpresasException(int codError, String message) {
        super(message);
        this.codError = codError;
    }

    public int getCodError() {
        return codError;
    }
}
