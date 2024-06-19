/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import com.mysql.cj.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dam220
 */
public class AppAlumno {

    private Scanner scan = new Scanner(System.in);

    public Alumno agregarAlumno() {
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scan.nextLine();

        Integer edad = this.introducirEdad();

        System.out.print("DNI: ");
        String dni = scan.nextLine();

        Alumno alumno = new Alumno(dni, nombre, apellidos, edad);

        return alumno;
    }

    public Alumno filtrarAlumno() {
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scan.nextLine();

        Integer edad = this.introducirEdad();

        String dni = "";

        Alumno alumno = new Alumno(dni, nombre, apellidos, edad);

        return alumno;
    }

    private Integer introducirEdad() {
        Integer edad = 0;
        String edadString;
        do {
            System.out.print("Edad: ");
            edadString = scan.nextLine();
            if (StringUtils.isStrictlyNumeric(edadString)) {
                edad = Integer.parseInt(edadString.toString());
            } else if ("".equals(edadString)) {
                break;
            } else {
                System.out.println("Introduce solo numeros");
            }
        } while (StringUtils.isStrictlyNumeric(edadString) == false);
        return edad;
    }

    public void mostrarLista(List<Alumno> alumnos) {
        if (alumnos.isEmpty()) {
            System.out.println("No se encontró ningún alumno");
        } else {
            for (int i = 0; i < alumnos.size(); i++) {
                System.out.println(alumnos.get(i).toString());
            }
        }
    }

    public String introducirDNI() {
        System.out.print("Introduce DNI: ");
        String dniConsulta = scan.nextLine();
        return dniConsulta;
    }

    public boolean comprobarAlumno(Alumno alumno) {
        boolean comprobacion = false;
        if (alumno.getDni() == null) {
            System.out.println("No existe ningún alumno con ese DNI");
        } else {
            comprobacion = true;
            System.out.println(alumno.toString());
        }
        return comprobacion;
    }

    public void menu() {
        System.out.println("");
        System.out.println("-----MENU-----");
        System.out.println("1.- Abrir conexion");
        System.out.println("2.- Listar alumnado");
        System.out.println("3.- Filtrar alumnado");
        System.out.println("4.- Añadir");
        System.out.println("5.- Consultar");
        System.out.println("6.- Borrar");
        System.out.println("7.- Modificar");
        System.out.println("8.- Cerrar conexion");
        System.out.println("9.- Cerrar programa");
    }

    public boolean confirmacion() {
        System.out.println("Desea borrar o modificar el alumno? pulsa 's' para confirmar, cualquier otra tecla para denegar.");
        String option = scan.nextLine();
        boolean confirmation = false;
        if ("s".equals(option)) {
            confirmation = true;
        } else {
            System.out.println("Operacion denegada");
        }
        return confirmation;
    }

    public static void main(String[] args) {
        //Objetos de clase
        AppAlumno app = new AppAlumno();
        OperacionesBD op = new OperacionesBD();
        Scanner scan = new Scanner(System.in);

        Alumno alumno = new Alumno();
        List<Alumno> alumnos = new ArrayList<>();

        String dniConsulta;
        String input;
        int option = 0;

        do {
            app.menu();
            input = scan.nextLine();
            if (StringUtils.isStrictlyNumeric(input)) {
                option = Integer.parseInt(input.toString());
            }

            try {
                switch (option) {
                    case 1:
                        op.abrirConexion();
                        System.out.println("Conexion abierta");
                        break;
                    case 2:
                        app.mostrarLista(op.listadoAlumnos());
                        break;
                    case 3:
                        alumno = app.filtrarAlumno();
                        app.mostrarLista(op.listadoAlumnos(alumno));
                        break;
                    case 4:
                        op.agregarAlumno(app.agregarAlumno());
                        System.out.println("Alumno agregado con exito");
                        break;
                    case 5:
                        alumno = op.consultaAlumno(app.introducirDNI());
                        app.comprobarAlumno(alumno);
                        break;
                    case 6:
                        alumno = op.consultaAlumno(app.introducirDNI());
                        if (app.comprobarAlumno(alumno) == true) {
                            if (app.confirmacion() == true) {
                                op.borraAlumno(alumno.getDni());
                                System.out.println("Alumno borrado con exito");
                            }
                        }
                        break;
                    case 7:
                        alumno = op.consultaAlumno(app.introducirDNI());
                        if (app.comprobarAlumno(alumno) == true) {
                            if (app.confirmacion() == true) {
                                Alumno alumnoModificado = new Alumno();
                                alumnoModificado = app.filtrarAlumno();
                                alumnoModificado.setDni(alumno.getDni());
                                op.modificaAlumno(alumnoModificado);
                                System.out.println("Alumno modificado con exito");
                            }
                        }
                        break;
                    case 8:
                        op.cerrarConexion();
                        System.out.println("Conexion cerrada");
                        break;

                    case 9:
                        op.cerrarConexion();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (OperacionesBDException ex) {
                System.out.println(ex.getMessage());
            }

        } while (option != 9);

    }
}
