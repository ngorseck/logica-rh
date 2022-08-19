package com.logica.rh;

import com.logica.rh.service.DepartmentService;
import com.logica.rh.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(classes = LogicaRhApplication.class)
public class ApplicationTests {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	CacheManager cacheManager;

	@Container
	static MySQLContainer mysql = new MySQLContainer("mysql:8.0")
				.withDatabaseName("logica-rh")
				.withUsername("user")
				.withPassword("password");

	/*@ Container
	static GenericContainer redis = new GenericContainer<>("redis:5.0.3-alpine")
			.withExposedPorts(6379);*/

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", () -> mysql.getJdbcUrl() + "?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&autoReconnect=true");
		registry.add("spring.datasource.username", mysql::getUsername);
		registry.add("spring.datasource.password", mysql::getPassword);
		/*registry.add("spring.cache.type", () -> "redis");
		registry.add("spring.redis.host", redis::getHost);
		registry.add("spring.redis.port", redis::getFirstMappedPort);
		registry.add("spring.redis.timeout", () -> 60000);
		registry.add("spring.redis.connect-timeout", () -> 60000);*/
	}

	@Test
	void testCountryService() {
		// test getCountries
		assertThat(departmentService.getDepartments().size()).isEqualTo(5);
		/*
		// test getCountry
		String name = "france";
		Country country = countryService.getCountry(name);
		assertThat(country).isNotNull();
		assertThat(cacheManager.getCache("countries").get(name).get())
				.isEqualTo(country);

		//test createCountry
		country = countryService.createCountry(new Country("italy", "rome", 121212212));
		assertThat(country).isNotNull();
		assertThat(cacheManager.getCache("countries").get("italy"))
				.isNull();

		//test updateCountry
		country = countryService.updateCountry("italy",
				new Country("italy", "palerme", 12129999));
		assertThat(country.getCapital()).isEqualTo("palerme");
		assertThat(country.getPopulation()).isEqualTo(12129999);
		assertThat(cacheManager.getCache("countries").get("italy").get())
				.isEqualTo(country);

		//test deleteCountry
		countryService.deleteCountry("italy");
		assertThat(cacheManager.getCache("countries").get("italy"))
				.isNull();*/
	}

	@Test
	void testPersonService() {
		/*
		// test getPersons
		assertThat(personService.getPersons(PageRequest.of(0,3)).getContent().size()).isEqualTo(2);

		// test getPerson
		Long id = 1L;
		Person person = personService.getPerson(id);
		assertThat(person).isNotNull();
		assertThat(cacheManager.getCache("persons").get(id).get())
				.isEqualTo(person);

		// test createPerson
		Country country = countryService.getCountry("france");
		person = new Person(null, "John", "Doe", country);
		person = personService.createPerson(person);
		assertThat(person).isNotNull();
		assertThat(person.getId()).isEqualTo(3L);
		assertThat(cacheManager.getCache("persons").get(person.getId()))
				.isNull();

		// test updatePerson
		person.setFirstName("Johnny");
		person.setLastName("Deep");
		person = personService.updatePerson(person.getId(), person);
		assertThat(cacheManager.getCache("persons").get(person.getId()).get())
				.isEqualTo(person);

		// test deletePerson
		personService.deletePerson(person.getId());
		assertThat(cacheManager.getCache("persons").get(person.getId()))
				.isNull();*/
	}

}
