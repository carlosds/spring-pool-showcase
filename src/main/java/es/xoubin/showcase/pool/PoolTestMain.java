package es.xoubin.showcase.pool;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.xoubin.showcase.pool.dao.PersonaDao;
import es.xoubin.showcase.pool.entity.Persona;

public class PoolTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/spring-pool-showcase-hikaricp-applicationContext.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/spring-pool-showcase-c3p0-applicationContext.xml");
		PersonaDao personaDao = (PersonaDao) ctx.getBean("personaDao");
		List<Persona> personas = personaDao.getAll();
		for (Persona p : personas) {
			System.out.println("Persona: " + p.getNombre());
		}
	}

}