
package Diagrama;

import ConexionSingleton.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;


public class Ocupacion {
    
    String ocupacion;
    
    Conexion conectar = Conexion.getInstace();
    Connection con = conectar.conectar();

    public Ocupacion() {
    }
    
    

    public Ocupacion(String Ocupacion) {
        this.ocupacion = Ocupacion;
    }

    public void setOcupacion(String Ocupacion) {
        this.ocupacion = Ocupacion;
    }

    public String getOcupacion() {
        return ocupacion;
    }
    
        public int getIdOcupacion(){
    
        int idOcupacion = 0;
        
        try {
        PreparedStatement ps;
        ResultSet rs;
        
        
        ps = con.prepareStatement("select idOcupacion from dbo.Ocupacion where ocupacion = ?");
        ps.setString(1, ocupacion);
        rs = ps.executeQuery();
        
        while (rs.next()){
            idOcupacion = rs.getInt("idOcupacion");
            System.out.println(idOcupacion);
        }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
            return idOcupacion;
        }
    
    
}
