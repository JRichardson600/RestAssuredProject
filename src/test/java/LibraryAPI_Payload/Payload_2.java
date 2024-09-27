package Assigmnent13082024_payload_1;

import com.github.javafaker.Faker;

public class Payload_2 {

    // Method to generate a random email address
	Faker faker = new Faker();

//	 Generate fake data
	public String name = faker.book().title();
	public String isbn = faker.phoneNumber().phoneNumber();
	public int aisle = faker.number().randomDigit();
	public String author = faker.book().author();
	public String ID=isbn+aisle;
	
	
}

