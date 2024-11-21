package com.pd.shipment_service1.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean {


    @Bean
    public ModelMapper getBean() {
        return new ModelMapper();
    }
}
