package com.study.address.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@FeignClient(name = "addressService", url = "http://viacep.com.br")
public interface AddressClient {

    @GetMapping(path = "/ws/{zipCode}/json/", consumes = "application/json")
    @ResponseBody
    public Map<String, Object> findAddressByZipCode(@PathVariable("zipCode") String zipCode);
}
