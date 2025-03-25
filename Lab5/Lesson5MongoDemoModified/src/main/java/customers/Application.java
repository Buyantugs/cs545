package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//crete Student
		Student student=new Student(100,"Bat","Dorj", "99111010", "buya@uic.edu");
		Address address=new Address("940 Surrey Dr","Dalles","60603");
		student.setAddress(address);
		studentRepository.save(student);

		student=new Student(101,"Ganaa","Dorj", "991110000", "buya2@uic.edu");
		address=new Address("Bla bla","Chicago","60603");
		student.setAddress(address);
		studentRepository.save(student);

		student=new Student(102,"Ganaa","Suren", "319217", "buya3@uic.edu");
		address=new Address("Bla bla","Fairfield","60603");
		student.setAddress(address);
		studentRepository.save(student);

		//get students
		System.out.println("-----------All students ----------------");
		System.out.println(studentRepository.findAll());

		System.out.println("-----------Get all students with a certain name ----------------");
		System.out.println(studentRepository.findByFirstName("Ganaa"));

		System.out.println("-----------Get a student with a certain phoneNumber ----------------");
		System.out.println(studentRepository.findByPhoneNumber("319217"));

		System.out.println("-----------Get all students from a certain city ----------------");
		System.out.println(studentRepository.findByAddressCity("Dalles"));





	}

}
