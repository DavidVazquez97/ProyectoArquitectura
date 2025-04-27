
package Diagrama;

import java.util.ArrayList;

public class ListadoTipoMunicipio {
    
    ArrayList<Municipio>lista;

    public ListadoTipoMunicipio() {
        lista = new ArrayList();
    }
    
    public void AgregarTipoMunicipio (Municipio tm){
    lista.add(tm);
    }
    
    
    
}
