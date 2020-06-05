package Grupo5.SalUMAble.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Grupo5.SalUMAble.MODEL.MyUserDetails;
import Grupo5.SalUMAble.MODEL.UserRepository;
import Grupo5.SalUMAble.MODEL.Usuario;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Optional<Usuario> user = userRepository.findByUserName(userName);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		
		return user.map(MyUserDetails::new).get();
	}
}
