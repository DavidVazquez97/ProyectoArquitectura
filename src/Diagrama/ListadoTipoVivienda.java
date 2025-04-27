
package Diagrama;

import java.util.ArrayList;

public class ListadoTipoVivienda {
    
    ArrayList<tipoVivienda>lista;
    
    
    public ListadoTipoVivienda (){
        lista = new ArrayList();
    }
    
    public void AgregarTipoVivienda (tipoVivienda tv){
    
        lista.add(tv);
    }
}
