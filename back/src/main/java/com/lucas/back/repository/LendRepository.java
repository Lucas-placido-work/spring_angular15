package com.lucas.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.back.entity.Lend;

@Repository
public interface LendRepository extends JpaRepository<Lend, Long> {
  
}
