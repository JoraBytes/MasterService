package com.jora.masterservice.config;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.jora.masterservice.common.ErrorHandler;
import com.jora.masterservice.main.dao.OperatorDao;
import com.jora.masterservice.main.entity.Operator;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableJpaRepositories(basePackages = "com.jora.masterservice.main.dao", entityManagerFactoryRef = "mainEntityManager", transactionManagerRef = "mainTransactionManager")
@RequiredArgsConstructor
public class MainDBConfig {

	private final DataSource masterDataSource;

	private final ApplicationConfig applicationConfig;

	private Logger log = LogManager.getLogger(getClass());

	@Bean("mainDataSource")
	DataSource mainDatasource() throws Exception {
		try {
			String database = ApplicationConfig.companyTag + "maindb";
			String query = "create database if not exists " + database;
			new JdbcTemplate(masterDataSource).update(query);
			return applicationConfig.getDatasource(database);
		} catch (Exception e) {
			log.error(ErrorHandler.errorTraceForLogger(e));
			throw e;
		}
	}

	@Bean("mainEntityManager")
	LocalContainerEntityManagerFactoryBean mainDbEntitymanager(@Qualifier("mainDataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("com.jora.masterservice.main.entity");
		emf.setPersistenceUnitName("mainPU");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
		emf.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return emf;
	}

	@Bean("mainTransactionManager")
	PlatformTransactionManager mainTransactionManager(@Qualifier("mainEntityManager") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
