package com.cly.lseaes.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserEnterDTO {
    private Integer id;

    private String name;

    private String password;

    private String grade;

    private String college;

    private String major;

    private Integer userType;

    private List<EnterDTO> enterDTOList;
}
