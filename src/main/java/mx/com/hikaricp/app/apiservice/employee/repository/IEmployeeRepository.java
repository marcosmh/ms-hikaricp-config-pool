package mx.com.hikaricp.app.apiservice.employee.repository;

import mx.com.hikaricp.app.apiservice.model.db1.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The Interface IEmployeeRepository.
 */
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
