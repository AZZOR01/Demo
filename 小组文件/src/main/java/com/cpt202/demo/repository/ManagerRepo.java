package com.cpt202.demo.repository;

import com.cpt202.demo.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//codeby:Haoyu.li

@Repository

public interface ManagerRepo extends JpaRepository<Manager,Long> {
    //Custom queries
    Optional<Manager> findById(Long id);
}
