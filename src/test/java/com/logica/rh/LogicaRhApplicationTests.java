package com.logica.rh;

import com.logica.rh.domain.Department;
import com.logica.rh.domain.Employee;
import com.logica.rh.service.DepartmentService;
import com.logica.rh.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class LogicaRhApplicationTests {

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EmployeeService employeeService;
	@Test
	void contextLoads() {
	}

	@Test
	void testDepartmentService() {
		// test getCountries
			Assertions.assertEquals(departmentService.getDepartments().size(), 2);

		//assertThat(countryService.getCountries().size()).isEqualTo(3);

		// test getDepartment
			//String name = "IT";
			//Department department = departmentService.getDepartment(name);

		//test createDepartment
			Department department = new Department();
			department.setName("Financial");
			Employee employee = new Employee();
			employee.setId(2L);
			department.setResponsable(employee);

			//Objet department a recuperer apres insertion
			Department departmentsave = departmentService.createDepartment(department);
			Assertions.assertEquals(departmentsave.getName(), department.getName());

		//test updateDepartment

		//test deleteDepartment

	}

	@Test
	void testEmployeeService() {
		// test getEmployees
		Assertions.assertEquals(employeeService.getEmployees(PageRequest.of(0,3)).getContent().size(), 3);

		// test getEmployee

		// test createEmployee

		// test updateEmployee


		// test deleteEmployee

	}

}
