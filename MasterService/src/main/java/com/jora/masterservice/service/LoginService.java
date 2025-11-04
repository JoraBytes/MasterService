package com.jora.masterservice.service;

import java.util.List;

import com.jora.masterservice.main.entity.Operator;

public interface LoginService {

	Operator chkOperator(int operCode) throws Exception;

	List<Operator> loadOperator() throws Exception;

}
