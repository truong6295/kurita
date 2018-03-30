package com.kurita.ass.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kurita.ass.model.Type;

@Repository
public interface TypeDAO extends JpaRepository<Type,Integer>{
	Type findByidtype(int id); 
}
