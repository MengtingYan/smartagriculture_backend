package com.springboot.dao;

import com.springboot.dao.bo.LightIntensity;
import com.springboot.mapper.LightIntensityPoMapper;
import com.springboot.mapper.po.LightIntensityPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LightIntensityDao {

    private LightIntensityPoMapper lightIntensityPoMapper;

    @Autowired
    public LightIntensityDao(LightIntensityPoMapper lightIntensityPoMapper){
        this.lightIntensityPoMapper=lightIntensityPoMapper;
    }

    private LightIntensity getBo(LightIntensityPo po){
        LightIntensity bo=LightIntensity.builder().id(po.getId()).light(po.getLight()).build();
        return bo;
    }

    public List<LightIntensity> retrieveAll() throws RuntimeException{
        List<LightIntensityPo> reList=this.lightIntensityPoMapper.findAll().stream().collect(Collectors.toList());
        if(null == reList || reList.size()==0)
            return new ArrayList<>();
        List<LightIntensity> ret=reList.stream().map(po-> getBo(po)).collect(Collectors.toList());
        return ret;
    }
}
