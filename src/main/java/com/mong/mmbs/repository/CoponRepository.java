package com.mong.mmbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mong.mmbs.entity.CoponEntity;

@Repository
public interface CoponRepository extends JpaRepository<CoponEntity, Integer>{

}
