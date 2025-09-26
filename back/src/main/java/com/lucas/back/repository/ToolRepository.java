package com.lucas.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.back.entity.Tool;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
  
}
