package com.jora.masterservice.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jora.masterservice.main.entity.Operator;

@Repository
public interface OperatorDao extends JpaRepository<Operator, Integer> {

	Operator findByActiveAndOperatorCode(String active, int operCode) throws Exception;

	List<Operator> findAllByActive(String active);

}
