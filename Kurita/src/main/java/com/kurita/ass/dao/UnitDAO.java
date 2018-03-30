package com.kurita.ass.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kurita.ass.model.Unit;
@Repository
public interface UnitDAO extends JpaRepository<Unit, Integer> {
	Unit findByIdunit(int id);
}
