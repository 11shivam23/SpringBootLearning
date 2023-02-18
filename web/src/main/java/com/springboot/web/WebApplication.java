package com.springboot.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.springboot.web.model.UserModel;
import com.springboot.web.repository.UserRepository;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(WebApplication.class, args);

		// ApplicationContext context = SpringApplication.run(WebApplication.class, args);
		// UserRepository userRepository = context.getBean(UserRepository.class);

		//Save data of a user in DB
		// UserModel user = new UserModel();
		// user.setName("Shivam");
		// user.setCity("Meerut"); 
		// user.setStatus("I'm a java programmer");

		// UserModel user1 = userRepository.save(user);
		// System.out.println(user1);

		// CRUD Operations
		// UserModel userModel1 = new UserModel();
		// userModel1.setName("Chavi");
		// userModel1.setCity("Delhi");
		// userModel1.setStatus("I'm a HR");

		// UserModel userModel2 = new UserModel();
		// userModel2.setName("Shubhi");
		// userModel2.setCity("Gurgaon");
		// userModel2.setStatus("I'm a Senior Software Engineer");
		
		// // Saving single user
		// UserModel saveUser1 = userRepository.save(userModel2);
		// System.out.println(saveUser1);

		// //Saving multiple user
		// ArrayList<UserModel> users = new ArrayList<UserModel>();
		// users.add(userModel1);
		// users.add(userModel2);

		// Iterable<UserModel> results = userRepository.saveAll(users);
		// //lamda method impl
		// results.forEach(user->{
		// 	System.out.println(user);
		// });

		
		//update the user of id 2
		// Optional<UserModel> optional = userRepository.findById(2);
		// UserModel user = optional.get();

		// user.setName("Shivam Vashishtha");
		// user = userRepository.save(user);
		// System.out.println(user);


		//how to get the data in bulk
		// Iterable<UserModel> itr =userRepository.findAll();
		// Iterator <UserModel> iterator = itr.iterator();
		// while(iterator.hasNext()) {
		// 	UserModel user = iterator.next();
		// 	System.out.println(user);
		// }

		// itr.forEach(new Consumer<UserModel>(){
		// 	@Override
		// 	public void accept(UserModel t) {
		// 		// TODO Auto-generated method stub
		// 		System.out.println(t);
		// 	}
		// });

		// itr.forEach(user->{
		// 	System.out.println(user);
		// });


		//Deleting a element from DB
		// userRepository.deleteById(2);
		// System.out.println("Deleted");

		//Delete using iterable
		// Iterable<UserModel> allUsers = userRepository.findAll();
		// allUsers.forEach(user->{
		// 	System.out.println(user);
		// });
		// userRepository.deleteAll(allUsers);

		//Deleting all elements
		// userRepository.deleteAll();


		// // Derived Methods or Custom finding methods
		// users.forEach(user->{
		// 	System.out.println(user);
		// });

		// Iterable<UserModel> users2 = userRepository.findByNameAndCity("Shivam", "Meerut");
		// users2.forEach(user->{
		// 	System.out.println(user);
		// });

		// Iterable<UserModel> users3 = userRepository.findByNameStartingWith("S");
		// users3.forEach(user->{
		// 	System.out.println(user);
		// });


		// Iterable<UserModel> users4 = userRepository.getAllUser();
		// users4.forEach(user->{
		// 	System.out.println(user);
		// });

		// Iterable<UserModel> user5 = userRepository.getUserByName("Shivam");
		// user5.forEach(user->{
		// 	System.out.println(user);
		// });

		// userRepository.getUsers().forEach(user->{System.out.println(user);});
	}

}
	

// <tomcat.version>8.0.23</tomcat.version>