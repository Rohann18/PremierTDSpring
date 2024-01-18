package com.inti.repository;

import com.inti.model.Soliste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolisteRepository extends JpaRepository<Soliste, Long>{

}
