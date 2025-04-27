package ConexionSingleton;

import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
    
    private Conexion (){
    
    }
    
    //Creamos una variable en cual vamos a guardar el estado de la conexión a la BD
    private static Connection conexion;
    
    // Creamos una variable para crear una sola instancia
    private static Conexion instancia;
    
    //Creamos la la variable de conexion a la BD
    private static final String conexionURL = "jdbc:sqlserver://localhost:1433;"
        + "database=ProyectoFinalArquitectura;"
        + "user=sa;"
        + "password=Andromeda123?;"
        + "loginTimeout=30;"
        + "TrustServerCertificate=True";
    
    
    // Creamos el método para conectarnos al BD
    public Connection conectar(){
    
        try{
        
            conexion = DriverManager.getConnection(conexionURL);
            return conexion;
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: " + e);
        
        }
        
        return conexion;
    }
    
    
    //Creamos el método para cerrar la conexión
    public void cerrarConexion() throws SQLException{
        try{
            conexion.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: " + e);
            conexion.close();
        }finally {
            conexion.close();
        }
    }
    
    
    //Patron singleton
    
    public static Conexion getInstace(){
        if(instancia == null){
            instancia = new Conexion ();
        }
        return instancia;
    }
    
    
}
