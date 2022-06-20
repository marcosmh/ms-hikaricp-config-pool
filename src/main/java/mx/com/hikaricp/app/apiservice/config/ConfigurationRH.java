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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.sql.DataSource;





@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
(
    entityManagerFactoryRef = "entityManagerFactoryRH",
    basePackages={
      "mx.com.hikaricp.app.apiservice.departments.repository"
    },
    transactionManagerRef="transactionManagerRH"
)
public class ConfigurationRH {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationRH.class);
    @Autowired
    private DataSourceRH datasource2;



    public ConfigurationRH() {

    }




    @Bean("hikariConfigRH")
    public HikariConfig hikariConfigRH() {
        HikariConfig config = new HikariConfig();
        try {
            LOGGER.info("hikariConfigRH");
            config.setDriverClassName(datasource2.getDriver());
            config.setJdbcUrl(datasource2.getUrl());
            config.setUsername(datasource2.getUsername());
            config.setPassword(datasource2.getPassword());
            config.setSchema(datasource2.getSchema().toLowerCase());
            config.setConnectionTimeout(6000);
            config.setMinimumIdle(5);
            config.setMaximumPoolSize(5);
            config.setIdleTimeout(300000);
            LOGGER.info(" config ==="+config.getSchema()+"  --- "+config.getDataSourceClassName()+" --- "+config.getDataSource()+" ---- "+config.getDriverClassName());
            return config;
        } catch (Exception e) {
            LOGGER.info("=============================");
            LOGGER.info(datasource2.getDriver());
            LOGGER.info(datasource2.getDriver());
            LOGGER.info(datasource2.getUrl());
            LOGGER.info(datasource2.getUsername());
            LOGGER.info(datasource2.getPassword());
            LOGGER.info("=============================");

            LOGGER.error("Error en hikariConfigRH:  ",e);
            LOGGER.error("Error en hikariConfigRH2:  ",e.getMessage());
            return config;
        }

    }





    @Bean("secondDataSource")
    public DataSource secondDataSource() {
        try {
            return new HikariDataSource(hikariConfigRH());
        } catch (BeanInstantiationException e) {
            LOGGER.error("BeanInstantiationException en ConfigurationRH :: secondDataSource: ",e);
        } catch(Exception e) {
            LOGGER.info("Error = "+e.getMessage());
            LOGGER.info("Error Cause = "+e.getCause());
            LOGGER.info("Error = "+e.getStackTrace());
            LOGGER.error("Exception en ConfigurationRH :: secondDataSource: ",e);
        }
        return null;
    }





    @Bean("entityManagerFactoryRH")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryRH(EntityManagerFactoryBuilder builder) {
        try {
            return builder
                    .dataSource(secondDataSource())
                    .packages("mx.com.hikaricp.app.apiservice")
                    .persistenceUnit(datasource2.getSchema())
                    .build();
        } catch (PersistenceException e) {
            LOGGER.error("Error en RH :: entityManagerFactory: ",e);
            return null;
        }

    }



    @Bean("transactionManagerRH")
    public PlatformTransactionManager transactionManagerAppMovil(@Qualifier("entityManagerFactoryRH") EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        try {
            transactionManager.setEntityManagerFactory(emf);
            return transactionManager;
        } catch (Exception e) {
            LOGGER.error("Error :: RH :: transactionManager: ",e);
            return transactionManager;
        }
    }


}
