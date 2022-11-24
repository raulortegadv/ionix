package com.ionix.ionix.service;

import java.util.List;

import com.ionix.ionix.entity.Usuario;

public interface UsuarioService {

	Usuario saveUsuario(Usuario usuario);
	List<Usuario> fetchUsuarios();
	Usuario updateUsuario(Usuario usuario,Long usuarioId);
	void deleteUsuarioById(Long usuarioId);
	public Usuario findByEmail(String email);
}
