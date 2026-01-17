package com.example.instaCatBack.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.instaCatBack.domain.Cat;

public interface CatRepository extends JpaRepository<Cat, String> {

}
