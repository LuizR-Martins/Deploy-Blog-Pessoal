package org.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.blogpessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTeste {
	@Autowired
	private UsuarioRepository usuariorepository;
	
	@BeforeAll
	void start () {
		usuariorepository.save(new Usuario(0L,"Dj Cleitom Rasta", "cleitinho@pedrada.com", "cabeça de gelo", "https://imagens.ne10.uol.com.br/veiculos/_midias/jpg/2020/07/10/806x444/1_dj_cleiton_rasta_perfil_body_image_1474918939-16274795.jpg\r\n"
				+ "")); 
	}
	@Test
	@DisplayName("Retorna apenas um usario ")
	public void deveretornarUmUsuario() {
		Optional<Usuario> usuario = usuariorepository.findByUsuario("Dj Cleitom Rasta");
				assertTrue(usuario.get().getUsuario().equals("Dj Cleitom Rasta"));

	}
	@Test 
	@DisplayName("Retorna dois usuarios")
	public void deveretornarDoisUsuarios( ) {
		List<Usuario> listaDeUsuarios = usuariorepository.findAllByNomeContainingIgnoreCase("Dj");
		assertEquals(2, listaDeUsuarios.size());
		
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Dj Cleitom Rasta"));
	}
	
}
