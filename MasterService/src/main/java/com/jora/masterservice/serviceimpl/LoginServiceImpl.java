package com.jora.masterservice.serviceimpl;

import org.springframework.stereotype.Service;

import com.jora.masterservice.main.dao.OperatorDao;
import com.jora.masterservice.main.entity.Operator;
import com.jora.masterservice.service.LoginService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

	private final OperatorDao operatorDao;

	@Override
	public Operator chkOperator(int operatorCode) throws Exception {
		return operatorDao.findByActiveAndOperatorCode("Y", operatorCode);
	}

}
