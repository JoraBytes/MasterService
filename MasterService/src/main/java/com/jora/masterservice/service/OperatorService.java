package com.jora.masterservice.service;

import java.util.List;

import com.jora.masterservice.main.entity.Operator;

public interface OperatorService {

	List<Operator> getAllOperators() throws Exception;

	Operator save(Operator operator) throws Exception;

}
