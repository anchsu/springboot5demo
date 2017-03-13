package com.example.layer.in.repo.impl;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.layer.in.entity.PersonMongo;

public interface MyMongoRepository extends ReactiveCrudRepository<PersonMongo, String> {

}
