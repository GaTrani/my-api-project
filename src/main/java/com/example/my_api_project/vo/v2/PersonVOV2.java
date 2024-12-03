package com.example.my_api_project.vo.v2;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonVOV2 {

    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthDay;
}
