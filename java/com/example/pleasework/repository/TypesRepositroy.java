package com.example.pleasework.repository;

import com.example.pleasework.model.TypeOfTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesRepositroy extends JpaRepository<TypeOfTransaction, Integer> { }