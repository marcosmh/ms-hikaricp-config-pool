package mx.com.hikaricp.app.apiservice.employee.service;

import java.util.List;

import mx.com.hikaricp.app.apiservice.model.db1.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.hikaricp.app.apiservice.employee.repository.IEmployeeRepository;


/**
 * The Class EmployeeService.
 */
@Service
public class EmployeeService implements IEmployeeService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	/** The repository. */
	@Autowired
	private IEmployeeRepository repository;


	/**
	 * Find all.
	 * @return the list
	 */
	@Override
	public List<Employee> findAll() {
		LOGGER.info("Buscar Todos los Empleados");
		return repository.findAll();
	}

	/**
	 * Find by id.
	 * @param id the id
	 * @return the employee
	 */
	@Override
	public Employee findById(Long id) {
		LOGGER.info("Buscar Empleado por id: " +  id);
		return repository.findById(id).orElse(null);				
	}

	/**
	 * Save.
	 * @param employee the employee
	 * @return the employee
	 */
	@Override
	public Employee save(Employee employee) {
		LOGGER.info("Guardar Empleado");
		return repository.save(employee);
	}

	/**
	 * Update.
	 * @param employee the employee
	 * @return the employee
	 */
	@Override
	public Employee update(Employee employee) {
		LOGGER.info("Actualizar Empleado");		
		if( repository.existsById(employee.getId()) ) {
			return repository.save(employee);
		} else {
			return null;
		}				
	}

	/**
	 * Delete by id.
	 * @param id the id
	 */
	@Override
	public void deleteById(Long id) {
		LOGGER.info("Borrar Empleado por id: " +  id);
		repository.deleteById(id);
	}


	
}
