package com.mong.mmbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mong.mmbs.entity.PlaytoyEntity;

@Repository
public interface PlaytoyRepository extends JpaRepository<PlaytoyEntity, Integer>{

}
