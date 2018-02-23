package com.mmlgo.yh.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProjectMaster {
    private int SysNo;
    private int ParentProjectSysNo;
    private String ProjectCode;
    private String ContractorCode;
    private String SecretKey;
    private String Version;
    private String ProjectName;
    private String ShortName;
    private String Pinyin;
    private String OwnerName;
    private int Status;
    private int ProjectStatus;
    private int InUserSysNo;
    private String InUserName;
    private Date InDate;
    private String EditUserName;
    private Date EditDate;

}
