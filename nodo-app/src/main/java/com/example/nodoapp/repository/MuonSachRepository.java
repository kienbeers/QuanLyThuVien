package com.example.nodoapp.repository;

import com.example.nodoapp.model.MuonSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuonSachRepository extends JpaRepository<MuonSach, Integer> {

}

