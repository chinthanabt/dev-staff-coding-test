package com.defstaff.coding.test.repository;

import com.defstaff.coding.test.entity.Crop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface CropRepository extends CrudRepository<Crop, Long>{
    List<Crop> findByFarmId(Long farmId);
    List<Crop> findByType(String type);
}
