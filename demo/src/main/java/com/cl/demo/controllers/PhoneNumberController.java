package com.cl.demo.controllers;

import com.cl.demo.entities.PhoneNumber;
import com.cl.demo.requestobjects.PhoneNumberCreateRequest;
import com.cl.demo.requestobjects.PhoneNumberUpdateRequest;
import com.cl.demo.responseobjects.PhoneNumberCreateResponse;
import com.cl.demo.responseobjects.PhoneNumberUpdateResponse;
import com.cl.demo.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phoneNumber")
public class PhoneNumberController {
    @Autowired
    public PhoneNumberService phoneNumberService;

    @PostMapping("add")
    public PhoneNumberCreateResponse addPhoneNumber(@RequestBody PhoneNumberCreateRequest requestObj) {
        return PhoneNumberCreateResponse.convert(phoneNumberService.addPhoneNumber(requestObj));
    }

    @GetMapping("getById")
    public PhoneNumberCreateResponse getPhoneNumberById(@RequestParam String uuid) {
        return PhoneNumberCreateResponse.convert(phoneNumberService.getPhoneNumberById(uuid));
    }


}
