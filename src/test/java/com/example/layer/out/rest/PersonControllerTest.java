package com.example.layer.out.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.layer.in.entity.Person;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoProcessor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonControllerTest {
	
	@Autowired
	private PersonController personController;

	@Test
	public void getPersonTest() {
		final Flux<Person> persons = this.personController.getPerson();
		Assert.assertNotNull(persons);
	}
	
	@Test
	public void getAdultsTest() {
		final Flux<Person> persons = this.personController.getAdults();
		final Mono<Boolean> result = persons.all(person -> person.getAge() > 17);
		
		Assert.assertEquals(true, result.block());
	}

	@Test
	public void test() {
		this.personController
				.getAdults()
				.awaitOnSubscribe()
				.doOnEach(System.out::println)
				.doOnComplete(() -> System.out.print("done"))
				.subscribe();

	}
}
