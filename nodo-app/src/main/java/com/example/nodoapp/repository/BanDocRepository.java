package com.example.nodoapp.repository;

import com.example.nodoapp.model.BanDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanDocRepository extends JpaRepository<BanDoc, Integer> {
}
