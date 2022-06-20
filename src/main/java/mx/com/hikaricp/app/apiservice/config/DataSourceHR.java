package mx.com.hikaricp.app.apiservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;



/**
 * The Class DataSourceAfoGNP.
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "hr")
@RefreshScope
public class DataSourceHR implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The username. */
    @Value("${spring.datasource.username}")
    private String username;

    /** Variable password de tipo String. */
    @Value("${spring.datasource.password}")
    private String password;

    /** Variable driver de tipo String. */
    @Value("${spring.datasource.driver-class-name}")
    //@Value("${spring.datasource.driverClassName}")
    private String driver;

    /** Variable url de tipo String. */
    @Value("${spring.datasource.url}")
    private String url;

    /** Variable connectiontime de tipo Long. */
    private Long connectiontime;

    /** Variable poolsize de tipo int. */
    private int poolsize;

    /** The schema. */
    @Value("${data.db.schema.db1}")
    private String schema;

    /**
     * Instantiates a new Data source afo gnp.
     */
    public DataSourceHR() {

    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * Sets driver.
     *
     * @param driver the driver
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets connectiontime.
     *
     * @return the connectiontime
     */
    public Long getConnectiontime() {
        return connectiontime;
    }

    /**
     * Sets connectiontime.
     *
     * @param connectiontime the connectiontime
     */
    public void setConnectiontime(Long connectiontime) {
        this.connectiontime = connectiontime;
    }

    /**
     * Gets poolsize.
     *
     * @return the poolsize
     */
    public int getPoolsize() {
        return poolsize;
    }

    /**
     * Sets poolsize.
     *
     * @param poolsize the poolsize
     */
    public void setPoolsize(int poolsize) {
        this.poolsize = poolsize;
    }

    /**
     * Gets schema.
     *
     * @return the schema
     */
    public String getSchema() {
        return schema;
    }

    /**
     * Sets schema.
     *
     * @param schema the schema
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }
}
