package com.kurita.ass.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kurita.ass.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	User findByIduser(int id);
}
