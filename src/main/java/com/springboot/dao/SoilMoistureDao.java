package com.springboot.dao;

import com.springboot.dao.bo.SoilMoisture;
import com.springboot.mapper.SoilMoisturePoMapper;
import com.springboot.mapper.po.SoilMoisturePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SoilMoistureDao {

    private SoilMoisturePoMapper soilMoisturePoMapper;

    @Autowired
    public SoilMoistureDao(SoilMoisturePoMapper soilMoisturePoMapper){
        this.soilMoisturePoMapper=soilMoisturePoMapper;
    }

    private SoilMoisture getBo(SoilMoisturePo po){
        SoilMoisture bo=SoilMoisture.builder().id(po.getId()).moisture(po.getMoisture()).build();
        return bo;
    }

    public List<SoilMoisture> retrieveAll() throws RuntimeException{
        List<SoilMoisturePo> reList=this.soilMoisturePoMapper.findAll().stream().collect(Collectors.toList());
        if(null == reList || reList.size()==0)
            return new ArrayList<>();
        List<SoilMoisture> ret=reList.stream().map(po-> getBo(po)).collect(Collectors.toList());
        return ret;
    }
}
