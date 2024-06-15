package com.defstaff.coding.test.repository;

import com.defstaff.coding.test.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

}
