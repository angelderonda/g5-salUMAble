package Grupo5.SalUMAble.MODEL;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "usuario_doctor")
public class UsuarioDoctor extends Usuario {

	/** Campos obligatorios a rellenar **/
	private String nombre;
	private String apellidos;
	private String DNI;
	private int horaEntrada;
	private int horaSalida;
	private String sala;

	/** Campos opcionales a rellenar **/
	private int edad;
	private String localidad;

	/** Indica el paciente que se le ha asignado **/
	@OneToOne
	private UsuarioPaciente pacienteActual;
	private boolean pacienteAsignado;

	/** Indica la visibilidad del doctor en las listas (si esta en horario de trabajo) **/
	private boolean visibilidad;

	/** Indica la disponibilidad del doctor para atender una consulta **/
	private boolean disponibilidad;
	
	/** Indica la rama medica del doctor **/
	private RamaMedica rama;
	
	
	// Constructor de la clase UsuarioDoctor
	public UsuarioDoctor() {
		roles = "ROLE_DOCTOR";
		disponibilidad = true;
		pacienteAsignado = false;
		visibilidad = isVisibilidad();
	}
	
	///////////////////////////////////// Metodos de UsuarioDoctor ////////////////////////////////////
	
	public void liberarPaciente() {
		this.pacienteActual.setEstado(EstadoPaciente.ATENDIDO);
		this.pacienteActual = null;
		this.pacienteAsignado = false;
	}
	
	public void liberarConsulta() {
		this.visibilidad = isVisibilidad();
		this.disponibilidad = true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.toUpperCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDoctor other = (UsuarioDoctor) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equalsIgnoreCase(other.DNI))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioDoctor [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sala=" + sala
				+ ", visibilidad=" + visibilidad + ", disponibilidad=" + disponibilidad + "]";
	}
	
	
	//////////////////////////////////// Getters y setters ////////////////////////////////////////////
		
	public RamaMedica getRama() {
		return rama;
	}

	public void setRama(RamaMedica rama) {
		this.rama = rama;
	}
	
	public boolean isPacienteAsignado() {
		return pacienteAsignado;
	}

	public void setPacienteAsignado(boolean pacienteAsignado) {
		this.pacienteAsignado = pacienteAsignado;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public UsuarioPaciente getPacienteActual() {
		return pacienteActual;
	}

	public void setPacienteActual(UsuarioPaciente pacienteActual) {
		this.pacienteActual = pacienteActual;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public int getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(int horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public int getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(int horaSalida) {
		this.horaSalida = horaSalida;
	}

	public boolean isVisibilidad() {
		setVisibilidad(false);
		Date actual = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("HH");
		int horas = Integer.parseInt(format.format(actual));
		if (horaEntrada < horaSalida) {
			if (horas >= horaEntrada && horas <= horaSalida) {
				setVisibilidad(true);
			}
		} else {
			if (horas >= horaEntrada || horas <= horaSalida) {
				setVisibilidad(true);
			}
		}
		return visibilidad;
	}

	public void setVisibilidad(boolean visibilidad) {
		this.visibilidad = visibilidad;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public void setTratamiento(String tratamiento) {
		this.pacienteActual.setTratamiento(tratamiento);		
	}

}
