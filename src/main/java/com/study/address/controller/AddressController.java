package com.study.address.controller;

import com.study.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService service;

    @PostMapping("/{zipCode}")
    @ResponseBody
    public ResponseEntity<?> getAddressByZipCode(@PathVariable("zipCode") String zipCode) {
        return ResponseEntity.ok(service.findAddressByZipCode(zipCode));
    }
}
