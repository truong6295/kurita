package com.kurita.ass.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kurita.ass.model.Event;
@Repository
public interface EventDAO extends JpaRepository<Event,Integer>{
	Event findByIdevent(int id);
}
