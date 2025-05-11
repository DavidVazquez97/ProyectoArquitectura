
package Diagrama;



import ConexionSingleton.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class Domicilio {
    
    String calleNumero;
    String colonia;
    int codigoPostal;
    public Municipio municipio;
    String Estado;
    public Localidad localidad;
    public tipoVivienda vivienda;
    int idDomicilio;

    public Domicilio() {
    }

    public Domicilio(String calleNumero, String colonia, int codigoPostal, Municipio municipio, String Estado, Localidad localidad, tipoVivienda vivienda, int idDomicilio) {
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.municipio = municipio;
        this.Estado = Estado;
        this.localidad = localidad;
        this.vivienda = vivienda;
        this.idDomicilio = idDomicilio;
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

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public int getIdDomicilio() {
        return idDomicilio;
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
        
        String sqlString = "insert into dbo.direccion (calleYNumero, codigoPostal, colonia , municipio, estado," + 
                "idTipoVivienda, idLocalidad) values (?,?,?,?,?,?,?)";
    
        try{
        PreparedStatement ps;
        ps = con.prepareStatement(sqlString);
        ps.setString(1, calleNumero);
        ps.setInt(2, codigoPostal);
        ps.setString(3, colonia);
        ps.setInt(4, municipio.getIdMunicipio());
        ps.setString(5, Estado);
        ps.setInt(6, vivienda.getIdVivienda());
        ps.setInt(7, localidad.getIdLocalidad());
        ps.executeUpdate();
        conectar.cerrarConexion();
        
        JOptionPane.showMessageDialog(null, "Domicilio Guardado");
          
    }catch (SQLException ex){
    
        JOptionPane.showMessageDialog(null, ex);
    
    }
        
    
    }
    
    public void ActualizarDomicilio (){
        
        try {
            String sqlString = "update dbo.direccion set calleYNumero = ?, codigoPostal = ?, colonia = ?," + 
                    " municipio = ?, idLocalidad = ?, estado = ?, idTipoVivienda = ? where idVivienda = ?";
            
            PreparedStatement ps;
            ps = con.prepareStatement(sqlString);
            ps.setString(1, calleNumero);
            ps.setInt(2, codigoPostal);
            ps.setString(3, colonia);
            ps.setInt(4, municipio.getIdMunicipio());
            ps.setInt(5, localidad.getIdLocalidad());
            ps.setString(6, Estado);
            ps.setInt(7, vivienda.getIdVivienda());
            ps.setInt(8, idDomicilio);
            ps.executeUpdate();
            conectar.cerrarConexion();

            JOptionPane.showMessageDialog(null, "Domicilio Modificado");

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.toString());
        }
    
    
    }
    
    
    public void eliminarDomicilio(){
        if (idDomicilio == 0){
            JOptionPane.showMessageDialog(null, "Por favor seleciones un domicilio");
        }else {
        
            int opcion = JOptionPane.showConfirmDialog(null, "Esta apunto de elimnar todos los registros del domicilio: "+ idDomicilio + "¿Desea Continuar'");
            System.out.println(idDomicilio);
            switch (opcion) {
                case JOptionPane.YES_OPTION:
                    try {
                        PreparedStatement ps;
                        ps = con.prepareStatement("delete from dbo.Habitante where idVivienda = ?");
                        ps.setInt(1, idDomicilio);
                        ps.executeUpdate();
                        ps = con.prepareStatement("delete from dbo.Ocupaciones where idDomicilio = ?");
                        ps.setInt(1, idDomicilio);
                        ps.executeUpdate();
                        ps = con.prepareStatement("delete from dbo.direccion where idVivienda = ?");
                        ps.setInt(1, idDomicilio);
                        ps.executeUpdate();
                        conectar.cerrarConexion();
                        JOptionPane.showMessageDialog(null, "Domicilio eliminado");

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }       break;
                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(null, "No se ha eliminado ningun registro");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No se ha eliminado ningun registro");
                    break;
            }
        
        }
        
    
    
    }
     
    
    
}
