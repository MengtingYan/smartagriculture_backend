package com.springboot.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import static org.hamcrest.CoreMatchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class AgricultureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTemperaturesTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/agriculture/temperatures")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        //获取返回结果
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void getAirHumiditiesTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/agriculture/humidities")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        //获取返回结果
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void getLightIntensitiesTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/agriculture/intensities")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        //获取返回结果
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void getSoilMoisturesTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/agriculture/moistures")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        //获取返回结果
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void getSoilPhsTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/agriculture/phs")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        //获取返回结果
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }
}
