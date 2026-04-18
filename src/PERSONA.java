
public class PERSONA {
	private String nombre;
	private int valor;
	private int dia;
	private int mes;
	private int año;
	
    PERSONA siguiente;
    PERSONA anterior;
	
	
	
	public PERSONA(String nombre, int valor, int dia, int mes, int año) {
		
		this.nombre = nombre;
		this.valor = valor;
		this.dia = dia;
		this.mes = mes;
		this.año = año;
		this.siguiente = null;
        this.anterior = null;
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public int getDia() {
		return dia;
	}


	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAño() {
		return año;
	}
	
	public PERSONA getSiguiente() {
        return siguiente;
    }

    public PERSONA getAnterior() {
        return anterior;
    }

	public void setAño(int año) {
		this.año = año;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
