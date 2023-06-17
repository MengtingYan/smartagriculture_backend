package com.springboot.mapper;

import com.springboot.mapper.po.LightIntensityPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightIntensityPoMapper extends JpaRepository<LightIntensityPo,Long> {
}
