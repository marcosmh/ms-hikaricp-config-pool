package mx.com.hikaricp.app.apiservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


/**
 * The Class HikariApp.
 */
@SpringBootApplication
@EnableAutoConfiguration

//@SpringBootApplication(scanBasePackages = {"mx.com.hikaricp.app.apiservice"})
//@EntityScan(basePackages = "mx.com.hikaricp.app.apiservice")

//@ComponentScan(basePackages = "mx.com.hikaricp.app.apiservice")
//@EnableJpaRepositories("mx.com.hikaricp.app.apiservice.employee.repository")

public class HikariApp {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(HikariApp.class, args);
	}



}
