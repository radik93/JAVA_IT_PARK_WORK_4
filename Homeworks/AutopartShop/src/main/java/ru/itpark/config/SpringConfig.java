package ru.itpark.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;


@Configuration // говорим, что класс является конфигурационным классом Spring-а
@ComponentScan(basePackages = "ru.itpark") // говорим спрингу, где следует искать компоненты
public class SpringConfig {

    // @Value - позволяет вытаскавать настройки из properties-файла
 //   @Value("${hibernate.dialect}")
  //  private String hibernateDialect;

 //   @Value("${hibernate.hbm2ddl.auto}")
 //   private String hibernateDdlAuto;

 //   @Value("${hibernate.show_sql}")
 //   private String hibernateShowSql;

    @Autowired
    @Qualifier(value = "driverManagerDataSource")
    private DataSource dataSource;
    //


    @Bean
    @Scope(value = "prototype")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}
