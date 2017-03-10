package com.example.layer.process.action.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.layer.in.dao.PersonDao;
import com.example.layer.in.entity.Person;
import com.example.layer.process.action.PersonAction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonActionImpl implements PersonAction {

	@Autowired
	private PersonDao personDao;
	
	@Override
	public Mono<Person> getPerson(int id) {
		return personDao.getPerson(id);
	}

	@Override
	public Flux<Person> allPeople() {
		return personDao.allPeople();
	}

	@Override
	public Mono<Void> savePerson(Mono<Person> person) {
		return personDao.savePerson(person);
	}

}
