package mx.com.hikaricp.app.apiservice.employee.controller;

import java.util.ArrayList;
import java.util.List;

import mx.com.hikaricp.app.apiservice.departments.service.IDepartmentsService;
import mx.com.hikaricp.app.apiservice.employee.service.IEmployeeService;
import mx.com.hikaricp.app.apiservice.model.db1.Employee;


import mx.com.hikaricp.app.apiservice.model.db2.Departments;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;


/**
 * The Class EmployeeController.
 */
@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	/** The service. */
	@Autowired
	private IEmployeeService service;

	@Autowired
	private IDepartmentsService serviceDepartments;

	HttpStatus status = INTERNAL_SERVER_ERROR;


	/**
	 * Consultar empleados.
	 *
	 * @return the response entity
	 */
	@GetMapping
	public ResponseEntity<List<Employee>> consultarEmpleados() {
		LOGGER.info("Peticion recibida para consultar los empleados");
		List<Employee> employees = new ArrayList<Employee>();
		try {
			employees = service.findAll();
			LOGGER.info("Consulta de empleados Exitosa.");
			status = OK;
		} catch (ServiceException e ) {
			LOGGER.error("Error al consultar los empleados: ",e);
		}
		return new ResponseEntity<List<Employee>>(employees,status);
	}

	/**
	 * Consultar empleado por id.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Employee> consultarEmpleadoPorId(@PathVariable("id") Long id) {
		LOGGER.info("Peticion recibida para consultar empleado por id: " +  id);
		Employee employee = new Employee();
		try {
			employee = service.findById(id);
			LOGGER.info("Consulta de empleado por id Exitosa.");
			status = OK;
		} catch (ServiceException e ) {
			LOGGER.error("Error al consultar empleado por id: ",e);
		}
		return new ResponseEntity<Employee>(employee,status);
	}

	/**
	 * Guardar empleado.
	 *
	 * @param employee the employee
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<Employee> guardarEmpleado(@RequestBody Employee employee) {
		LOGGER.info("Peticion recibida para guardar Empleado");
		Employee saveEmployee = new Employee();
		try {
			saveEmployee = service.save(employee);
			LOGGER.info("Se ha guardado correctamente el empleado");
			status = OK;
		} catch (ServiceException e ) {
			LOGGER.error("Error al guardar el empleado: ",e);
		}
		return new ResponseEntity<Employee>(saveEmployee,status);
	}

	/**
	 * Actualizar empleado.
	 *
	 * @param employee the employee
	 * @return the response entity
	 */
	@PutMapping
	public ResponseEntity<Employee> actualizarEmpleado(@RequestBody Employee employee) {
		LOGGER.info("Peticion recibida para actualizar empleado");
		Employee updateEmployee = new Employee();
		try {
			updateEmployee = service.update(employee);
			LOGGER.info("Se ha actualizado correctamente el empleado");
			status = OK;
		} catch (ServiceException e ) {
			LOGGER.error("Error al actualizar el empleado: ",e);
		}
		return new ResponseEntity<Employee>(updateEmployee,status);
	}

	/**
	 * Borrar empleado por id.
	 *
	 * @param id the id
	 */
	@DeleteMapping("/{id}")
	public void borrarEmpleadoPorId(@PathVariable("id") Long id) {
		LOGGER.info("Peticion recibida para borrar Empleado por id: " +  id);
		try {
			service.deleteById(id);
			LOGGER.info("Se elemino correctamente el Departamento por id");
		} catch (ServiceException e ) {
			LOGGER.error("Error al eliminar el empleado: ",e);
		}
	}


	@PatchMapping("/{id}")
	public ResponseEntity<Departments> consultarDepartamentosPorId(@PathVariable("id") Long id) {
		LOGGER.info("Peticion recibida para consultar departamentos por id: " +  id);
		Departments departments = new Departments();
		try {
			departments = serviceDepartments.findById(id);
			LOGGER.info("Consulta de Departamento por id Exitosa.");
			status = OK;
		} catch (ServiceException e ) {
			LOGGER.error("Error al consultar Departamento por id: ",e);
		}
		return new ResponseEntity<Departments>(departments,status);
	}
	
}
