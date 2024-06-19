/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import com.mysql.cj.util.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam220
 */
public class OperacionesBD {

    private Connection con = null;
    private List<Alumno> alumnosFiltrado = new ArrayList<>();

    public OperacionesBD() {
    }

    public void abrirConexion() throws OperacionesBDException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://192.168.56.101:3306/bdexercicios";
            con = DriverManager.getConnection(url, "bdexercicios", "abc123.");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            int error = ex.getErrorCode();
            if (error == 1045) {
                throw new OperacionesBDException(ErrorBD.ERROR_PASS_CODE, ErrorBD.ERROR_PASS_DESC);
            } else if (error == 0) {
                throw new OperacionesBDException(ErrorBD.ERROR_TIME_CODE, ErrorBD.ERROR_TIME_DESC);
            } else {
                throw new OperacionesBDException(ErrorBD.ERROR_OPEN_CODE, ErrorBD.ERROR_OPEN_DESC);
            }
        }
    }

    public void cerrarConexion() throws OperacionesBDException {
        try {
            if (comprobarConexion() == false) {
                throw new OperacionesBDException(ErrorBD.ERROR_CLOSED_CODE, ErrorBD.ERROR_CLOSED_DESC);
            }
            con.close();
        } catch (SQLException ex) {
            throw new OperacionesBDException(ErrorBD.ERROR_CLOSE_CODE, ErrorBD.ERROR_CLOSE_DESC);
        }
    }

    public void agregarAlumno(Alumno alumno) throws OperacionesBDException {

        String sentencia = "INSERT INTO alumno (`dni`, `nome`, `apelidos`, `idade`) VALUES (?,?,?,?)";

        try {
            if (comprobarConexion() == true) {
                PreparedStatement stmt = con.prepareStatement(sentencia);
                stmt.setString(1, alumno.getDni());
                stmt.setString(2, alumno.getNombre());
                stmt.setString(3, alumno.getApellidos());
                stmt.setInt(4, alumno.getEdad());
                stmt.executeUpdate();
            } else {
                throw new OperacionesBDException(ErrorBD.ERROR_CONECTION_CODE, ErrorBD.ERROR_CONECTION_DESC);
            }
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                throw new OperacionesBDException(ErrorBD.ERROR_PRIMARYKEY_CODE, ErrorBD.ERROR_PRIMARYKEY_DESC);
            } else {
                throw new OperacionesBDException(ErrorBD.ERROR_FORMAT_CODE, ErrorBD.ERROR_FORMAT_DESC);
            }
        }
    }

    public Alumno consultaAlumno(String dni) throws OperacionesBDException {
        Alumno alumno = new Alumno();
        Statement stmt;
        try {
            if (comprobarConexion() == true) {

                stmt = con.createStatement();
                String sentencia = "SELECT * FROM `alumno` WHERE dni LIKE '" + dni + "'";
                ResultSet rs = stmt.executeQuery(sentencia);

                while (rs.next()) {
                    alumno.setDni(rs.getString("dni"));
                    alumno.setNombre(rs.getString("nome"));
                    alumno.setApellidos(rs.getString("apelidos"));
                    alumno.setEdad(rs.getInt("idade"));
                }
            } else {
                throw new OperacionesBDException(ErrorBD.ERROR_CONECTION_CODE, ErrorBD.ERROR_CONECTION_DESC);
            }
        } catch (SQLException ex) {
            throw new OperacionesBDException(ErrorBD.ERROR_GENERIC_CODE, ErrorBD.ERROR_GENERIC_DESC);
        }

        return alumno;
    }

    public int borraAlumno(String dni) throws OperacionesBDException {

        String sql = "DELETE FROM `alumno` WHERE dni='" + dni + "'";
        try {
            if (comprobarConexion() == true) {

//Un preparaStatement solo si usamos las ? en la consulta, sino solo usamos un createStatement
                //Estos son metodos de la clase Conexion por eso se usa la conexion.
                Statement stmt = con.createStatement();
                //el executeUpdate vale para modificaciones 
                //el executeQuerry vale para consultar
                stmt.executeUpdate(sql);
            } else {
                throw new OperacionesBDException(ErrorBD.ERROR_CONECTION_CODE, ErrorBD.ERROR_CONECTION_DESC);
            }
        } catch (SQLException ex) {
            throw new OperacionesBDException(ErrorBD.ERROR_GENERIC_CODE, ErrorBD.ERROR_GENERIC_DESC);
        }

        return 0;
    }

    public int modificaAlumno(Alumno alumno) throws OperacionesBDException {
        String sql = "UPDATE alumno ";
        int confirmacion = 0;
        Statement stmt;
        try {
            if (comprobarConexion() == true) {
                if (!"".equals(alumno.getNombre())) {
                    sql = sql + "SET nome='" + alumno.getNombre() + "'";
                }
                if (!"".equals(alumno.getApellidos())) {
                    if (sql.contains("SET")) {
                        sql = sql + ", apelidos='" + alumno.getApellidos() + "'";
                    } else {
                        sql = sql + "SET apelidos='" + alumno.getApellidos() + "'";
                    }
                }
                if (alumno.getEdad() != null) {
                    if (sql.contains("SET")) {
                        sql = sql + ", idade='" + alumno.getEdad() + "'";
                    } else {
                        sql = sql + "SET idade='" + alumno.getEdad() + "'";
                    }
                }
                sql = sql + "WHERE dni LIKE '" + alumno.getDni() + "'";

                stmt = con.createStatement();
                confirmacion = stmt.executeUpdate(sql);
            } else {
                throw new OperacionesBDException(ErrorBD.ERROR_CONECTION_CODE, ErrorBD.ERROR_CONECTION_DESC);
            }
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1064) {
                throw new OperacionesBDException(ErrorBD.ERROR_EMPTYVALUE_CODE, ErrorBD.ERROR_EMPTYVALUE_DESC);
            } else {
                throw new OperacionesBDException(ErrorBD.ERROR_GENERIC_CODE, ErrorBD.ERROR_GENERIC_DESC);

            }
        }
        return confirmacion;
    }

    public List<Alumno> listadoAlumnos() throws OperacionesBDException {

        String sentencia = "SELECT * FROM alumno";
        Statement stmt;
        List<Alumno> alumnos = new ArrayList<>();

        try {
            if (comprobarConexion() == true) {

                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sentencia);
                while (rs.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setNombre(rs.getString("nome"));
                    alumno.setApellidos(rs.getString("apelidos"));
                    alumno.setDni(rs.getString("dni"));
                    alumno.setEdad(rs.getInt("idade"));
                    alumnos.add(alumno);
                }
            } else {
                throw new OperacionesBDException(ErrorBD.ERROR_CONECTION_CODE, ErrorBD.ERROR_CONECTION_DESC);
            }
        } catch (SQLException ex) {
            throw new OperacionesBDException(ErrorBD.ERROR_GENERIC_CODE, ErrorBD.ERROR_GENERIC_DESC);
        }

        return alumnos;
    }

    public List<Alumno> listadoAlumnos(Alumno alumno) throws OperacionesBDException {

        String sql = "SELECT * FROM alumno";
        Statement stmt;
        List<Alumno> alumnos = new ArrayList<>();

        try {
            if (comprobarConexion() == true) {

                stmt = con.createStatement();
                if (!"".equals(alumno.getNombre())) {
                    sql = sql + " WHERE nome like '" + alumno.getNombre() + "'";
                }
                if (!"".equals(alumno.getApellidos())) {
                    if (sql.contains("WHERE")) {
                        sql = sql + " AND apelidos like '" + alumno.getApellidos() + "'";
                    } else {
                        sql = sql + " WHERE apelidos like '" + alumno.getApellidos() + "'";
                    }
                }
                if (alumno.getEdad() != null) {
                    if (sql.contains("WHERE")) {
                        sql = sql + " AND idade = '" + alumno.getEdad() + "'";
                    } else {
                        sql = sql + " WHERE idade  = '" + alumno.getEdad() + "'";
                    }
                }

                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Alumno alumnors = new Alumno();
                    alumnors.setNombre(rs.getString("nome"));
                    alumnors.setApellidos(rs.getString("apelidos"));
                    alumnors.setDni(rs.getString("dni"));
                    alumnors.setEdad(rs.getInt("idade"));
                    alumnos.add(alumnors);
                }
            } else {
                throw new OperacionesBDException(ErrorBD.ERROR_CONECTION_CODE, ErrorBD.ERROR_CONECTION_DESC);
            }

        } catch (SQLException ex) {
            throw new OperacionesBDException(ErrorBD.ERROR_GENERIC_CODE, ErrorBD.ERROR_GENERIC_DESC);
        }

        return alumnos;
    }

    private boolean comprobarConexion() {
        boolean conexion = false;
        try {
            if (con != null && !con.isClosed()) {
                conexion = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
}
