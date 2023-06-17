package com.springboot.mapper;

import com.springboot.mapper.po.SoilMoisturePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilMoisturePoMapper extends JpaRepository<SoilMoisturePo,Long>{
}
