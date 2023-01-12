package com.dentist.ProjectDentist;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectDentistApplication {


	public static void main(String[] args) {

		PropertyConfigurator.configure("error_project.log");
		SpringApplication.run(ProjectDentistApplication.class, args);
	}

}
