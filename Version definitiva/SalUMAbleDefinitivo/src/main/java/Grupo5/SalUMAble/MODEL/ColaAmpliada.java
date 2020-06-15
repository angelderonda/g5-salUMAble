package Grupo5.SalUMAble.MODEL;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ColaAmpliada {
	
	ArrayList<UsuarioDoctor> listaDoctores;
	PriorityQueue<UsuarioPaciente> colaPacientes;
	
	private RamaMedica rama;
	
	// Constructor de ColaAmpliada
	public ColaAmpliada() {
		listaDoctores = new ArrayList<UsuarioDoctor>();
		colaPacientes = new PriorityQueue<UsuarioPaciente>();
	}
	
	public void anadirPaciente(UsuarioPaciente p) {
		colaPacientes.add(p);
	}

	public void quitarPaciente() {
		if (!colaPacientes.isEmpty()) {
			colaPacientes.remove();
		}
	}
	
	public void anadirDoctor(UsuarioDoctor doctor) {
		listaDoctores.add(doctor);
	}
	
	public void quitarDoctor(UsuarioDoctor doctor) {
		if (!listaDoctores.isEmpty()) {
			listaDoctores.remove(doctor);
		}
	}
	
	public UsuarioPaciente obtenPaciente() {
		return colaPacientes.element();
	}
	
	////////////////////////////////// GETTERS Y SETTERS //////////////////////////////////////////

	public RamaMedica getRama() {
		return rama;
	}

	public void setRama(RamaMedica rama) {
		this.rama = rama;
	}
	
	public void setColaPacientes(PriorityQueue<UsuarioPaciente> colaPacientes) {
		this.colaPacientes = colaPacientes;
	}
	
	public ArrayList<UsuarioDoctor> getListaDoctores() {
		return listaDoctores;
	}

	public PriorityQueue<UsuarioPaciente> getColaPacientes() {
		return colaPacientes;
	}
	
}