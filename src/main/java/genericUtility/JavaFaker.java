package genericUtility;

import com.github.javafaker.Faker;

public class JavaFaker {
	 Faker faker = new Faker();
	public  String foreignerName() {
		return faker.name().fullName();
	}
	public  String noOfAdult() {
		return faker.number().digits(1);
	}
	public  String noOfChildren() {
		return faker.number().digits(1);
	}
	

}
