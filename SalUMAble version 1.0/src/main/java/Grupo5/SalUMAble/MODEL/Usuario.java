package Grupo5.SalUMAble.MODEL;
public abstract class Usuario {
	
	private String ID;
	private String contraseña;
	
	@SuppressWarnings("unused")
	public void iniciarSesion(String id, String contr) {
		if (id.equals("admin") && contr.equals("admin")) {
			UsuarioAdministrador admin = new UsuarioAdministrador(); //aqui habria que coger la copia anterior en vez de uno nuevo
			admin.iniciarSesion();
		} else if (false) {//revisar contraseña en la lista de la base de datos TODO
			//Comprueba en la BD si el dni es de un doctor y lo localiza
			UsuarioDoctor doct = new UsuarioDoctor(); // coger el doctor encontrado
			doct.iniciarSesion();
		} else if (false) {//revisar contraseña en la lista de la base de datos TODO
			//Comprueba en la BD si el dni es de un paciente
			UsuarioPaciente pac = new UsuarioPaciente(); // coger el paciente encontrado
			pac.iniciarSesion();
		} else {
			//dar mensaje de error
		}
	}
	
	public abstract void cerrarSesion(); //TODO
	
	public abstract void mostrarAyuda(); //TODO
	
}
