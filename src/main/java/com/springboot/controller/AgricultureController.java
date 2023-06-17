package com.springboot.controller;

import com.springboot.service.AgricultureService;
import com.springboot.service.MqttService;
import com.springboot.service.dto.*;
import model.ReturnNo;
import model.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/agriculture", produces = "application/json;charset=UTF-8")
public class AgricultureController {

    private final AgricultureService agricultureService;

    private final MqttService mqttService;

    @Autowired
    public AgricultureController(AgricultureService agricultureService,MqttService mqttService){
        this.agricultureService=agricultureService;
        this.mqttService=mqttService;
    }

    @GetMapping("/sensor")
    public void start(@RequestParam String topic){
        mqttService.start(topic);
    }

    @GetMapping("/temperatures")
    public ReturnObject getTemperatures(){
        List<TemperatureDto> ret=this.agricultureService.retrieveTemperatures();
        return new ReturnObject(ReturnNo.OK,ret);
    }

    @GetMapping("/humidities")
    public ReturnObject getAirHumidities(){
        List<AirHumidityDto> ret=this.agricultureService.retrieveHumidities();
        return new ReturnObject(ReturnNo.OK,ret);
    }

    @GetMapping("/intensities")
    public ReturnObject getLightIntensities(){
        List<LightIntensityDto> ret=this.agricultureService.retrieveIntensities();
        return new ReturnObject(ReturnNo.OK,ret);
    }

    @GetMapping("/moistures")
    public ReturnObject getSoilMoistures(){
        List<SoilMoistureDto> ret=this.agricultureService.retrieveMoistures();
        return new ReturnObject(ReturnNo.OK,ret);
    }

    @GetMapping("/phs")
    public ReturnObject getSoilPhs(){
        List<SoilPhDto> ret=this.agricultureService.retrievePhs();
        return new ReturnObject(ReturnNo.OK,ret);
    }
}
