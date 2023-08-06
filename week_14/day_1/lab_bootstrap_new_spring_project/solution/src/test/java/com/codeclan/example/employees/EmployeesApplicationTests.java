package com.codeclan.example.employees;

import com.codeclan.example.employees.models.Employee;
import com.codeclan.example.employees.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeesApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createEmployee(){
		Employee eva = new Employee("Eva", 19, "1", "star@worker.com");
		employeeRepository.save(eva);
	}

}
