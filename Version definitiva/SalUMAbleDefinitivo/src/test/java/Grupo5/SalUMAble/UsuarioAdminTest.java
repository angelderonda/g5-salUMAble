package Grupo5.SalUMAble;

import Grupo5.SalUMAble.MODEL.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UsuarioAdminTest{
	
	UsuarioAdministrador admin;
	
	@BeforeEach
	public void init() {
		admin = UsuarioAdministrador.getInstance();
	}
	
	@AfterEach
	public void terminate() {
		admin.deleteInstance();
	}
    
	@Test
	public void inicialmenteColasAmpliadasVacias() {
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
		UsuarioDoctor d = mock(UsuarioDoctor.class);
		RamaMedica rama = RamaMedica.MEDICINA_GENERAL;
		when(d.getRama()).thenReturn(rama);
		UsuarioPaciente p = mock(UsuarioPaciente.class);
		when(p.getRama()).thenReturn(rama);
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
		UsuarioDoctor d = mock(UsuarioDoctor.class);
		RamaMedica rama = RamaMedica.MEDICINA_GENERAL;
		when(d.getRama()).thenReturn(rama);
		//Registro el doctor
		int numDoctores = UsuarioAdministrador.getMap().get(rama).getListaDoctores().size();
		UsuarioAdministrador.RegistrarDoctor(d);
		int numDoctoresResultado = UsuarioAdministrador.getMap().get(rama).getListaDoctores().size();
		assertEquals(numDoctores+1, numDoctoresResultado);
	}
	
	@Test
	public void siSeRegistraUnPacienteElNumeroDePacienteAumentaEnUno() {
		UsuarioPaciente p = mock(UsuarioPaciente.class);
		RamaMedica rama = RamaMedica.MEDICINA_GENERAL;
		when(p.getRama()).thenReturn(rama);
		//Registro el doctor
		int numPacientes= UsuarioAdministrador.getMap().get(rama).getColaPacientes().size();
		UsuarioAdministrador.RegistrarPaciente(p);
		int numPacientesResultado = UsuarioAdministrador.getMap().get(rama).getColaPacientes().size();
		assertEquals(numPacientes+1, numPacientesResultado);
	}
	
	@Test
	public void siSeAsignaDoctorDejaDeEstarDisponible() {
		UsuarioDoctor d = mock(UsuarioDoctor.class);
		RamaMedica rama = RamaMedica.MEDICINA_GENERAL;
		when(d.getRama()).thenReturn(rama);
		UsuarioPaciente p = mock(UsuarioPaciente.class);
		when(p.getRama()).thenReturn(rama);
		//Registro el paciente y el doctor
		UsuarioAdministrador.RegistrarDoctor(d);
		UsuarioAdministrador.RegistrarPaciente(p);
		UsuarioAdministrador.AsignarDoctor(d);
		assertFalse(d.isDisponibilidad());
	}

}
