

package Diagrama;

import ConexionSingleton.Conexion;
import javax.swing.JOptionPane;
import java.sql.*;

 
public class Metodos {
    
    Conexion conectar = Conexion.getInstace();
    Connection con = conectar.conectar();
    
   
    public int getIdDomicilio () {
        int idDomicilio = 0;
        
        try {
        PreparedStatement ps;
        ResultSet rs;
        
        ps = con.prepareStatement("select top 1 idVivienda from dbo.direccion order by idVivienda desc");
        rs = ps.executeQuery();
        
        while (rs.next()){
            idDomicilio = rs.getInt(1);
        }
        
        }catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null, ex);
        }
    
    return idDomicilio;

}
    
    public int getNumHabitantes (int idVivienda){
        
        int habitantes = 0;
        
        
        try {
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("select count(*) from dbo.Habitante where idVivienda = ?");
            ps.setInt(1, idVivienda);
            rs = ps.executeQuery();
            
            while(rs.next()){
                habitantes = rs.getInt(1);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    
    
    return habitantes;
    }
    
    
    public int getNumOcupacione (int idVivienda){
        int ocupaciones = 0;
            
        
        try {
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("select count(*) from dbo.Ocupaciones where idDomicilio = ?");
            ps.setInt(1, idVivienda);
            rs = ps.executeQuery();
            
            while(rs.next()){
                ocupaciones = rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    
        return ocupaciones;
    }
    
    
    
      
   
}
    

    
          