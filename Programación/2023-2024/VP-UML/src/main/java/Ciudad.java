public class Ciudad {

	Provincia pertenece;
	private String nombre;
	private int poblacion;

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPoblacion() {
		return this.poblacion;
	}

	/**
	 * 
	 * @param poblacion
	 */
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public Turistica[] obtenerCiudadesTuristicas() {
		// TODO - implement Ciudad.obtenerCiudadesTuristicas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param turistica
	 */
	public Turistica obtenerCiudadTuristica(String turistica) {
		// TODO - implement Ciudad.obtenerCiudadTuristica
		throw new UnsupportedOperationException();
	}

	public Negocios[] obtenerNegocios() {
		// TODO - implement Ciudad.obtenerNegocios
		throw new UnsupportedOperationException();
	}

}