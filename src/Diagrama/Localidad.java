
package Diagrama;

import ConexionSingleton.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;


public class Localidad {
    
    String localidad;
    int idMunicipio;
    
    Conexion conectar = Conexion.getInstace();
    Connection con = conectar.conectar();

    public Localidad() {
    }

    public Localidad(String localidad, int idMunicipio) {
        this.localidad = localidad;
        this.idMunicipio = idMunicipio;
    }



    public String getLocalidad() {
        return localidad;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setConectar(Conexion conectar) {
        this.conectar = conectar;
    }
    

    public void setLocalidad(String Localidad) {
        this.localidad = Localidad;
    }
    
    public int getIdLocalidad(){
    
        int idLocalidad = 0;
        
        try {
        PreparedStatement ps;
        ResultSet rs;
        
        
        ps = con.prepareStatement("select idLocalidad from Localidad where Localidad = ?");
        ps.setString(1, localidad);
        rs = ps.executeQuery();
        
        while (rs.next()){
            idLocalidad = rs.getInt("idLocalidad");
            System.out.println(idLocalidad);
        }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
            return idLocalidad;
        }
    
    
    
    
}
