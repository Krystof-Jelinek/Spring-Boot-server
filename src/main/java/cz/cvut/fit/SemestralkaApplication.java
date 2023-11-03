package cz.cvut.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;

@SpringBootApplication
public class SemestralkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SemestralkaApplication.class, args);
		System.out.println("Hello World!");
		Employee tmp = new Employee();
		tmp.setFirstName("zkouska");
		tmp.setLastName("prvni");
		Long neco = 50L;
		tmp.setId(neco);
	}

}