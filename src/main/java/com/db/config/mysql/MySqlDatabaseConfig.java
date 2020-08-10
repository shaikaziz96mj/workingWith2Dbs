package com.db.config.mysql;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.db.constants.ApplicationConstants;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "mysqlEntityManagerFactory",
		transactionManagerRef = "mysqlTransactionManager",
		basePackages = "com.db.repo.mysql"
		)
public class MySqlDatabaseConfig {

	//datasource configuration for mysql db
	@Bean
	@Primary
	@ConfigurationProperties(prefix = ApplicationConstants.MYSQL_PROPERTIES_PREFIX)
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	//entity manager factory
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder emfb) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", ApplicationConstants.HIBERNATE_HBM2DDL_PROPERTY);
		properties.put("hibernate.dialect", ApplicationConstants.MYSQL_HIBERNATE_DIALECT);
		
		return emfb
				.dataSource(mysqlDataSource())
				.packages(ApplicationConstants.MYSQL_DOMAIN_PACKAGES)
				.properties(properties)
				.persistenceUnit(ApplicationConstants.MYSQL_PERSISTENCE_UNIT)
				.build();
	}
	
	//Transaction manager
	@Bean
	@Primary
	public PlatformTransactionManager mysqlTransactionManager(
			@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
}