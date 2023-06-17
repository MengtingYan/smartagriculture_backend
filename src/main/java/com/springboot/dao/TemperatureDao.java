package com.springboot.dao;

import com.springboot.dao.bo.Temperature;
import com.springboot.mapper.TemperaturePoMapper;
import com.springboot.mapper.po.TemperaturePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TemperatureDao {

    private TemperaturePoMapper temperaturePoMapper;

    @Autowired
    public TemperatureDao(TemperaturePoMapper temperaturePoMapper){
        this.temperaturePoMapper=temperaturePoMapper;
    }

    private Temperature getBo(TemperaturePo po){
        Temperature bo=Temperature.builder().id(po.getId()).tem(po.getTem()).build();
        return bo;
    }

    public List<Temperature> retrieveAll() throws RuntimeException{
        List<TemperaturePo> reList=this.temperaturePoMapper.findAll().stream().collect(Collectors.toList());
        if(null == reList || reList.size()==0)
            return new ArrayList<>();
        List<Temperature> ret=reList.stream().map(po-> getBo(po)).collect(Collectors.toList());
        return ret;
    }
}
