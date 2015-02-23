package es.xoubin.showcase.pool.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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

	public List<Person> getInId(List<Integer> listIds) {
		List<Person> persons = null;
		Session session = (Session) em.unwrap(Session.class);
		Criterion criterion = null;
		if (listIds.isEmpty()) {
			criterion = Restrictions.in("id", new ArrayList<String>(){{add(null);}});
		} else {
			criterion = Restrictions.in("id", listIds);
		}
		Criteria c = session.createCriteria(Person.class).add(criterion);
		persons = c.list();		
		return persons;
	}

}