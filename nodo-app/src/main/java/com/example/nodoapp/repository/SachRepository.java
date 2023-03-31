package com.example.nodoapp.repository;

import com.example.nodoapp.model.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SachRepository extends JpaRepository<Sach, Integer> {

}

