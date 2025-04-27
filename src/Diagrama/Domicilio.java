
package Diagrama;



import ConexionSingleton.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Domicilio {
    
    String calleNumero;
    String colonia;
    int codigoPostal;
    public Municipio municipio;
    String Estado;
    public Localidad localidad;
    public tipoVivienda vivienda;

    public Domicilio() {
    }

    public Domicilio(String calleNumero, String colonia, int codigoPostal, Municipio municipio, String Estado, Localidad localidad, tipoVivienda vivienda) {
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.municipio = municipio;
        this.Estado = Estado;
        this.localidad = localidad;
        this.vivienda = vivienda;
    }


    


    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }


    public void setEstado(String Estado) {
        this.Estado = Estado;
    }


    public void setVivienda(tipoVivienda vivienda) {
        this.vivienda = vivienda;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
    
    

    public String getCalleNumero() {
        return calleNumero;
    }

    public String getColonia() {
        return colonia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public Municipio getMunicipio() {
        return municipio;
    }


    public String getEstado() {
        return Estado;
    }


    public tipoVivienda getVivienda() {
        return vivienda;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
    Conexion conectar = Conexion.getInstace();
    Connection con = conectar.conectar();
    
    public void registrarDomicilio(){
    
        try{
        PreparedStatement ps;
        ps = con.prepareStatement("insert into dbo.direccion (calleYNumero, codigoPostal, colonia , municipio, estado, idTipoVivienda, idLocalidad) values (?,?,?,?,?,?,?)");
        ps.setString(1, calleNumero);
        ps.setInt(2, codigoPostal);
        ps.setString(3, colonia);
        ps.setInt(4, municipio.getIdMunicipio());
        ps.setString(5, Estado);
        ps.setInt(6, vivienda.getIdVivienda());
        ps.setInt(7, localidad.getIdLocalidad());
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Domicilio Guardado");
          
    }catch (SQLException ex){
    
        JOptionPane.showMessageDialog(null, ex);
    
    }
        
    
    }
    
    public void ActualizarDomicilio (int idDom){
        try {
        PreparedStatement ps;
        ps = con.prepareStatement("update dbo.direccion set calleYNumero = ?, codigoPostal = ?, colonia = ?, municipio = ?, idLocalidad = ?, estado = ?, idTipoVivienda = ? where idVivienda = ?");
        ps.setString(1, calleNumero);
        ps.setInt(2, codigoPostal);
        ps.setString(3, colonia);
        ps.setInt(4, municipio.getIdMunicipio());
        ps.setInt(5, localidad.getIdLocalidad());
        ps.setString(6, Estado);
        ps.setInt(7, vivienda.getIdVivienda());
        ps.setInt(8, idDom);
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Domicilio Modificado");

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.toString());
        }
    
    
    }
     
    
    
}
