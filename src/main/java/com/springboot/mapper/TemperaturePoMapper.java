package com.springboot.mapper;

import com.springboot.mapper.po.TemperaturePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperaturePoMapper extends JpaRepository<TemperaturePo,Long> {
}
