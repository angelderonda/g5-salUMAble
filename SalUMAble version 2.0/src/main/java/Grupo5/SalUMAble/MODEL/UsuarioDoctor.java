package Grupo5.SalUMAble.MODEL;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "usuario_doctor")
public class UsuarioDoctor extends Usuario{
	
	/** Campos obligatorios a rellenar **/
	private String nombre;
	private String apellidos;
	private String DNI;
	private Date horaEntrada;
	private Date horaSalida;
	private String sala;
	
	/** Campos opcionales a rellenar **/
	private int edad;
	private String localidad;
	
	/** Indica el paciente que se le ha asignado **/
	@OneToOne
	private UsuarioPaciente pacienteActual;
	
	/** Indica la visibilidad del doctor en las listas (si está trabajando) **/
	private boolean visibilidad;
	
	/** Indica la disponibilidad del doctor para atender una consulta **/
	private boolean disponibilidad;

	private RamaMedica rama;
	
	//poner la rama mapeada
	

//	private ColaAmpliada cola;
	//Atribuye la cola ampliada
	
	
	/*CONSTRUCTOR*/
	//borrar lo de dentro
	public UsuarioDoctor() {
		disponibilidad = true;
		visibilidad = true;
	}
	
	/*MÉTODOS*/
	//	public void asignarTratamiento(UsuarioPaciente paciente){
//		String texto;
//		texto = UsuarioDoctorController.rellenarTratamiento();
//		paciente.setTratamiento(texto);
//		
//	}
	
	public void liberarPaciente(){
		this.pacienteActual = null;
		this.disponibilidad = true;

	}
	
	
	/*GETTERS Y SETTERS*/
//	public ColaAmpliada getCola() {
//		return cola;
//	}
//
//	public void setCola(ColaAmpliada cola) {
//		this.cola = cola;
//	}
	public RamaMedica getRamaMedica() {
		return rama;
	}
	public void setRamaMedica(RamaMedica rama) {
		this.rama = rama;
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
	public Date getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public Date getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}
	public boolean isVisibilidad() {
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

//	@Override
//	public void cerrarSesion() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mostrarAyuda() {
//		// TODO Auto-generated method stub
//		
//	}

//	public void iniciarSesion() {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
	
	
	

}
