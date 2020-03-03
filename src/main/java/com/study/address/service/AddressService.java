package com.study.address.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.study.address.client.AddressClient;
import com.study.address.model.Address;
import com.study.address.repository.AddressRepository;
import com.study.address.service.producer.AddressProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AddressService {

    @Autowired
    AddressClient client;

    @Autowired
    AddressRepository repository;

    @Autowired
    AddressProducer producer;

    public Address findAddressByZipCode(String zipCode) {
        Gson gson = new Gson();
        Map<String, Object> clientAddress = client.findAddressByZipCode(zipCode);
        Address address = gson.fromJson(gson.toJsonTree(clientAddress), Address.class);
        producer.sendMessage(gson.toJsonTree(clientAddress).toString());
        return repository.save(address);
    }
}
