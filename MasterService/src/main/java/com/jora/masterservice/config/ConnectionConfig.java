package com.jora.masterservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.jora.encodedecode.common.EncryptionDecryption;
import com.jora.masterservice.main.dao.OperatorDao;
import com.jora.masterservice.main.entity.Operator;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ConnectionConfig {

	private final OperatorDao operatorDao;

	@PostConstruct
	@Transactional("masterTransactionManager")
	public void afterPropertiesSet() throws Exception {
		if (!operatorDao.existsById(1))
			operatorDao.save(getAdmin());
	}

	private Operator getAdmin() throws Exception {
		Operator operator = new Operator();
		operator.setOperatorName("ADMINISTRATOR");
		operator.setPassword(EncryptionDecryption.encrypt("123"));
		operator.setActive("Y");
		operator.setProUser("Y");
		operator.setEntryMode("Y");
		operator.setViewMode("Y");
		operator.setEditMode("Y");
		operator.setDeleteMode("Y");
		operator.setCancelAccess("Y");
		operator.setRateEntry("Y");
		operator.setPreviousDateEntry("Y");
		operator.setCompanyFlag(ApplicationConfig.companyFlag);
		operator.setCompanyTag(ApplicationConfig.companyTag);
		operator.setAutoGen("Y");
		return operator;
	}

}
