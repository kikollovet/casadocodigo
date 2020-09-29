package br.com.casadocodigo.loja.conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceConfigurationTest {

    @Bean
    @Profile("test")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
		dataSource.setPassword("kiko");
		dataSource.setUrl("jdbc:mysql://localhost/casadocodigo_test");
		dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo_test?useTimezone=true&amp&serverTimezone=UTC");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

}
