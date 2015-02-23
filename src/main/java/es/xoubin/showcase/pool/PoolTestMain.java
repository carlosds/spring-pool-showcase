package es.xoubin.showcase.pool;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.xoubin.showcase.pool.dto.PersonDto;
import es.xoubin.showcase.pool.service.PersonService;

public class PoolTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/spring-pool-showcase-hikaricp-applicationContext.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/spring-pool-showcase-c3p0-applicationContext.xml");
		PersonService personService = ctx.getBean("personService", PersonService.class);
//		List<PersonDto> persons = personService.getAll();
//		for (PersonDto p : persons) {
//			System.out.println("Person: " + p.getName());
//		}
//		List<Integer> listIds = new ArrayList<Integer>() {
//			{add(1); add(2); add(3); add(4);}
//		};
		List<Integer> listIds = new ArrayList<Integer>();
		List<PersonDto> persons = personService.getInId(listIds);
		for (PersonDto p : persons) {
			System.out.println("Persons in id: " + p.getId() + ", " + p.getName());
		}
	}

}