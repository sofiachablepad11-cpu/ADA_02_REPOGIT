import javax.swing.DefaultListModel;

public class MANEJO_PERSONA {

    private PERSONA primero, ultimo = null;

    
    public void insertarNodoFinal(PERSONA nuevo) {
        if (primero == null) {
            primero = ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
    }

    
    public void agregarAlInicio(PERSONA nuevo) {
        if (primero == null) {
            primero = ultimo = nuevo;
        } else {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
    }

    
    public void agregarEnMedio(PERSONA nuevo) {

        PERSONA aux = primero;

        while (aux != null) {

            if (nuevo.getNombre().compareToIgnoreCase(aux.getNombre()) < 0) {

                nuevo.siguiente = aux;
                nuevo.anterior = aux.anterior;

                aux.anterior.siguiente = nuevo;
                aux.anterior = nuevo;

                return;
            }

            aux = aux.getSiguiente();
        }
    }

    
    public boolean insertarOrdenado(String nombre, int valor, int dia, int mes, int año) {

        PERSONA nuevo = new PERSONA(nombre, valor, dia, mes, año);

        
        PERSONA aux = primero;

        while (aux != null) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                return false;
            }
            aux = aux.getSiguiente();
        }

        
        if (primero == null) {
            primero = ultimo = nuevo;
        }

        
        else if (nombre.compareToIgnoreCase(primero.getNombre()) < 0) {
            agregarAlInicio(nuevo);
        }

        
        else if (nombre.compareToIgnoreCase(ultimo.getNombre()) > 0) {
            insertarNodoFinal(nuevo);
        }

        
        else {
            agregarEnMedio(nuevo);
        }

        return true;
    }
    
    public void recorrerLista(DefaultListModel modelo) {
        modelo.clear();
        PERSONA aux = primero;

        while (aux != null) {
            modelo.addElement(aux.toString());
            aux = aux.getSiguiente();
        }
    }
    
    public boolean estaVacia() {
        return primero == null;
    }
    
    
    public PERSONA buscar(String nombre) {
        PERSONA aux = primero;

        while (aux != null) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }

        return null;
    }
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}