package repasoTareaUD10;

import java.util.Objects;


public class Participante {
	
	private String codigo;
	private String nombre;
	private String apellidos;
	private tipoSexo sexo;
	private int edad;
	private tipoParticipante categoria;
	
	public Participante(String codigo, String nombre, String apellidos, tipoSexo sexo, int edad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.edad = edad;
		this.setCategoria();

	}
	

	public void setCategoria() {
		if (this.getEdad() < 8) {
			this.categoria = tipoParticipante.BENJAMIN;
		}
		else if (this.getEdad()>=8 && this.getEdad()<=10) {
			this.categoria = tipoParticipante.ALEVIN;
		}
		else if (this.getEdad()>=11 && this.getEdad()<=12) {
			this.categoria = tipoParticipante.INFANTIL;
		}
		else if (this.getEdad()>=13 && this.getEdad()<=14) {
			this.categoria = tipoParticipante.CADETE;
		}
		else if (this.getEdad()>=15 && this.getEdad()<=18) {
			this.categoria = tipoParticipante.XUVENIL;
		}
		else if (this.getEdad()>=19 && this.getEdad()<=30) {
			this.categoria = tipoParticipante.SENIOR;
		}
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		return Objects.equals(codigo, other.codigo);
	}


	@Override
	public String toString() {
		return "Participante [codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo
				+ ", edad=" + edad + ", categoria=" + categoria + "]";
	}
	
	
	// GETTERS
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public tipoSexo getSexo() {
		return sexo;
	}
	public int getEdad() {
		return edad;
	}
	
	public tipoParticipante getCategoria() {
		return categoria;
	}
	
	// SETTERS
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setSexo(tipoSexo sexo) {
		this.sexo = sexo;
	}
	
	
	
		

}
