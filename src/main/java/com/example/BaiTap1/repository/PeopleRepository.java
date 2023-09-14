package com.example.BaiTap1.repository;

import com.example.BaiTap1.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PeopleRepository extends JpaRepository<People, UUID> {

}
