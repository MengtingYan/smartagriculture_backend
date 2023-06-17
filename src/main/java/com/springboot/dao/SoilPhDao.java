package com.springboot.dao;

import com.springboot.dao.bo.SoilPh;
import com.springboot.dao.bo.Temperature;
import com.springboot.mapper.SoilPhPoMapper;
import com.springboot.mapper.po.SoilPhPo;
import com.springboot.mapper.po.TemperaturePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SoilPhDao {

    private SoilPhPoMapper soilPHPoMapper;

    @Autowired
    public SoilPhDao(SoilPhPoMapper soilPHPoMapper){
        this.soilPHPoMapper=soilPHPoMapper;
    }

    private SoilPh getBo(SoilPhPo po){
        SoilPh bo= SoilPh.builder().id(po.getId()).ph(po.getPh()).build();
        return bo;
    }

    public List<SoilPh> retrieveAll() throws RuntimeException{
        List<SoilPhPo> reList=this.soilPHPoMapper.findAll().stream().collect(Collectors.toList());
        if(null == reList || reList.size()==0)
            return new ArrayList<>();
        List<SoilPh> ret=reList.stream().map(po-> getBo(po)).collect(Collectors.toList());
        return ret;
    }
}
