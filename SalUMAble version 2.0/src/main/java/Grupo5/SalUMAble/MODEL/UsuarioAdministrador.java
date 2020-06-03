package Grupo5.SalUMAble.MODEL;
import javax.persistence.*;

import java.util.HashMap;
import java.util.PriorityQueue;

@Entity
@Table(name = "usuario_administrador")
public class UsuarioAdministrador extends Usuario{
	private static HashMap<RamaMedica,ColaAmpliada> map;
	
	public UsuarioAdministrador() {
		map = new HashMap<RamaMedica, ColaAmpliada>();
		inicializa();
	}
	
	public static HashMap<RamaMedica, ColaAmpliada> getMap() {
		return map;
	}
	public static void setMap(HashMap<RamaMedica, ColaAmpliada> map) {
		UsuarioAdministrador.map = map;
	}

	/**
	 * Obtenemos la rama asociada al paciente y lo a�adimos en el mapa 
	 * @param p
	 */
	
	public void RegistrarPaciente(UsuarioPaciente p) { //llamar a metodo cola ampliada
		RamaMedica rama = p.getRamaMedica();		
		map.get(rama).anadirPaciente(p);
	}
	/**
	 * Obtenemos la rama asociada al doctor y lo añadimos en el mapa 
	 * @param d
	 */
	public void RegistrarDoctor(UsuarioDoctor d) {
		RamaMedica rama = d.getRamaMedica();	
		map.get(rama).anadirDoctor(d);
	}
	/**
	 * Recibimos el doctor d, al cual le tenemos que asignar el primer paciente (mas prioratorio) de la cola de pacientes sin doctor 
	 * asignado de la ramaMedica en la que ambos se encuentran. Para ello obtenemos la rama y la instancia cola que se corresponde
	 * con ella. Despu�s, quitamos el paciente y cambiamos la disponibilidad del doctor, para finalmente actualizar el estado de las colas.
	 * @param d
	 */
	public void AsignarDoctor(UsuarioDoctor d) {
		//Suponemos que el doctor esta disponible si no lo podriamos haber clickado
		RamaMedica rama = d.getRamaMedica();
		//Quitar el paciente de la rama medica del doctor
		map.get(rama).quitarPaciente();
		
		//Modificar la disponibilidad del doctor
		d.setDisponibilidad(false);		
	}
	/**
	 * Inicializa -> Realizamos un for donde nos recorremos cada enumerado de la RamaMedica
	 *   y vamos metiendo en el mapa la rama y su respectiva cola ampliada vacia
	 */
	private void inicializa() {
		for(RamaMedica rama : RamaMedica.values()){
			map.put(rama, new ColaAmpliada());
		}
    }

	
	public static PriorityQueue<UsuarioPaciente> getColaPacientes(RamaMedica rama) {
		 ColaAmpliada ca = map.get(rama);
	       return ca.getColaPacientes();
	}
	//TODO
	public void iniciarSesion() {
		
	}

}
