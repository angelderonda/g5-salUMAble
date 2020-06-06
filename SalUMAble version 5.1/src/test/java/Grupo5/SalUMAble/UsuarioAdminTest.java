package Grupo5.SalUMAble;

import Grupo5.SalUMAble.MODEL.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


public class UsuarioAdminTest{
    
	@Test
	public void inicialmenteColasAmpliadasVacias() {
		UsuarioAdministrador admin = new UsuarioAdministrador();
		int numColasVacias=0;
		for(ColaAmpliada cola : UsuarioAdministrador.getMap().values()) {
			if(cola.getListaDoctores().isEmpty() && cola.getColaPacientes().isEmpty()) {
				numColasVacias++;
			}
		}
		assertEquals(6,numColasVacias);
	}

	@Test
	public void siSeAsignaUnDoctorElNumeroDePacientesSeReduceEnUno() {
		UsuarioAdministrador admin = new UsuarioAdministrador();
		UsuarioDoctor d = mock(UsuarioDoctor.class);
		RamaMedica rama = RamaMedica.MEDICINA_GENERAL;
		when(d.getRamaMedica()).thenReturn(rama);
		UsuarioPaciente p = mock(UsuarioPaciente.class);
		when(p.getRamaMedica()).thenReturn(rama);
		//Registro el paciente y el doctor
		UsuarioAdministrador.RegistrarDoctor(d);
		UsuarioAdministrador.RegistrarPaciente(p);
		int numPacientes = UsuarioAdministrador.getMap().get(rama).getColaPacientes().size();
		UsuarioAdministrador.AsignarDoctor(d);
		int numPacientesResultado = UsuarioAdministrador.getMap().get(rama).getColaPacientes().size();
		assertEquals(numPacientes-1, numPacientesResultado);
	}
	
	@Test
	public void siSeRegistraUnDoctorElNumeroDeDoctoresAumentaEnUno() {
		UsuarioAdministrador admin = new UsuarioAdministrador();
		UsuarioDoctor d = mock(UsuarioDoctor.class);
		RamaMedica rama = RamaMedica.MEDICINA_GENERAL;
		when(d.getRamaMedica()).thenReturn(rama);
		//Registro el doctor
		int numDoctores = UsuarioAdministrador.getMap().get(rama).getListaDoctores().size();
		UsuarioAdministrador.RegistrarDoctor(d);
		int numDoctoresResultado = UsuarioAdministrador.getMap().get(rama).getListaDoctores().size();
		assertEquals(numDoctores+1, numDoctoresResultado);
	}
	
	@Test
	public void siSeRegistraUnPacienteElNumeroDePacienteAumentaEnUno() {
		UsuarioAdministrador admin = new UsuarioAdministrador();
		UsuarioPaciente p = mock(UsuarioPaciente.class);
		RamaMedica rama = RamaMedica.MEDICINA_GENERAL;
		when(p.getRamaMedica()).thenReturn(rama);
		//Registro el doctor
		int numPacientes= UsuarioAdministrador.getMap().get(rama).getColaPacientes().size();
		UsuarioAdministrador.RegistrarPaciente(p);
		int numPacientesResultado = UsuarioAdministrador.getMap().get(rama).getColaPacientes().size();
		assertEquals(numPacientes+1, numPacientesResultado);
	}
	
	@Test
	public void siSeAsignaDoctorDejaDeEstarDisponible() {
		UsuarioAdministrador admin = new UsuarioAdministrador();
		UsuarioDoctor d = mock(UsuarioDoctor.class);
		RamaMedica rama = RamaMedica.MEDICINA_GENERAL;
		when(d.getRamaMedica()).thenReturn(rama);
		UsuarioPaciente p = mock(UsuarioPaciente.class);
		when(p.getRamaMedica()).thenReturn(rama);
		//Registro el paciente y el doctor
		UsuarioAdministrador.RegistrarDoctor(d);
		UsuarioAdministrador.RegistrarPaciente(p);
		UsuarioAdministrador.AsignarDoctor(d);
		assertFalse(d.isDisponibilidad());
	}

}
