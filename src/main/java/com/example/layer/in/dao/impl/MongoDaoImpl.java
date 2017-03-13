package com.example.layer.in.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.layer.in.dao.MongoDao;
import com.example.layer.in.entity.PersonMongo;
import com.example.layer.in.repo.impl.MyMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MongoDaoImpl implements MongoDao {

	@Autowired
	private MyMongoRepository repository;

	@Override
	public Flux<PersonMongo> allPeople() {
		return repository.findAll();
	}

	@Override
	public Mono<Void> savePerson(Mono<PersonMongo> person) {
		return repository.save(person).then();
	}

}
