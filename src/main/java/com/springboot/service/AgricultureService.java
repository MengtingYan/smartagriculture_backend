package com.springboot.service;

import com.springboot.dao.*;
import com.springboot.dao.bo.*;
import com.springboot.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgricultureService {

    private final TemperatureDao temperatureDao;

    private final AirHumidityDao airHumidityDao;

    private final LightIntensityDao lightIntensityDao;

    private final SoilMoistureDao soilMoistureDao;

    private final SoilPhDao soilPhDao;

    @Autowired
    public AgricultureService(TemperatureDao temperatureDao, AirHumidityDao airHumidityDao, LightIntensityDao lightIntensityDao,
                              SoilMoistureDao soilMoistureDao, SoilPhDao soilPhDao) {
        this.temperatureDao = temperatureDao;
        this.airHumidityDao = airHumidityDao;
        this.lightIntensityDao = lightIntensityDao;
        this.soilMoistureDao = soilMoistureDao;
        this.soilPhDao = soilPhDao;
    }

    public List<TemperatureDto> retrieveTemperatures(){
        List<Temperature> temperatures=this.temperatureDao.retrieveAll();
        List<TemperatureDto> ret=temperatures.stream().map(obj->{
            TemperatureDto dto=TemperatureDto.builder().temperature(obj.getTem()).build();
            return dto;
        }).collect(Collectors.toList());
        return ret;
    }

    public List<AirHumidityDto> retrieveHumidities(){
        List<AirHumidity> humidities=this.airHumidityDao.retrieveAll();
        List<AirHumidityDto> ret=humidities.stream().map(obj->{
            AirHumidityDto dto=AirHumidityDto.builder().humidity(obj.getHumidity()).build();
            return dto;
        }).collect(Collectors.toList());
        return ret;
    }

    public List<LightIntensityDto> retrieveIntensities(){
        List<LightIntensity> lights=this.lightIntensityDao.retrieveAll();
        List<LightIntensityDto> ret=lights.stream().map(obj->{
            LightIntensityDto dto=LightIntensityDto.builder().light(obj.getLight()).build();
            return dto;
        }).collect(Collectors.toList());
        return ret;
    }

    public List<SoilMoistureDto> retrieveMoistures(){
        List<SoilMoisture> moistures=this.soilMoistureDao.retrieveAll();
        List<SoilMoistureDto> ret=moistures.stream().map(obj->{
            SoilMoistureDto dto=SoilMoistureDto.builder().moisture(obj.getMoisture()).build();
            return  dto;
        }).collect(Collectors.toList());
        return  ret;
    }

    public List<SoilPhDto> retrievePhs(){
        List<SoilPh> phs=this.soilPhDao.retrieveAll();
        List<SoilPhDto> ret=phs.stream().map(obj->{
            SoilPhDto dto=SoilPhDto.builder().ph(obj.getPh()).build();
            return dto;
        }).collect(Collectors.toList());
        return ret;
    }
}
