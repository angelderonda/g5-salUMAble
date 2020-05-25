package Grupo5.SalUMAble;

import Grupo5.SalUMAble.MODEL.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioAdminTest{
	UsuarioAdministrador admin;
	@Before
    public void init() {
        admin = new UsuarioAdministrador();
    }

    @After
    public void terminate() {
        admin = null;
    }
	@Test
	public void inicialmenteColasAmpliadasVacias() {
		int numColasVacias=0;
		for(ColaAmpliada cola : admin.getMap().values()) {
			if(cola.getListaDoctores().isEmpty() && cola.getColaPacientes().isEmpty()) {
				numColasVacias++;
			}
		}
		assertEquals(6,numColasVacias);
	}

	@Test
	public void siSeAsignaUnDoctorElNumeroDePacientesSeReduceEnUno() {
		UsuarioDoctor d = mock(UsuarioDoctor.class);
		int numPacientes;
		RamaMedica rama = RamaMedica.MEDICINA_GENERAL;
		when(d.getRamaMedica()).thenReturn(rama);
		UsuarioPaciente p = mock(UsuarioPaciente.class);
		when(p.getRamaMedica()).thenReturn(rama);
		//Registro el paciente y el doctor
		admin.RegistrarDoctor(d);
		admin.RegistrarPaciente(p);
		numPacientes = admin.getMap().get(rama).getColaPacientes().size();
		admin.AsignarDoctor(d);
		assertEquals(numPacientes-1,numPacientes);
	}
	@Test
	public void siSeRegistraUnDoctorElNumeroDeDoctoresAumentaEnUno() {
		UsuarioDoctor d = mock(UsuarioDoctor.class);
		int numDoctores;
		RamaMedica rama = RamaMedica.MEDICINA_GENERAL;
		when(d.getRamaMedica()).thenReturn(rama);
		//Registro el doctor
		numDoctores = admin.getMap().get(rama).getListaDoctores().size();
		admin.RegistrarDoctor(d);
		assertEquals(numDoctores+1,numDoctores);
	}
	@Test
	public void siSeRegistraUnPacienteElNumeroDePacienteAumentaEnUno() {
		UsuarioPaciente d = mock(UsuarioPaciente.class);
		int numPacientes;
		RamaMedica rama = RamaMedica.MEDICINA_GENERAL;
		when(d.getRamaMedica()).thenReturn(rama);
		//Registro el doctor
		numPacientes= admin.getMap().get(rama).getColaPacientes().size();
		admin.RegistrarPaciente(d);
		assertEquals(numPacientes+1,numPacientes);
	}
	

}
