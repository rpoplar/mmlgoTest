package com.mmlgo.yh.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Person {
    private String Name;
    private String Address;
    private int Age;
    private Date Birthday;
}
