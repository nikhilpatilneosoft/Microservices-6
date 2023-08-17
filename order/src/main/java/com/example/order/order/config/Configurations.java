package com.example.order.order.config;

import feign.Feign;
import feign.codec.Decoder;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.client.RestTemplate;

import javax.management.modelmbean.ModelMBean;

@Configuration
@EnableFeignClients
public class Configurations {

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
//        return builder.setConnectTimeout(Duration.ofMillis(300000))
//                .setReadTimeout(Duration.ofMillis(300000)).build();
    }

    @Bean
    public ModelMapper createModelMapper()
    {
        return new ModelMapper();
    }
}
