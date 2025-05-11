package com.onkar.Quiz_service.dao;
import com.onkar.Quiz_service.model.Quize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizeDao extends JpaRepository<Quize,Integer> {

}
