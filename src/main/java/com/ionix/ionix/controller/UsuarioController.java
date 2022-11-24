package com.ionix.ionix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.ionix.ionix.entity.Usuario;
import com.ionix.ionix.service.UsuarioService;

@RestController
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
    @PostMapping("/admin/addUsuarios")
    public Usuario saveUsuario(
        @Valid @RequestBody Usuario usuario)
    {
        return usuarioService.saveUsuario(usuario);
    }
 
    @GetMapping("/publico/listUsuarios")
    public List<Usuario> fetchUsuarioList()
    {
        return usuarioService.fetchUsuarios();
    }
    
    @GetMapping("/publico/findByEmail/{email}")
    public Usuario findByEmail(@PathVariable("email") String email)
    {
        return usuarioService.findByEmail(email);
    }
 
   
    @PutMapping("/publico/updateUsuarios/{id}")
    public Usuario updateUsuario(@RequestBody Usuario usuario,
                     @PathVariable("id") Long usuarioId)
    {
        return usuarioService.updateUsuario(
        		usuario, usuarioId);
    }
 
   
    @DeleteMapping("/admin/deleteUsuarios/{id}")
    public String deleteUsuarioById(@PathVariable("id")
                                       Long usuarioId)
    {
    	usuarioService.deleteUsuarioById(
    			usuarioId);
        return "Deleted Successfully";
    }
    
    /*@PostMapping()
    public String apiExterna(@PathVariable String rut) {
	    
    }*/
}

