package com.example.layer.in.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.layer.in.dao.PersonDao;
import com.example.layer.in.entity.Person;
import com.example.layer.in.repo.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private PersonRepository personRepository;
	
	public Mono<Person> getPerson(int id) {
		return personRepository.getPerson(id);
	}

	public Flux<Person> allPeople() {
		return personRepository.allPeople();
	}

	public Mono<Void> savePerson(Mono<Person> person) {
		return personRepository.savePerson(person);
	}

}
