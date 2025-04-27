
package Diagrama;

import java.util.ArrayList;

public class ListadoTipoLocalidad {
    
    ArrayList<Localidad>lista;
    
    public ListadoTipoLocalidad (){
        lista = new ArrayList();
    }
    
    public void AgregarTipoLocalidad (Localidad loc){
        lista.add(loc);
    }
    
}
