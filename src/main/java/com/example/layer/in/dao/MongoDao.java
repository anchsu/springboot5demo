package com.example.layer.in.dao;

import com.example.layer.in.entity.PersonMongo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MongoDao {

	Flux<PersonMongo> allPeople();

	Mono<Void> savePerson(Mono<PersonMongo> person);

}
