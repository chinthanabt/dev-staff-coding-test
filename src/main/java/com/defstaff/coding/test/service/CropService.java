package com.defstaff.coding.test.service;

import com.defstaff.coding.test.configuration.exceptionHandler.NotFoundException;
import com.defstaff.coding.test.domain.farm.CropDTO;
import com.defstaff.coding.test.entity.Crop;
import com.defstaff.coding.test.entity.Farm;
import com.defstaff.coding.test.repository.CropRepository;
import com.defstaff.coding.test.repository.FarmRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CropService {
    private final CropRepository cropRepository;

    private final FarmRepository farmRepository;

    public CropService(CropRepository cropRepository, FarmRepository farmRepository) {
        this.cropRepository = cropRepository;
        this.farmRepository = farmRepository;
    }

    public void saveCrop(CropDTO cropDto) {
        Crop crop = new Crop();
        //throw NotFoundException exception if farm not found.
        final Farm farm = farmRepository.findById(cropDto.getFarmId()).orElseThrow(NotFoundException::new);
        crop.setFarm(farm);
        BeanUtils.copyProperties(cropDto, crop);
        cropRepository.save(crop);
    }

    public List<CropDTO> getCropsByFarmId(Long farmId) {
        List<CropDTO> cropList = new ArrayList<>();
        final List<Crop> byFarmId = cropRepository.findByFarmId(farmId);
        if(CollectionUtils.isEmpty(byFarmId)) {
            throw new NotFoundException();
        }
        for(Crop crop : byFarmId){
            CropDTO cropDTO = new CropDTO();
            cropDTO.setFarmId(farmId);
            BeanUtils.copyProperties(crop, cropDTO);
            cropList.add(cropDTO);
        }
        return cropList;
    }

    public List<CropDTO> getCropsByType(String type) {
        List<CropDTO> cropList = new ArrayList<>();
        final List<Crop> byType = cropRepository.findByType(type);
        if(CollectionUtils.isEmpty(byType)) {
            throw new NotFoundException();
        }
        for(Crop crop : byType){
            CropDTO cropDTO = new CropDTO();
            BeanUtils.copyProperties(crop, cropDTO);
            cropDTO.setFarmId(crop.getFarm().getId());
            cropList.add(cropDTO);
        }
        return cropList;
    }
}
