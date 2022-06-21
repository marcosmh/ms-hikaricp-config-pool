package mx.com.hikaricp.app.apiservice.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.sql.DataSource;


/**
 * The type Configuration Afo GNP.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
(
    entityManagerFactoryRef = "entityManagerFactoryHR",
    basePackages={
      "mx.com.hikaricp.app.apiservice.employee.repository"
    },
    transactionManagerRef="transactionManagerHR"
)
public class ConfigurationHR {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationHR.class);

    /** The ds afo GNP. */
    @Autowired
    private DataSourceHR datasource1;



    /**
     * Instantiates a new Configuration afo gnp.
     */
    public ConfigurationHR() {
    }


    /**
     * Hikari config afo gnp hikari config.
     *
     * @return the hikari config
     */
    @Primary
    @Bean("hikariConfigHR")
    public HikariConfig hikariConfigHR() {
        HikariConfig config = new HikariConfig();
        try {
            LOGGER.info("hikariConfigHR");
            config.setDriverClassName(datasource1.getDriver());
            config.setJdbcUrl(datasource1.getUrl());
            config.setUsername(datasource1.getUsername());
            config.setPassword(datasource1.getPassword());
            config.setSchema(datasource1.getSchema());
            config.setConnectionTimeout(6000);
            config.setMinimumIdle(5);
            config.setMaximumPoolSize(5);
            config.setIdleTimeout(300000);
            LOGGER.info("Conexion a HR [OK]");
        } catch (Exception e) {
            LOGGER.info("Conexion a HR [Failed]");
            LOGGER.error("Error en hikariConfigHR:  ",e);
        }
        return config;

    }


    /**
     * Primary data source data source.
     *
     * @return the data source
     */
    @Primary
    @Bean("primaryDataSource")
    public DataSource primaryDataSource() {
        try {
            return new HikariDataSource(hikariConfigHR());
        } catch (BeanInstantiationException e) {
            LOGGER.error("BeanInstantiationException en HR :: primaryDataSource: ",e);
        } catch(Exception e) {
            LOGGER.error("Exception en HR :: primaryDataSource: ",e);
        }
        return null;

    }

    /**
     * Entity manager factory local container entity manager factory bean.
     *
     * @param builder the builder
     * @return the local container entity manager factory bean
     */
    @Primary
    @Bean("entityManagerFactoryHR")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryHR(EntityManagerFactoryBuilder builder) {
        try {
            return builder
                    .dataSource(primaryDataSource())
                    .packages("mx.com.hikaricp.app.apiservice")
                    .persistenceUnit(datasource1.getSchema())
                    .build();
        } catch (PersistenceException e) {
            LOGGER.error("Error en HR :: entityManagerFactory: ",e);
            return null;
        }


    }

    /**
     * Transaction manager platform transaction manager.
     *
     * @param emf the emf
     * @return the platform transaction manager
     */
    @Primary
    @Bean("transactionManagerHR")
    public PlatformTransactionManager transactionManagerHR(@Qualifier("entityManagerFactoryHR") EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        try {
            transactionManager.setDataSource(primaryDataSource());
            transactionManager.setEntityManagerFactory(emf);
        } catch(PersistenceException e) {
            LOGGER.error("Error :: HR :: transactionManager: ",e);
        }
        return transactionManager;
    }

}
