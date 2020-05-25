package ColaAmpliada;
import static org.mockito.Mockito.*;

import java.util.PriorityQueue;

import static org.junit.Assert.*;
import org.junit.*;

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
	public void inicialmenteLaColaDePacientesEstaVacia() {
		assertTrue(ca.getColaPacientes().isEmpty());
	}
	
	@Test
	public void inicialmenteLaListaDeDoctoresEstaVacia() {
		assertTrue(ca.getListaDoctores().isEmpty());
	}
	
	@Test (expected = NoSuchElementException)
	public void siSeQuitaUnPacienteNoExistenteSeElevaExcepcion() {
		ca.quitarPaciente();
	}
}
