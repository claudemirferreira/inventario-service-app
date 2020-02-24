package com.setebit.inventario.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.setebit.inventario.enumerated.ProfileEnum;
import com.setebit.inventario.model.Usuario;

public class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(Usuario usuario) {
		JwtUser u = new JwtUser(String.valueOf(usuario.getId()), usuario.getEmail(), usuario.getSenha(),
				mapToGrantedAuthorities(usuario.getProfile()));
		return u;
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}

}