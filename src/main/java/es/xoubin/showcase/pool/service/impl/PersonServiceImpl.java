package es.xoubin.showcase.pool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.xoubin.showcase.pool.dao.PersonDao;
import es.xoubin.showcase.pool.dto.PersonDto;
import es.xoubin.showcase.pool.entity.Person;
import es.xoubin.showcase.pool.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;

	@Override
	public List<PersonDto> getAll() {
		List<Person> listEntity = personDao.getAll();
		return this.mapToDto(listEntity);
	}
	
	@Override
	@Transactional
	public List<PersonDto> getInId(List<Integer> listIds) {
		List<Person> listEntity = this.personDao.getInId(listIds);
		return mapToDto(listEntity);
	}
	
	private List<PersonDto> mapToDto(List<Person> listEntity) {
		List<PersonDto> ret = new ArrayList<PersonDto>(listEntity.size());
		for (Person p : listEntity) {
			ret.add(this.mapToDto(p));
		}
		return ret;
	}
	
	private PersonDto mapToDto(Person e) {
		PersonDto p = new PersonDto();
		p.setId(e.getId());
		p.setName(e.getName());
		p.setSurname(e.getSurname());
		return p;
	}	
	
}
