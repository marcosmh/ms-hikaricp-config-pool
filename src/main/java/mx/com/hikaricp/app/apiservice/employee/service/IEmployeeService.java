package mx.com.hikaricp.app.apiservice.employee.service;

import java.util.List;

import mx.com.hikaricp.app.apiservice.model.db1.Employee;


/**
 * The Interface IEmployeeService.
 */
public interface IEmployeeService {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Employee> findAll();

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the employee
	 */
	Employee findById(Long id);

	/**
	 * Save.
	 *
	 * @param employee the employee
	 * @return the long
	 */
	Employee save(Employee employee);

	/**
	 * Update.
	 *
	 * @param employee the employee
	 * @return the long
	 */
	Employee update(Employee employee);

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	void deleteById(Long id);



}
