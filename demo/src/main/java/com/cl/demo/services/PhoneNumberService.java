package com.cl.demo.services;


import com.cl.demo.DemoApplication;
import com.cl.demo.entities.PhoneNumber;
import com.cl.demo.requestobjects.PhoneNumberCreateRequest;
import com.cl.demo.requestobjects.PhoneNumberUpdateRequest;
import com.cl.demo.utils.HelperUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PhoneNumberService {
    public static final String PHONE_NUMBER_SAVED = "PHONE NUMBER SAVED";

    public PhoneNumber addPhoneNumber(PhoneNumberCreateRequest requestObj) {
        PhoneNumber phoneNumber = new PhoneNumber();

        phoneNumber.setId(UUID.randomUUID());
        phoneNumber.setIsActive(Boolean.TRUE);
        phoneNumber.setCreatedDate(new Date());

        phoneNumber.setCountryCode(requestObj.getCountryCode());
        phoneNumber.setPhoneNumber(requestObj.getPhoneNumber());

        DemoApplication.phoneNumberList.add(phoneNumber);
        return phoneNumber;
    }

    public PhoneNumber getPhoneNumberById(String uuid) {
        for (PhoneNumber pn : DemoApplication.phoneNumberList) {
            if (pn.getId().toString().equals(uuid) && pn.getIsActive()) {
                return pn;
            }
        }
        return new PhoneNumber();
    }
    public List<PhoneNumber> getAllPhoneNumbers() {
        List<PhoneNumber> resultList = new ArrayList<>();
        for (PhoneNumber pn : DemoApplication.phoneNumberList) {
            if (pn.getIsActive()) {
                resultList.add(pn);
            }
        }
        return resultList;
    }

}
