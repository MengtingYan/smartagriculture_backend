package com.springboot.service;

import com.springboot.dao.TemperatureDao;
import com.springboot.dao.bo.Temperature;
import com.springboot.service.dto.TemperatureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgricultureService {

    private final TemperatureDao temperatureDao;

    @Autowired
    public AgricultureService(TemperatureDao temperatureDao) {
        this.temperatureDao = temperatureDao;
    }

    public List<TemperatureDto> retrieveTemperatures(){
        List<Temperature> temperatures=this.temperatureDao.retrieveAll();
        List<TemperatureDto> ret=temperatures.stream().map(obj->{
            TemperatureDto dto=TemperatureDto.builder().temperature(obj.getValue()).build();
            return dto;
        }).collect(Collectors.toList());
        return ret;
    }
}
