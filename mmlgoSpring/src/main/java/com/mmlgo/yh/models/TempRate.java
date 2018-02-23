package com.mmlgo.yh.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class TempRate {
    private int SysNo;
    private int Type;
    private int Quantity;
    private BigDecimal Rate;
    private int InUserSysNo;
    private String InUserName;
    private Date InDate;
    private int EditUserSysNo;
    private String EditUserName;
    private Date EditDate;
}
