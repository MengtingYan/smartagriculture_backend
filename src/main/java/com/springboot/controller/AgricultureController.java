package com.springboot.controller;

import com.springboot.dao.bo.Temperature;
import com.springboot.service.AgricultureService;
import com.springboot.service.dto.TemperatureDto;
import model.ReturnNo;
import model.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/agriculture", produces = "application/json;charset=UTF-8")
public class AgricultureController {

    private final AgricultureService agricultureService;

    @Autowired
    public AgricultureController(AgricultureService agricultureService){
        this.agricultureService=agricultureService;
    }

    @GetMapping("/temperatures")
    public ReturnObject getTemperatures(){
        List<TemperatureDto> ret=this.agricultureService.retrieveTemperatures();
        return new ReturnObject(ReturnNo.OK,ret);
    }
}
