package es.xoubin.showcase.pool.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import es.xoubin.showcase.pool.dao.PersonDao;
import es.xoubin.showcase.pool.entity.Person;

@Service("personDao")
public class PersonDaoImpl implements PersonDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Person> getAll() {
		Query query = em.createQuery("SELECT p from Person as p");
        return query.getResultList();
	}

}