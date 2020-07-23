package com.bigredgames.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigredgames.model.Guest;

public interface GroupDao extends JpaRepository<Guest, Integer>{

}
