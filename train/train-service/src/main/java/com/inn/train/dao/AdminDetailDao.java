package com.inn.train.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.train.model.AdminDetail;

@Repository
public interface AdminDetailDao extends JpaRepository<AdminDetail, Integer>{

}
