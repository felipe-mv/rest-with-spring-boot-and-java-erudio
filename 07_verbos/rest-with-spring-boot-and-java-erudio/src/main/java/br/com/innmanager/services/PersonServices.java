package br.com.innmanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.innmanager.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName()); 
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
			
		return persons ;
	}
		
	public Person findById(String id) {
		logger.info("Finding one person!");
		
		Person person = new Person();		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Lendro");
		person.setLastName("Costa");
		person.setAddress("Vila verde");
		person.setGender("Male");
		
		return person;
	}
	
	public Person create(Person person) {
		
		logger.info("Creating one person!");
		
		return person;
	}
	
	public Person update(Person person) {
		
		logger.info("Creating one person!");
		
		return person;
	}
	
	public void delete(String id) {
		
		logger.info("Deleting one person!");
		
	}
	
	private Person mockPerson(int i) {
		
		Person person = new Person();		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Name " + i);
		person.setLastName("Last" + i);
		person.setAddress("Address" + i);
		person.setGender("Gender" + i);
		
		return person;
	}
	
}
