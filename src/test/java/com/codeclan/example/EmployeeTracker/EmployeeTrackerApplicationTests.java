package com.codeclan.example.EmployeeTracker;

import com.codeclan.example.EmployeeTracker.models.Department;
import com.codeclan.example.EmployeeTracker.models.Employee;
import com.codeclan.example.EmployeeTracker.models.Project;
import com.codeclan.example.EmployeeTracker.repositories.DepartmentRepository;
import com.codeclan.example.EmployeeTracker.repositories.EmployeeRepository;
import com.codeclan.example.EmployeeTracker.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTrackerApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void canCreateEmployee() {
//		Employee employee = new Employee("Darren","Shankland", 100);
//		employeeRepository.save(employee);
//	}

//	@Test
//	public void canCreateEmployeeInDeopartment() {
//		Department department = new Department("IT");
//		departmentRepository.save(department);
//		Employee employee = new Employee("Darren","Shankland", 100, department);
//		employeeRepository.save(employee);
//	}

	@Test
	public void addEmployeesAndProjects() {
		Department department = new Department("IT");
		departmentRepository.save(department);

		Employee employee = new Employee("Darren","Shankland", 100, department);
		employeeRepository.save(employee);

		Employee employee1 = new Employee("Attha","Arshad", 1, department);
		employeeRepository.save(employee1);

		Project project = new Project("Codeclan Project", 10);
		project.addEmployee(employee);
		project.addEmployee(employee1);
		projectRepository.save(project);
	}
}
