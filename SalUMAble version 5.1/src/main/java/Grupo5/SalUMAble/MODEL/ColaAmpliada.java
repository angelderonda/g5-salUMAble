package Grupo5.SalUMAble.MODEL;

import java.util.ArrayList;
import java.util.PriorityQueue;
import javax.persistence.*;

//@Entity
public class ColaAmpliada {
	//@OneToMany (mappedBy = "listaDoctor", cascade= {CascadeType.REMOVE})
	ArrayList<UsuarioDoctor> listaDoctores;

	//@OneToMany (mappedBy = "cola", cascade= {CascadeType.REMOVE})
	@ElementCollection(targetClass = UsuarioPaciente.class)
	@CollectionTable(name = "lista_pacientes")
	@Column(name = "paciente") // Column name in person_interest	
	PriorityQueue<UsuarioPaciente> colaPacientes;
	/*
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Enumerated(value = EnumType.STRING)*/
	private RamaMedica rama;

	public ColaAmpliada() {
		listaDoctores = new ArrayList<UsuarioDoctor>();
		colaPacientes = new PriorityQueue<UsuarioPaciente>();
	}

	public RamaMedica getRama() {
		return rama;
	}

	public void setRama(RamaMedica rama) {
		this.rama = rama;
	}

	public void anadirPaciente(UsuarioPaciente p) { // Poner en diagrama de clase tipo void
		colaPacientes.add(p); // Implementar bien el compareTo del usuarioPaciente(en funcion de la prioridad)
	}

	public void quitarPaciente() {
		colaPacientes.remove();
	}

	// borrar despues
	public void setListaDoctores(ArrayList<UsuarioDoctor> listaDoctores) {
		this.listaDoctores = listaDoctores;
	}

	public void setColaPacientes(PriorityQueue<UsuarioPaciente> colaPacientes) {
		this.colaPacientes = colaPacientes;
	}

	public void quitarDoctor(UsuarioDoctor doctor) {
		listaDoctores.remove(doctor);
	}

	// A partir de anadir al diagrama de clases
	public void anadirDoctor(UsuarioDoctor doctor) { // Poner en diagrama de clase tipo void
		listaDoctores.add(doctor);
	}

	//

	public ArrayList<UsuarioDoctor> getListaDoctores() {
		return listaDoctores;
	}

	public PriorityQueue<UsuarioPaciente> getColaPacientes() {
		return colaPacientes;
	}

}