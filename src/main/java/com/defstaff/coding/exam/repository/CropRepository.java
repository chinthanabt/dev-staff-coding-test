package com.defstaff.coding.exam.repository;

import com.defstaff.coding.exam.entity.Crop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CropRepository extends CrudRepository<Crop, Long>{
    List<Crop> findByFarmId(Long farmId);
    List<Crop> findByType(String type);
}
