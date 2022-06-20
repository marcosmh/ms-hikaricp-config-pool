package mx.com.hikaricp.app.apiservice.departments.service;

import mx.com.hikaricp.app.apiservice.departments.repository.IDepartmentsRepository;
import mx.com.hikaricp.app.apiservice.model.db2.Departments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * The Class DepartmentsService.
 */
@Service
public class DepartmentsService implements IDepartmentsService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentsService.class);

    /** The repository dep. */
    @Autowired
    IDepartmentsRepository repositoryDep;


    /**
     * Find all.
     *
     * @return the list
     */
    @Override
    public List<Departments> findAll() {
        LOGGER.info("Consultar los Departamentos");
        return repositoryDep.findAll();
    }


    /**
     * Find by id.
     *
     * @param id the id
     * @return the departments
     */
    @Override
    public Departments findById(Long id) {
        LOGGER.info("Consultar Departamentos por id: " +  id);
        return repositoryDep.findById(id).orElse(null);
    }
}
