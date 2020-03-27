package com.setebit.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.setebit.inventario.enumerated.ProfileEnum;
import com.setebit.inventario.model.Usuario;
import com.setebit.inventario.repository.UsuarioRepository;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UsuarioRepository rep, PasswordEncoder passwordEncoder) {
		return args -> {
			initUsuario(rep, passwordEncoder);
		};

	}

	private void initUsuario(UsuarioRepository rep, PasswordEncoder passwordEncoder) {
		Usuario admin = new Usuario();
		admin.setEmail("admin@gmail.com");
		admin.setSenha(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		admin.setLogin("admin");
		admin.setNome("Administrador");
		admin.setStatus("1");

		Usuario find = rep.findByLogin("admin");
		if (find == null) {
			rep.save(admin);
		}
	}

}
