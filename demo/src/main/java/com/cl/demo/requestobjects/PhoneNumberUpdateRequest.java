package com.cl.demo.requestobjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumberUpdateRequest {
    String uuid;
    String countryCodeToUpdate;
    Long phoneNumberToUpdate;
}
