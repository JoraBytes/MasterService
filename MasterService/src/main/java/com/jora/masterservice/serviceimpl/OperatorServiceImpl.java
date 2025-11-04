package com.jora.masterservice.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jora.masterservice.common.ErrorHandler;
import com.jora.masterservice.main.dao.OperatorDao;
import com.jora.masterservice.main.entity.Operator;
import com.jora.masterservice.service.OperatorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OperatorServiceImpl implements OperatorService {

	private final OperatorDao operatorDao;

	private final Logger log = LogManager.getLogger(getClass());

	@Override
	public List<Operator> getAllOperators() throws Exception {
		try {
			return operatorDao.findAll();
		} catch (Exception e) {
			log.error(ErrorHandler.errorTraceForLogger(e));
			throw e;
		}
	}

	@Override
	public Operator save(Operator operator) throws Exception {
		try {
			return operatorDao.save(operator);
		} catch (Exception e) {
			log.error(ErrorHandler.errorTraceForLogger(e));
			throw e;
		}
	}
}
