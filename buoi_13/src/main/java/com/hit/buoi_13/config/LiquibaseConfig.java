package com.hit.buoi_13.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {

  @Bean
  public SpringLiquibase liquibase(@Qualifier("dataSource") DataSource dataSource) {
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setChangeLog("classpath:config/liquibase/master.xml");
    liquibase.setDataSource(dataSource);
    return liquibase;
  }

}
