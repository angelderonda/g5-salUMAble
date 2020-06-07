package Grupo5.SalUMAble.MODEL;

import javax.persistence.*;

import java.util.EnumMap;
import java.util.List;
import java.util.PriorityQueue;

@Entity
@Table(name = "usuario_administrador")
public class UsuarioAdministrador extends Usuario {
	private static EnumMap<RamaMedica, ColaAmpliada> map;
	
	/////////////////////// Uso del patron de diseno Singleton //////////////////////////////////
	private static UsuarioAdministrador instance = null;

	/** Constructor privado de la clase **/
	private UsuarioAdministrador() {
		map = new EnumMap<RamaMedica, ColaAmpliada>(RamaMedica.class);
		inicializa();
	}
	
	/** Recorre cada enumerado de la RamaMedica y mete en el mapa la rama y su respectiva cola ampliada vacia **/
	private void inicializa() {
		for (RamaMedica rama : RamaMedica.values()) {
			map.put(rama, new ColaAmpliada());
		}
	}
	
	/** Crea una instancia de UsuarioAdministrador solo una vez **/
	public static UsuarioAdministrador getInstance() {
		if (instance == null) {
			instance = new UsuarioAdministrador();
		}
		return instance;
	}
	
	///////////////////////////////////// Metodos de UsuarioAdministrador /////////////////////////////////
	
	/** Obtenemos la rama asociada al paciente y lo anadimos en el mapa **/
	public static void RegistrarPaciente(UsuarioPaciente p) { // llamar a metodo cola ampliada
	RamaMedica rama = p.getRama();
	map.get(rama).anadirPaciente(p);
	}
	
	/** Obtenemos la rama asociada al doctor y lo anadimos en el mapa **/
	public static void RegistrarDoctor(UsuarioDoctor d) {
	RamaMedica rama = d.getRama();
	map.get(rama).anadirDoctor(d);
	}
	
	/**
	 * Recibimos el doctor d, al cual le tenemos que asignar el primer paciente (mas
	 * prioratorio) de la cola de pacientes sin doctor asignado de la ramaMedica en
	 * la que ambos se encuentran. Para ello obtenemos la rama y la instancia cola
	 * que se corresponde con ella. Despues, quitamos el paciente y cambiamos la
	 * disponibilidad del doctor, para finalmente actualizar el estado de las colas.
	 **/
	public static void AsignarDoctor(UsuarioDoctor d) {
		RamaMedica rama = d.getRama();
		
		if(!map.get(rama).colaPacientes.isEmpty()) {
			UsuarioPaciente p = map.get(rama).obtenPaciente();
			p.setEstado(EstadoPaciente.EN_CONSULTA);
			d.setPacienteActual(p);
			p.setDoctorAsignado(d);
			// Quitar el paciente de la rama medica del doctor
			map.get(rama).quitarPaciente();
			// Modificar la disponibilidad del doctor
			d.setDisponibilidad(false);
			d.setPacienteAsignado(true);
		}
		
	}
	
	public static void inicializaListas(List<Usuario> lista) {
		for (Usuario usuario : lista) {
			if (usuario.getRoles().equalsIgnoreCase("ROLE_DOCTOR")) {
				UsuarioDoctor d = (UsuarioDoctor) usuario;
				map.get(d.getRama()).anadirDoctor(d);
			} else if (usuario.getRoles().equalsIgnoreCase("ROLE_PACIENTE")) {
				UsuarioPaciente p = (UsuarioPaciente) usuario;
				if (p.getEstado() == EstadoPaciente.EN_ESPERA) {
					p.getRama();
					map.get(p.getRama()).anadirPaciente(p);	
				}		
			}
		}
	}
	
	public static boolean colaPacientesVacia(RamaMedica rama) {
		return map.get(rama).colaPacientes.isEmpty();
	}
	
	///////////////////////////////////// Getters y Setters //////////////////////////////////////////////

	public static EnumMap<RamaMedica, ColaAmpliada> getMap() {
		return map;
	}

	public static void setMap(EnumMap<RamaMedica, ColaAmpliada> map) {
		UsuarioAdministrador.map = map;
	}
	
	private static UsuarioDoctor getDoctor(int id, RamaMedica rama) {
        ColaAmpliada ca = map.get(rama);
        List<UsuarioDoctor> lista = ca.getListaDoctores();
        UsuarioDoctor d = null;
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i<lista.size()) {
            d = lista.get(i);
            if (d.getId() == id) {
                encontrado = true;
            } else {
                d = null;
            }
            i++;
        }
        return d;
    }

    private static UsuarioPaciente getPaciente(int id, RamaMedica rama) {
        ColaAmpliada ca = map.get(rama);
        PriorityQueue<UsuarioPaciente> cola = ca.getColaPacientes();
           for(UsuarioPaciente paciente : cola) {
               if (paciente.getId() == id) {
                   return paciente;
               }
           }
        return null;
    }

    public static UsuarioPaciente getPaciente(int id) {
        boolean encontrado = false;
        RamaMedica[] ramas = RamaMedica.values();
        int i = 0;
        UsuarioPaciente p = null;
        while (!encontrado && i< ramas.length) {
            p = getPaciente(id, ramas[i]);
            if (p != null) {
                encontrado = true;
            }
            i++;
        }
        return p;
    }

    public static UsuarioDoctor getDoctor(int id) {
        boolean encontrado = false;
        RamaMedica[] ramas = RamaMedica.values();
        int i = 0;
        UsuarioDoctor d = null;
        while (!encontrado && i < ramas.length ) {
            d = getDoctor(id, ramas[i]);
            if (d != null) {
                encontrado = true;
            }
            i++;
        }
        return d;
    }
	
	public static PriorityQueue<UsuarioPaciente> getColaPacientes(RamaMedica rama) {
		ColaAmpliada ca = map.get(rama);
		return ca.getColaPacientes();
	}

	public static List<UsuarioDoctor> getListaDoctores(RamaMedica rama) {
		ColaAmpliada ca = map.get(rama);
		return ca.getListaDoctores();
	}
	
	public static void deleteInstance() {
		instance = null;
	}
}
