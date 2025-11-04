package com.jora.masterservice.config;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.info.BuildProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.jora.encodedecode.common.EncryptionDecryption;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Data
public class ApplicationConfig {

	private final BuildProperties buildProperties;

	private String serverName, companyTag, portNo, userName, password, companyFlag;
	private int dbYear;

	protected void fileRead() throws Exception {
		File file = new ClassPathResource("Appconfig.ini").getFile();

		if (!file.exists()) {
			throw new Exception("Appconfig.ini File not found!...");
		}

		List<String> lstServerDetails = new ArrayList<String>();
		lstServerDetails = Files.readAllLines(file.toPath());
		int lineCount = 1;
		for (String s : lstServerDetails) {
			switch (lineCount) {
			case 1:
				companyTag = EncryptionDecryption.decrypt(s.trim());
				break;
			case 2:
				companyFlag = EncryptionDecryption.decrypt(s.trim());
				break;
			case 3:
				serverName = EncryptionDecryption.decrypt(s.trim());
				break;
			case 4:
				portNo = EncryptionDecryption.decrypt(s.trim());
				break;
			case 5:
				userName = EncryptionDecryption.decrypt(s.trim());
				break;
			case 6:
				password = EncryptionDecryption.decrypt(s.trim());
				break;
			default:
				break;
			}
			lineCount += 1;
		}
	}

	protected HikariDataSource getDatasource(String database) throws Exception {
		HikariConfig config = new HikariConfig();
		StringBuilder url = new StringBuilder();
		url.append("jdbc:mysql://").append(serverName).append(":").append(portNo).append("/").append(database);
		url.append("?useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&");
		url.append("applicationName=").append(buildProperties.getName());
//		String url = String.format("jdbc:mysql://%s:%s/%s", serverName, portNo, database);
		config.setJdbcUrl(url.toString());
		config.setUsername(userName);
		config.setPassword(password);
		config.setMaximumPoolSize(5);
		config.setMinimumIdle(1);
		config.setMaxLifetime(TimeUnit.MINUTES.toMillis(30));
		config.setConnectionTimeout(TimeUnit.SECONDS.toMillis(30));
		config.setIdleTimeout(TimeUnit.MINUTES.toMillis(2));
		return new HikariDataSource(config);
	}
}
