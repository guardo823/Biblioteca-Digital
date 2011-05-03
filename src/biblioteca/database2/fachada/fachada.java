/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.fachada;

package accesoDatos;

/**
 *
 * @author Eduardo
 */
import java.sql.*;
public class Fachada {

    String url, usuario, password;
        Connection conexion;
        Statement instruccion;
        ResultSet tabla;
        Fachada(){
            url="jdbc:postgresql://localhost:5432/bibliotecadigital";
            usuario="guardo823";
            password="guardo823";
        }

        public Connection conectar(){
            try {
            // Se carga el driver
            Class.forName("org.postgresql.Driver");
            System.out.println( "Driver Cargado" );
            } catch( Exception e ) {
                System.out.println( "No se pudo cargar el driver." );
            }

            try{
                     //Crear el objeto de conexion a la base de datos
                     conexion = DriverManager.getConnection(url, usuario, password);
                     System.out.println( "Conexion Abierta" );
                     return conexion;
                  //Crear objeto Statement para realizar queries a la base de datos
             } catch( Exception e ) {
                System.out.println( "No se pudo abrir." );
                return null;
             }
        }

        public void cerrarConexion(Connection conect){
            try{
                 conect.close();
            } catch( Exception e ) {
                System.out.println( "No se pudo cerrar la BD" );
            }
        }
}
