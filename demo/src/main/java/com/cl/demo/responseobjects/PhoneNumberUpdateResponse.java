package com.cl.demo.responseobjects;

import com.cl.demo.entities.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PhoneNumberUpdateResponse {
    String phoneNumberId;
     String countryCode;
     Long phoneNumber;

    public static PhoneNumberUpdateResponse convert(PhoneNumber phoneNumber) {
        if (phoneNumber == null || phoneNumber.getId() == null) return null;
        PhoneNumberUpdateResponse response = new PhoneNumberUpdateResponse();
        response.setPhoneNumberId(phoneNumber.getId().toString());
        response.setCountryCode(phoneNumber.getCountryCode());
        response.setPhoneNumber(phoneNumber.getPhoneNumber());
        return response;
    }

    public static List<PhoneNumberUpdateResponse> convert(List<PhoneNumber> phoneNumbers) {
        List<PhoneNumberUpdateResponse> responseList = new ArrayList<>();
        for (PhoneNumber pn : phoneNumbers) {
            PhoneNumberUpdateResponse res = convert(pn);
            if (res != null) responseList.add(res);
        }
        return responseList;
    }
}

