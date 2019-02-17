package ch.acme.organizationservice.controller;

import ch.acme.organizationservice.client.DepartmentClient;
import ch.acme.organizationservice.client.EmployeeClient;
import ch.acme.organizationservice.model.Organization;
import ch.acme.organizationservice.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);
	
	private OrganizationRepository repository;
	private DepartmentClient departmentClient;
	private EmployeeClient employeeClient;

	public OrganizationController(OrganizationRepository repository, DepartmentClient departmentClient, EmployeeClient employeeClient) {
		this.repository = repository;
		this.departmentClient = departmentClient;
		this.employeeClient = employeeClient;
	}

	@PostMapping
	public Organization add(@RequestBody Organization organization) {
		LOGGER.info("Organization add: {}", organization);
		return repository.add(organization);
	}
	
	@GetMapping
	public List<Organization> findAll() {
		LOGGER.info("Organization find");
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Organization findById(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		return repository.findById(id);
	}

	@GetMapping("/{id}/with-departments")
	public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = repository.findById(id);
		organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
		return organization;
	}
	
	@GetMapping("/{id}/with-departments-and-employees")
	public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = repository.findById(id);
		organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
		return organization;
	}
	
	@GetMapping("/{id}/with-employees")
	public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = repository.findById(id);
		organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
		return organization;
	}
	
}