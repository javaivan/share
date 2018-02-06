package com.share.core;

import com.mongodb.MongoClient;
import com.share.core.model.Customer;
import com.share.core.repository.CustomerRepository;
import com.share.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
import org.springframework.boot.web.support.SpringBootServletInitializer;
*/

/*@ComponentScan
@EnableAutoConfiguration*/
@SpringBootApplication(scanBasePackages = "com.share")
public class Application   implements CommandLineRunner/*extends SpringBootServletInitializer*/ {
/*
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;
/*
	@Autowired
	private SequenceIdRepository sequenceIdRepository;

	@Autowired
	private MongoUserDetailsRepository mongoUserDetailsRepository;
*/
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MongoClient mongoClient;

	@Override
	public void run(String... args) throws Exception {

		customerRepository.deleteAll();
/*

		User user = new User();
		user.setEmail("test1");
		user.setPassword("test1");
		user.setLastName("test1");
		user.setFirstName("test1");
		user.setRoles(Arrays.asList("user","admin"));
		userRepository.save(user);
*/
        //sequenceIdRepository.deleteAll();
		//mongoUserDetailsRepository.deleteAll();

/*
		MongoUserDetails mongoUserDetails = new MongoUserDetails();
		mongoUserDetails.*/



            /*
        * db.users.insert({"name":"John","surname":"doe","email":"john@doe.com","password":"cleartextpass","authorities":["ROLE_USER","admin"]})
        * */

		//sequenceIdRepository.save(new SequenceId("user", 1L));
		/*String email = "john@doe.com";

		MongoDatabase database = mongoClient.getDatabase("app1");
		MongoCollection<Document> collection = database.getCollection("user");
		Document document = collection.find(Filters.eq("email",email)).first();
		document.toString();*/

		// save a couple of customers
		customerRepository.save(new Customer("Alice", "Smith"));
		customerRepository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(customerRepository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : customerRepository.findByLastName("Smith")) {
			System.out.println(customer);
		}

	}
}
