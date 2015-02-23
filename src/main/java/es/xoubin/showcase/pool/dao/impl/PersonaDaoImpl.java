package es.xoubin.showcase.pool.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import es.xoubin.showcase.pool.dao.PersonaDao;
import es.xoubin.showcase.pool.entity.Persona;

@Service("personaDao")
public class PersonaDaoImpl implements PersonaDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Persona> getAll() {
		Query query = em.createQuery("SELECT p from Persona as p");
        return query.getResultList();
	}

}