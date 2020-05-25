package main.java.model;

import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;

public class UsuarioPaciente extends Usuario implements Comparable<UsuarioPaciente> {
	
	/** Campos obligatorios a rellenar **/
	private String nombre;
	private String apellidos;
	private String DNI;
	private int prioridad;
	private Date entrada;
	private RamaMedica rama;
	
	/** Campos opcionales a rellenar **/
	private Integer edad;
	private String localidad;
	private String telefono;
	private String sintomas;
	
	/** enum que cambia segun el estado en el que se encuentra el paciente **/
	private EstadoPaciente estado;
	
	/** Indica el doctor que se le ha asignado **/
	private UsuarioDoctor doctorAsignado;
	
	/** Indica el tratamiento que le asigna el doctor **/
	private String tratamiento;
	

	/** Constructor de la clase UsuarioPaciente **/
	public UsuarioPaciente() {
		
		estado = EstadoPaciente.EN_ESPERA;
		doctorAsignado = null;
		tratamiento = null;
		entrada = new Date(System.currentTimeMillis());
		
	}
	
	/** Constructor de la clase UsuarioPaciente con param **/
	public UsuarioPaciente(String name, String surname, String dni, int priority, RamaMedica r, Date momentoEntrada) {
		
		nombre = name;
		apellidos = surname;
		DNI = dni;
		prioridad = priority;
		rama = r;
		
		estado = EstadoPaciente.EN_ESPERA;
		doctorAsignado = null;
		tratamiento = null;
		entrada = momentoEntrada;
		
	}	
	
	
	/** Funcion con la que se consigue la posicion provisional del paciente en la cola de espera.
	 * Si el paciente esta en consulta o ha sido atendido, devuelve -1 **/
	// Asumimos que el paciente esta en la cola ??????????????????????????????????
	// en el diagrama devuelve un Integer y no un int
	public int verPosicionEnCola() {
		int pos = -1;
		if (estado == EstadoPaciente.EN_ESPERA) {
			PriorityQueue<UsuarioPaciente> cola = UsuarioAdministrador.getColaPacientes(rama);
			pos = 0;
			Iterator<UsuarioPaciente> it = cola.iterator();
			while (it.hasNext() && !it.next().equals(this)) {
				pos++;
			}
		}
		return pos;
	}
	
	
	/** Establece el doctor que se le ha asignado al paciente **/
	// Metodo añadido
	public void setDoctorAsignado(UsuarioDoctor doctor) {
		doctorAsignado = doctor;
	}
	
	/** Establece el tratamiento del paciente **/
	// Metodo añadido
	public void setTratamiento(String trat) {
		tratamiento = trat;
	}
	
	/** Establece el estado del paciente **/
	public void setEstado(EstadoPaciente state) {
		estado = state;
	}
	
	/** Devuelve el doctor que tiene asignado el paciente **/
	// Cambiado el nombre del diagrama
	public UsuarioDoctor getDoctorAsignado() {
		return doctorAsignado;
	}
	
	// Deberia enseñar la pantalla del paciente segun su estado
	// Habria que añadirlo en el diagrama
	public void iniciarSesion() {
		//Pantalla con el toString(), solo una
		/*
		if (estado == EstadoPaciente.EN_ESPERA) {
			//Pantalla con la pos del paciente
		} else if (estado == EstadoPaciente.EN_CONSULTA) {
			//Pantalla con el doctor y consulta
		} else {
			//Pantalla con lo que se le ha recetado
		}
		*/
	}
	
	/** Implementa el metodo de cerrar sesion **/
	// Habria que añadirlo en el diagrama
	@Override
	public void cerrarSesion() {
		
	}
	
	/** Implementa el metodo de mostrar ayuda **/
	// Habria que añadirlo en el diagrama
	@Override
	public void mostrarAyuda() {
		//Muestra la pantalla de ayuda
	}
	
	/** Escribe los datos del paciente segun el estado en el que se encuentra **/
	public String toStringPaciente() {
		String res = "Paciente: " + apellidos + ", " + nombre + ".\n";
		if (estado == EstadoPaciente.EN_ESPERA) {
			res += "Tiene " + verPosicionEnCola() + " pacientes por delante (sujeto a cambios).";
		} else if (estado == EstadoPaciente.EN_CONSULTA) {
			res += "Se le ha asignado el doctor: " + doctorAsignado.toString();
		} else {
			res += "Se le ha recetado:\n" + tratamiento;
		}
		return res;
	}
	
	/** Escribe los datos del paciente **/
	@Override
	public String toString() {
		String res = "Paciente: " + apellidos + ", " + nombre + ".\n";
		res += "DNI: " + DNI + "\n";
		if (edad != null) {
			res += "Edad: " + edad + "\n";
		}
		if (localidad != null) {
			res += "Localidad: " + localidad + "\n";
		}
		if (telefono != null) {
			res += "Telefono de contacto: " + telefono + "\n";
		}
		if (sintomas != null) {
			res += "Sintomas del paciente: " + sintomas + "\n";
		}
		return res;
	}
	
	/** Dos pacientes son iguales si tienen el mismo DNI (la letra puede ser mayuscula o minuscula **/
	@Override
	public boolean equals(Object obj) {
		boolean res = true;
		if (this == obj) {
			res = true;
		} else if (obj == null) {
			res = false;
		} else if (getClass() != obj.getClass()) {
			res = false;
		} else {
			UsuarioPaciente p = (UsuarioPaciente) obj;
			if (DNI == null) {
				if (p.DNI != null) {
					res = false;
				}
			} else if (!DNI.equalsIgnoreCase(p.DNI))
				res = false;
		}
		return res;
	}
	
	/** Como se ha cambiado el equals, hay que sobreescribir el hashCode tambien **/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.toUpperCase().hashCode());
		return result;
	}
	
	/** Los pacientes se comparan segun su prioridad. En caso de empate, el que llegase antes **/
	@Override
	public int compareTo(UsuarioPaciente p) {
		if (prioridad == p.prioridad) {
			return entrada.compareTo(p.entrada);	//devuelve < 0 si es mas antigua
		} else {
			return prioridad - p.prioridad;		//devuelve < 0 si tiene mas prioridad (num mas pequeño)
		}
	}
	
}
