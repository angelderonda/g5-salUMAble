package Grupo5.SalUMAble.MODEL;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.PriorityQueue;

public class prueba {

	public static void main(String[] args) {
		
		HashMap<RamaMedica,ColaAmpliada> map = new HashMap<RamaMedica, ColaAmpliada>();
		
		
		
		ArrayList<UsuarioDoctor>listaDoctores = new ArrayList<UsuarioDoctor>();
        PriorityQueue<UsuarioPaciente> colaPacientes = new PriorityQueue<UsuarioPaciente>();
        
        UsuarioDoctor d1 = new UsuarioDoctor();
        UsuarioDoctor d2 = new UsuarioDoctor();
        UsuarioDoctor d3 = new UsuarioDoctor();
        
        d1.setDNI("1");
        d2.setDNI("2");
        d3.setDNI("3");
        
        d1.setRama(RamaMedica.NEUMOLOGIA);
        d2.setRama(RamaMedica.NEUMOLOGIA);
        d3.setRama(RamaMedica.NEUMOLOGIA);
        
        listaDoctores.add(d1);
        listaDoctores.add(d2);
        listaDoctores.add(d3);
        
        
        Date date = new Date(System.currentTimeMillis());
		UsuarioPaciente paciente1 = new UsuarioPaciente("Pepe", "Gonzalez Ruiz", "24569420H", 3, RamaMedica.NEUMOLOGIA, date);
		UsuarioPaciente paciente2 = new UsuarioPaciente("Juan", "Fernandez Fernandez", "12345678T", 2, RamaMedica.NEUMOLOGIA, date);
        
		colaPacientes.add(paciente1);
		colaPacientes.add(paciente2);
		
		
			ColaAmpliada cola = new ColaAmpliada();
			cola.setColaPacientes(colaPacientes);
			cola.setListaDoctores(listaDoctores);
			
			map.put(RamaMedica.NEUMOLOGIA, cola);
			
			for (UsuarioDoctor doctor : map.get(RamaMedica.NEUMOLOGIA).getListaDoctores()) {
				System.out.println(doctor.toString());
			}
			
			d1.setDNI("$");
			
			for (UsuarioDoctor doctor : map.get(RamaMedica.NEUMOLOGIA).getListaDoctores()) {
				System.out.println(doctor.toString());
			}
	}

}
