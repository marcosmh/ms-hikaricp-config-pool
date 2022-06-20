package mx.com.hikaricp.app.apiservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "rh")
@RefreshScope
public class DataSourceRH implements Serializable {



    private static final long serialVersionUID = 1L;



    @Value("${spring.datasource2.username}")
    private String username;



    @Value("${spring.datasource2.password}")
    private String password;



    @Value("${spring.datasource2.driver-class-name}")
    private String driver;



    @Value("${spring.datasource2.url}")
    private String url;



    @Value("${data.db.schema.db2}")
    private String schema;



    private Long connectiontime;



    private int poolsize;







    public DataSourceRH() {

    }



    public String getUsername() {
        return username;
    }




    public void setUsername(String username) {
        this.username = username;
    }




    public String getPassword() {
        return password;
    }




    public void setPassword(String password) {
        this.password = password;
    }


    public String getDriver() {
        return driver;
    }


    public void setDriver(String driver) {
        this.driver = driver;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public Long getConnectiontime() {
        return connectiontime;
    }


    public void setConnectiontime(Long connectiontime) {
        this.connectiontime = connectiontime;
    }




    public int getPoolsize() {
        return poolsize;
    }


    public void setPoolsize(int poolsize) {
        this.poolsize = poolsize;
    }


    public String getSchema() {
        return schema;
    }


    public void setSchema(String schema) {
        this.schema = schema;
    }


}
