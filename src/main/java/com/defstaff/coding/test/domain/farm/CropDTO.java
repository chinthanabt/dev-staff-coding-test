package com.defstaff.coding.test.domain.farm;

import lombok.Data;

import java.util.UUID;

@Data
public class CropDTO {
    private String type;
    private double plantingArea;
    private double expectedProduct;
    private double actualProduct;
    private Long farmId;

}
