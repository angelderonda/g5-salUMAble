package Grupo5.SalUMAble.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Grupo5.SalUMAble.MODEL.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<Usuario> listaUsuario() {  // Tiene en cuenta las mayusculas
        return userRepository.findAll();
    }

    public void save(Usuario p) {
        userRepository.saveAndFlush(p);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public Usuario getById(Integer id) {
        return userRepository.getOne(id);
    }

}