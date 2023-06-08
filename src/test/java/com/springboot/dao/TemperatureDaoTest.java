package com.springboot.dao;

import com.springboot.AgricultureApplication;
import com.springboot.dao.bo.Temperature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class TemperatureDaoTest {
    @Autowired
    private TemperatureDao temperatureDao;

    @Test
    void retrieveAllTest(){
        List<Temperature> ret = temperatureDao.retrieveAll();
        System.out.println(ret);
    }
}
