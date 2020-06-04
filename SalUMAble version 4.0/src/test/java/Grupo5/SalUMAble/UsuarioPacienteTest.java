package Grupo5.SalUMAble;
import Grupo5.SalUMAble.MODEL.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.PriorityQueue;

import org.junit.*;




public class UsuarioPacienteTest {
	
	@Test
	public void siHayDosPacientesPrimeroElDeMayorPrioridad() {
		Date date = new Date(System.currentTimeMillis());
		UsuarioPaciente paciente1 = new UsuarioPaciente("Pepe", "Gonzalez Ruiz", "24569420H", 3, RamaMedica.NEUMOLOGIA, date);
		UsuarioPaciente paciente2 = new UsuarioPaciente("Juan", "Fernandez Fernandez", "12345678T", 2, RamaMedica.NEUMOLOGIA, date);
		assertTrue(paciente2.compareTo(paciente1) < 0);
	}
	
	@Test
	public void siHayDosPacientesDeIgualPrioridadElMasAntiguoMayorPrioridad() {
		Date date1 = new Date(System.currentTimeMillis());
		Date date2 = new Date(System.currentTimeMillis()+5);
		UsuarioPaciente paciente1 = new UsuarioPaciente("Pepe", "Gonzalez Ruiz", "24569420H", 2, RamaMedica.NEUMOLOGIA, date1);
		UsuarioPaciente paciente2 = new UsuarioPaciente("Juan", "Fernandez Fernandez", "12345678T", 2, RamaMedica.NEUMOLOGIA, date2);
		assertTrue(paciente1.compareTo(paciente2) < 0);
	}
	
	@Test
	public void siMismoDNISonIguales() {
		UsuarioPaciente paciente1 = new UsuarioPaciente("Pepe", "Gonzalez Ruiz", "24569420H", 2, RamaMedica.NEUMOLOGIA, new Date(System.currentTimeMillis()));
		UsuarioPaciente paciente2 = new UsuarioPaciente("Juan", "Fernandez Fernandez", "24569420H", 3, RamaMedica.TRAUMATOLOGIA, new Date(System.currentTimeMillis()));
		assertTrue(paciente1.equals(paciente2));
	}
	
	@Test
	public void siDistintoDNINoSonIguales() {
		UsuarioPaciente paciente1 = new UsuarioPaciente("Pepe", "Gonzalez Ruiz", "24569420H", 2, RamaMedica.NEUMOLOGIA, new Date(System.currentTimeMillis()));
		UsuarioPaciente paciente2 = new UsuarioPaciente("Pepe", "Gonzalez Ruiz", "12345678T", 2, RamaMedica.NEUMOLOGIA, new Date(System.currentTimeMillis()));
		assertFalse(paciente1.equals(paciente2));
	}
	
	@Test
	public void siHayUnPacienteDeMayorPrioridadTieneUnPacientePorDelante() {
		RamaMedica r = RamaMedica.NEUMOLOGIA;
		PriorityQueue<UsuarioPaciente> cola = new PriorityQueue<>();
		UsuarioPaciente paciente1 = new UsuarioPaciente("Pepe", "Gonzalez Ruiz", "24569420H", 3, r, new Date(System.currentTimeMillis()));
		UsuarioPaciente paciente2 = new UsuarioPaciente("Juan", "Fernandez Fernandez", "12345678T", 2, r, new Date(System.currentTimeMillis()));
		cola.add(paciente1);
		cola.add(paciente2);
		
		HashMap<RamaMedica, ColaAmpliada> map = new HashMap<>();
		map.put(r, mock(ColaAmpliada.class));
		UsuarioAdministrador.setMap(map);
		
		when(UsuarioAdministrador.getColaPacientes(r)).thenReturn(cola);
		
		assertEquals(1, paciente1.verPosicionEnCola());
	}

}
