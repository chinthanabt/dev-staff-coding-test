package com.defstaff.coding.exam.controller;

import com.defstaff.coding.exam.entity.Crop;
import com.defstaff.coding.exam.service.CropService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class FarmCollectorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CropService cropService;

    @Test
    public void testAddPlantedCrop() throws Exception {
        Crop crop = new Crop();
        crop.setType("CORN");
        crop.setPlantingArea(40);
        crop.setExpectedProduct(80);

        mockMvc.perform(post("/farm/planted")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\": \"CORN\", \"plantingArea\": 40, \"expectedProduct\": 80, \"farmId\":  1 }"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCropsByFarm() throws Exception {
        mockMvc.perform(get("/farm/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCropsByType() throws Exception {
        mockMvc.perform(get("/farm/crop-type/CORN"))
                .andExpect(status().isOk());
    }
}
