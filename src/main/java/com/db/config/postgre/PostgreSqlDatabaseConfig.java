package com.db.config.postgre;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.db.constants.ApplicationConstants;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "postgreEntityManagerFactory",
		transactionManagerRef = "postgreTransactionManager",
		basePackages = "com.db.repo.postgre"
		)
public class PostgreSqlDatabaseConfig {

	//datasource configuration for postgre db
		@Bean
		@ConfigurationProperties(prefix = ApplicationConstants.POSTGRE_PROPERTIES_PREFIX)
		public DataSource postgreDataSource() {
			return DataSourceBuilder.create().build();
		}
		
		//entity manager factory
		@Bean
		public LocalContainerEntityManagerFactoryBean postgreEntityManagerFactory(EntityManagerFactoryBuilder emfb) {
			HashMap<String, Object> properties = new HashMap<>();
			properties.put("hibernate.hbm2ddl.auto", ApplicationConstants.HIBERNATE_HBM2DDL_PROPERTY);
			properties.put("hibernate.dialect", ApplicationConstants.POSTGRE_HIBERNATE_DIALECT);
			
			return emfb
					.dataSource(postgreDataSource())
					.packages(ApplicationConstants.POSTGRE_DOMAIN_PACKAGES)
					.properties(properties)
					.persistenceUnit(ApplicationConstants.POSTGRE_PERSISTENCE_UNIT)
					.build();
		}
		
		//Transaction manager
		@Bean
		public PlatformTransactionManager postgreTransactionManager(
				@Qualifier("postgreEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
			return new JpaTransactionManager(entityManagerFactory);
		}
	
}