package com.jora.masterservice.service;

import com.jora.masterservice.main.entity.Operator;

public interface LoginService {

	Operator chkOperator(int operCode) throws Exception;

}
