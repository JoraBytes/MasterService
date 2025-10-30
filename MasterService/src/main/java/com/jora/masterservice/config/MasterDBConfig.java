package com.jora.masterservice.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableJpaRepositories(basePackages = "com.jora.masterservice.repo", entityManagerFactoryRef = "masterEntityManager", transactionManagerRef = "masterTransactionManager")
@RequiredArgsConstructor
public class MasterDBConfig {
	
	private final ApplicationConfig applicationConfig;
	
	@Bean("masterDataSource")
	DataSource masterDataSource() throws Exception {
		try {
			applicationConfig.fileRead();
			return applicationConfig.getDatasource("master");
		} catch (Exception e) {
			throw e;
		}
	}

	@Bean(name = "masterEntityManager")
	LocalContainerEntityManagerFactoryBean masterEntityManagerFactory(
			@Qualifier("masterDataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("com.jora.masterservice.entity");
		emf.setPersistenceUnitName("masterPU");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
		emf.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return emf;
	}

	@Bean(name = "masterTransactionManager")
	PlatformTransactionManager masterTransactionManager(@Qualifier("masterEntityManager") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
