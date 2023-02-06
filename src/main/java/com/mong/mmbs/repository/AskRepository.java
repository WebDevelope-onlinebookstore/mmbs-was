package com.mong.mmbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mong.mmbs.entity.AskEntity;

@Repository
public interface AskRepository extends JpaRepository<AskEntity, Integer>{

}
