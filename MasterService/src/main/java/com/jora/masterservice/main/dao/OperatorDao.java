package com.jora.masterservice.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jora.masterservice.main.entity.Operator;

@Repository
public interface OperatorDao extends JpaRepository<Operator, Integer> {

	Operator findByActiveAndOperatorCode(String string, int operCode) throws Exception;

}
