package com.example.order.order.util;

import org.springframework.cloud.openfeign.FeignContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

public class GenericCodeForFeignClientRequest {

//    private final FeignContext feignContext;
//
//    public <T, R> ResponseEntity<R> doRequest(String serviceName, String url, T request, Class<R> responseType, RequestMethod method) {
//        FeignClientFactoryBean clientFactoryBean = new FeignClientFactoryBean(feignContext, serviceName);
//        Object feignClient = clientFactoryBean.getObject();
//        FeignInvocationHandler invocationHandler = (FeignInvocationHandler) Proxy.getInvocationHandler(feignClient);
//
//        return invocationHandler.invoke(method, url, request, responseType);
//    }
}
