package com.example.td.DAO;

import com.example.td.Models.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {
}