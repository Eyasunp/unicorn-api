package com.example.api.unicorns.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.unicorns.bean.UnicornEntity;

@Repository
public interface UnicornRepository extends JpaRepository<UnicornEntity, Long> {

}
