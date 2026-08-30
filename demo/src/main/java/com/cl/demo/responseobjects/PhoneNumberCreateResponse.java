package com.cl.demo.responseobjects;

import com.cl.demo.entities.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PhoneNumberCreateResponse {

    String phoneNumberId;
    String countryCode;
    Long phoneNumber;public static PhoneNumberCreateResponse convert(PhoneNumber phoneNumber) {
        if (phoneNumber == null || phoneNumber.getId() == null) return null;
        PhoneNumberCreateResponse response = new PhoneNumberCreateResponse();
        response.setPhoneNumberId(phoneNumber.getId().toString());
        response.setCountryCode(phoneNumber.getCountryCode());
        response.setPhoneNumber(phoneNumber.getPhoneNumber());
        return response;
    }

    public static List<PhoneNumberCreateResponse> convert(List<PhoneNumber> phoneNumbers) {
        List<PhoneNumberCreateResponse> responseList = new ArrayList<>();
        for (PhoneNumber pn : phoneNumbers) {
            PhoneNumberCreateResponse res = convert(pn);
            if (res != null) responseList.add(res);
        }
        return responseList;
    }
}