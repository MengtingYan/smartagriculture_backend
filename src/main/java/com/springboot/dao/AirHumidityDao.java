package com.springboot.dao;

import com.springboot.dao.bo.AirHumidity;
import com.springboot.mapper.AirHumidityPoMapper;
import com.springboot.mapper.po.AirHumidityPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AirHumidityDao {

    private AirHumidityPoMapper airHumidityPoMapper;

    @Autowired
    public AirHumidityDao(AirHumidityPoMapper airHumidityPoMapper){
        this.airHumidityPoMapper=airHumidityPoMapper;
    }

    private AirHumidity getBo(AirHumidityPo po){
        AirHumidity bo=AirHumidity.builder().id(po.getId()).humidity(po.getHumidity()).build();
        return bo;
    }

    public List<AirHumidity> retrieveAll() throws RuntimeException{
        List<AirHumidityPo> reList=this.airHumidityPoMapper.findAll().stream().collect(Collectors.toList());
        if(null == reList || reList.size()==0)
            return new ArrayList<>();
        List<AirHumidity> ret=reList.stream().map(po-> getBo(po)).collect(Collectors.toList());
        return ret;
    }
}
