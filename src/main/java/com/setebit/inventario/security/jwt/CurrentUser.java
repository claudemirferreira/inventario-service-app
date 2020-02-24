package com.setebit.inventario.security.jwt;

import com.setebit.inventario.dto.UsuarioDTO;

public class CurrentUser {

	private String token;
	private UsuarioDTO user;

	public CurrentUser(String token, UsuarioDTO user) {
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UsuarioDTO getUser() {
		return user;
	}

	public void setUser(UsuarioDTO user) {
		this.user = user;
	}

}