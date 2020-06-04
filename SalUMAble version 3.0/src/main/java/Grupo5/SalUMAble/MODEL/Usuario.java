package Grupo5.SalUMAble.MODEL;
import javax.persistence.*;

@Entity
@Table(name = "User")
@Inheritance(
    strategy = InheritanceType.JOINED
)
public abstract class Usuario {
	
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	private String password;
	private boolean active;
	protected String roles;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
//	@SuppressWarnings("unused")
//	public void iniciarSesion(String id, String contr) {
//		if (id.equals("admin") && contr.equals("admin")) {
//			UsuarioAdministrador admin = new UsuarioAdministrador(); //aqui habria que coger la copia anterior en vez de uno nuevo
//			admin.iniciarSesion();
//		} else if (false) {//revisar contraseña en la lista de la base de datos TODO
//			//Comprueba en la BD si el dni es de un doctor y lo localiza
//			UsuarioDoctor doct = new UsuarioDoctor(); // coger el doctor encontrado
//			doct.iniciarSesion();
//		} else if (false) {//revisar contraseña en la lista de la base de datos TODO
//			//Comprueba en la BD si el dni es de un paciente
//			UsuarioPaciente pac = new UsuarioPaciente(); // coger el paciente encontrado
//			pac.iniciarSesion();
//		} else {
//			//dar mensaje de error
//		}
//	}
//	
//	public abstract void cerrarSesion(); //TODO
//	
//	public abstract void mostrarAyuda(); //TODO
	
}
