package com.hocjavaweb.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.hocjavaweb.repository")
@EnableTransactionManagement
public class JPAConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("persistence-data");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//dataSource.setUrl("jdbc:mysql://localhost:3306/springmvcbasicdemo");
//  	dataSource.setUrl("jdbc:mysql://node219324-baothanhnien.j.layershift.co.uk/springmvcbasicdemo?useUnicode=true&characterEncoding=UTF-8");
		//dataSource.setUsername("root");
		//dataSource.setPassword("123456");
	//	dataSource.setPassword("SMHmva18377");
		dataSource.setUrl("jdbc:mysql://sql12.freemysqlhosting.net/sql12315688");
		dataSource.setUsername("sql12315688");
		dataSource.setPassword("hq5VZfE3Ww");
		return dataSource;
	}
	Properties additionalProperties() {
		Properties properties = new Properties();
	//	properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
	//	properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		return properties;
	}
}
