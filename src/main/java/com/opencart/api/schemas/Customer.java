package com.opencart.api.schemas;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
