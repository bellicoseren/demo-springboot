package com.example.demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Usuario;
import com.example.demo.repo.IUsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	@Test
	public void crearUsuarioTest() {
		
		Usuario usuario = new Usuario();
		usuario.setId(2);
		usuario.setNombre("Kevonito");
		usuario.setClave(bCrypt.encode("123456"));
		
		Usuario usuarioRetorno = repo.save(usuario);
		assertTrue(usuarioRetorno.getClave().equalsIgnoreCase(usuario.getClave()));
	}

}
