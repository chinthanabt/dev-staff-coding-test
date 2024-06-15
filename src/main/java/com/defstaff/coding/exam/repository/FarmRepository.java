package com.defstaff.coding.exam.repository;

import com.defstaff.coding.exam.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

}
