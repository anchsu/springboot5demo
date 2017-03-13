package com.example.layer.out.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.layer.in.entity.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonControllerTest {
	
	//@Autowired
	//private PersonController personController;
	
	@Mock
	private PersonController personController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

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
	
	@Test
	public void testMock() {
		Mockito.when(this.personController.getAdults()).thenReturn(Flux.empty());
		Assert.assertEquals(Flux.empty(), this.personController.getAdults());

	}
}
