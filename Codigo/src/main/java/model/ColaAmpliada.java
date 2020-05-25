import java.util.ArrayList;
import java.util.PriorityQueue;

public class ColaAmpliada {
    ArrayList<UsuarioDoctor> listaDoctores;
    PriorityQueue<UsuarioPaciente> colaPacientes;

    public ColaAmpliada() {
        listaDoctores = new ArrayList<UsuarioDoctor>();
        colaPacientes = new PriorityQueue<UsuarioPaciente>();
    }

    
	public void anadirPaciente(UsuarioPaciente p) { //Poner en diagrama de clase tipo void
        colaPacientes.add(p); //Implementar bien el compareTo del usuarioPaciente(en funcion de la prioridad)
    }
    
    public void quitarPaciente() {
    	colaPacientes.remove();
    }
    
    //A partir de aquí añadir al diagrama de clases
    public void anadirDoctor(UsuarioDoctor d) { //Poner en diagrama de clase tipo void
      listaDoctores.add(d); 
    }
    
    //
    
    public ArrayList<UsuarioDoctor> getListaDoctores() {
		return listaDoctores;
	}

	public PriorityQueue<UsuarioPaciente> getColaPacientes() {
		return colaPacientes;
	}

    

}