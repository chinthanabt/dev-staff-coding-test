package com.defstaff.coding.test.controller;

import com.defstaff.coding.test.constants.StatusCode;
import com.defstaff.coding.test.domain.BaseResponse;
import com.defstaff.coding.test.domain.farm.CropDTO;
import com.defstaff.coding.test.service.CropService;
import com.defstaff.coding.test.utils.CropType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/farm")
public class FarmController {
    private final CropService cropService;

    public FarmController(CropService cropService) {
        this.cropService = cropService;
    }

    @PostMapping("/planted")
    public ResponseEntity<BaseResponse> addPlantedCrop(@RequestBody CropDTO crop) {
        cropService.saveCrop(crop);
        var response = BaseResponse.of(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDesc(), null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/harvested")
    public ResponseEntity<BaseResponse> addHarvestedCrop(@RequestBody CropDTO crop) {
        cropService.saveCrop(crop);
        var response = BaseResponse.of(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDesc(), null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{farmId}")
    public ResponseEntity<BaseResponse> getCropsByFarm(@PathVariable Long farmId) {
        var result = cropService.getCropsByFarmId(farmId);
        var response = BaseResponse.of(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDesc(), result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/crop-type/{type}")
    public ResponseEntity<BaseResponse> getCropsByType(@PathVariable CropType type) {
        var result = cropService.getCropsByType(type.name());
        var response = BaseResponse.of(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDesc(), result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
