package mx.com.hikaricp.app.apiservice.model.db1;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Employee.
 */
@Entity
@Table(name = "DUMMY_EMPLOYEES")
public class Employee {

	/** The id. */
	@Id
	@Column(name = "EMPLOYEE_ID", nullable = false)
	private Long id;
	
	/** The first name. */
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	/** The last name. */
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	/** The email id. */
	@Column(name = "EMAIL", nullable = false)
	private String emailAddress;
	
	/**
	 * Instantiates a new employee.
	 */
	public Employee() {
		
	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param emailAddress the email address
	 */
	public Employee(Long id, String firstName, String lastName, String emailAddress) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}

	/**
	 * Gets the id.
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email id.
	 * @return the email id
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailAddress the new email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	
	
}
