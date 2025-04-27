
package Diagrama;
import ConexionSingleton.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class tipoVivienda {
    String vivienda;

    public tipoVivienda() {
    }

    public tipoVivienda(String vivienda) {
        this.vivienda = vivienda;
    }

    public void setVivienda(String vivienda) {
        this.vivienda = vivienda;
    }

    public String getVivienda() {
        return vivienda;
    }
    
    Conexion conectar = Conexion.getInstace();
    
    public int getIdVivienda(){
    
        int idVivienda = 0;
        
        try {
        PreparedStatement ps;
        ResultSet rs;
        
        Connection con = conectar.conectar();
        ps = con.prepareStatement("select idTipoVivienda from dbo.tipoVivienda where tipoVivienda = ?");
        ps.setString(1, vivienda);
        rs = ps.executeQuery();
        
        while (rs.next()){
            idVivienda = rs.getInt("idTipoVivienda");
            System.out.println(idVivienda);
        }
            
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
            return idVivienda;
        }
       
    
    
    
}
