package Grupo5.SalUMAble;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import Grupo5.SalUMAble.MODEL.UsuarioDoctor;
import Grupo5.SalUMAble.MODEL.UsuarioPaciente;

public class UsuarioDoctorTest {
	
	@Test
	public void siMismoDNISonIguales() {
		UsuarioDoctor doctor1 = new UsuarioDoctor();
		UsuarioDoctor doctor2 = new UsuarioDoctor();
		doctor1.setDNI("12345678P");
		doctor2.setDNI("12345678P");
		assertTrue(doctor1.equals(doctor2));
	}
	
	@Test
	public void siDistintoDNINoSonIguales() {
		UsuarioDoctor doctor1 = new UsuarioDoctor();
		UsuarioDoctor doctor2 = new UsuarioDoctor();
		doctor1.setDNI("12345678P");
		doctor2.setDNI("87654321Q");
		assertFalse(doctor1.equals(doctor2));
	}
	
	@Test
	public void siSeLiberaPacienteElDoctorNoTienePacienteAsignado() {
		UsuarioDoctor d = new UsuarioDoctor();
		UsuarioPaciente p = mock(UsuarioPaciente.class);
		d.setPacienteActual(p);
		d.liberarPaciente();
		assertTrue(d.getPacienteActual() == null);
	}

}
