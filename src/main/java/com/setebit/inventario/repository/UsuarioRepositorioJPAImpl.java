package com.setebit.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.setebit.inventario.model.Usuario;

@Repository
public class UsuarioRepositorioJPAImpl extends RepositorioGenerico implements UsuarioRepositorioJPA {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> findByUsuario(Usuario usuario) {

		StringBuilder sb = new StringBuilder();
		List<String> condictions = new ArrayList<String>();

		sb.append(" select usu from Usuario usu ");
		if (notEmpty(usuario)) {
			if (notEmpty(usuario.getNome())) {
				condictions.add(" lower( usu.nome ) like :nome ");
			}
			if (notEmpty(usuario.getLogin()) && usuario.getLogin().length() >= 0) {
				condictions.add(" usu.login = :login ");
			}
			if (usuario.getIdMembro() > 0) {
				condictions.add(" usu.idMembro = :idMembro ");
			}
		}

		String orderBy = " order by usu.nome ";

		Query query = entityManager.createQuery(generateHql(sb.toString(), condictions) + orderBy);

		if (notEmpty(usuario)) {
			if (notEmpty(usuario.getNome())) {
				query.setParameter("nome", "%" + usuario.getNome() + "%");
			}
			if (notEmpty(usuario.getLogin()) && usuario.getLogin().length() >= 0) {
				query.setParameter("login", usuario.getLogin());
			}
			if (usuario.getIdMembro() > 0) {
				query.setParameter("idMembro", usuario.getIdMembro());
			}
		}

		return query.getResultList();
	}

}