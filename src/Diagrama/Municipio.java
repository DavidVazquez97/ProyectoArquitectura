
package Diagrama;

import ConexionSingleton.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;


public class Municipio {
    
    Conexion conectar = Conexion.getInstace();
    Connection con = conectar.conectar();
    
    String municipio;

    public Municipio() {
    }

    public Municipio(String Municipio) {
        this.municipio = Municipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String Municipio) {
        this.municipio = Municipio;
    }
    
    
    public int getIdMunicipio(){
    
        int idMunicipio = 0;
        
        try {
        PreparedStatement ps;
        ResultSet rs;
        
        
        ps = con.prepareStatement("select idMunicipio from dbo.Municipio where municipio = ?");
        ps.setString(1, municipio);
        rs = ps.executeQuery();
        
        while (rs.next()){
            idMunicipio = rs.getInt("idMunicipio");
            System.out.println(idMunicipio);
        }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
            return idMunicipio;
        }
    
            
    
}
