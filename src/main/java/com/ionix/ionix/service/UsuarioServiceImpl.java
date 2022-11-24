package com.ionix.ionix.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionix.ionix.entity.Usuario;
import com.ionix.ionix.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> fetchUsuarios() {
		 return (List<Usuario>)usuarioRepository.findAll();
	}

	@Override
	public Usuario updateUsuario(Usuario usuario, Long usuarioId) {
		Usuario userDB
        = usuarioRepository.findById(usuarioId)
              .get();

    if (Objects.nonNull(usuario.getName())
        && !"".equalsIgnoreCase(
        		usuario.getName())) {
        userDB.setName(
        		usuario.getName());
    }

    if (Objects.nonNull(
    		usuario.getUserName())
        && !"".equalsIgnoreCase(
        		usuario.getUserName())) {
        userDB.setUserName(
        		usuario.getUserName());
    }

    if (Objects.nonNull(usuario.getEmail())
        && !"".equalsIgnoreCase(
        		usuario.getEmail())) {
        userDB.setEmail(
        		usuario.getEmail());
    }
    
    if (Objects.nonNull(usuario.getPhone())
            && !"".equalsIgnoreCase(
            		usuario.getPhone())) {
            userDB.setPhone(
            		usuario.getPhone());
        }

    return usuarioRepository.save(userDB);
    
	}

	@Override
	public void deleteUsuarioById(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);
		
	}

	@Override
    public Usuario findByEmail(String email) {

        return usuarioRepository.findByEmail(email);
    }

}
