/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

/**
 *
 * @author dam220
 */
public class OperacionesBDException extends Exception{
    
    private int erroCode;

    public OperacionesBDException(int erroCode, String msg) {
        super(msg);
        this.erroCode = erroCode;
    } 

    public int getErroCode() {
        return erroCode;
    }    
}