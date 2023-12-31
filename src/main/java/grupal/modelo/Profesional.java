package grupal.modelo;

/**
 * @author Etzel M. Valderrama
 *
 */
public class Profesional extends Usuario {
	
	private String titulo;
	private String fechaIngreso;
	
	public Profesional() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param run
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 */
	public Profesional(int id, String run, String nombre, String apellido, String fechaNacimiento) {
		super(id, run, nombre, apellido, fechaNacimiento);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param titulo
	 * @param fechaIngreso
	 */
	public Profesional(String titulo, String fechaIngreso) {
		super();
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * @param id
	 * @param run
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param titulo
	 * @param fechaIngreso
	 */
	public Profesional(int id, String run, String nombre, String apellido, String fechaNacimiento, String titulo,
			String fechaIngreso) {
		super(id, run, nombre, apellido, fechaNacimiento);
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}
	
	/**
	 * @param run
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param titulo
	 * @param fechaIngreso
	 */
	public Profesional(String run, String nombre, String apellido, String fechaNacimiento, String titulo,
			String fechaIngreso) {
		super(run, nombre, apellido, fechaNacimiento);
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the fechaIngreso
	 */
	public String getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Profesional [titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + "]";
	}
}
