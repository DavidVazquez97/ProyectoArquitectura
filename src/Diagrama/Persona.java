
package Diagrama;

import ConexionSingleton.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;


public class Persona {
    
    String nombre; 
    String paterno;
    String materno;
    String telefono;
    String fecha_nacimiento;

    public Persona(String nombre, String paterno, String materno, String telefono, String fecha_nacimiento) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }



    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    
    Conexion conectar = Conexion.getInstace();
    Connection con = conectar.conectar();
    
    public void registrarHabitante (){
    
        try {
            Metodos met = new Metodos();
            PreparedStatement ps;
            
            ps = con.prepareStatement("insert into dbo.Habitante (nombre, apePaterno, apeMaterno, telefono, fechaNacimiento, idVivienda) values (?,?,?,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, paterno);
            ps.setString(3, materno);
            ps.setString(4, telefono);
            ps.setString(5, fecha_nacimiento);
            ps.setInt(6, met.getIdDomicilio());
            ps.executeUpdate();
            
            System.out.println("Habitante Registrado");
        
        }catch (SQLException ex){ 
        
            JOptionPane.showMessageDialog(null, ex);
        
        }
        
    
    }


    
    
    
    
}
