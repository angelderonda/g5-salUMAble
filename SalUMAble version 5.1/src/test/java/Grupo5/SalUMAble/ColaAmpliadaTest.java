package Grupo5.SalUMAble;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.*;

import Grupo5.SalUMAble.MODEL.ColaAmpliada;
import Grupo5.SalUMAble.MODEL.UsuarioDoctor;
import Grupo5.SalUMAble.MODEL.UsuarioPaciente;


public class ColaAmpliadaTest {
	
	ColaAmpliada ca;
	
	@Before
	public void init() {
		ca = new ColaAmpliada();
	}
	
	@After
	public void terminate() {
		ca = null;
	}
	
	@Test
	public void inicialmenteColasAmpliadasVacias() {
		boolean empty = false;
		if(ca.getListaDoctores().isEmpty() && ca.getColaPacientes().isEmpty()) {
			empty = true;
		}
		assertTrue(empty);
	}

	@Test
	public void siSeAnadeUnPacienteLaColaAumentaEnUno() {
		UsuarioPaciente p = mock(UsuarioPaciente.class);
		int numPacientes = ca.getColaPacientes().size();
		ca.anadirPaciente(p);
		int numPacientesResultado = ca.getColaPacientes().size();
		assertEquals(numPacientes+1, numPacientesResultado);
	}
	
	@Test
	public void siSeAnadeUnDoctorLaListaAumentaEnUno() {
		UsuarioDoctor d = mock(UsuarioDoctor.class);
		int numDoctores = ca.getListaDoctores().size();
		ca.anadirDoctor(d);
		int numDoctoresResultado = ca.getListaDoctores().size();
		assertEquals(numDoctores+1, numDoctoresResultado);
	}
	
	@Test
	public void siSeQuitaUnPacienteLaColaDisminuyeEnUno() {
		UsuarioPaciente p = mock(UsuarioPaciente.class);
		ca.anadirPaciente(p);
		int numPacientes = ca.getColaPacientes().size();
		ca.quitarPaciente();
		int numPacientesResultado = ca.getColaPacientes().size();
		assertEquals(numPacientes-1, numPacientesResultado);
	}
	
	@Test
	public void siSeQuitaUnDoctorLaListaDisminuyeEnUno() {
		UsuarioDoctor d = mock(UsuarioDoctor.class);
		ca.anadirDoctor(d);
		int numDoctores = ca.getListaDoctores().size();
		ca.quitarDoctor(d);
		int numDoctoresResultado = ca.getListaDoctores().size();
		assertEquals(numDoctores-1, numDoctoresResultado);
	}

}
