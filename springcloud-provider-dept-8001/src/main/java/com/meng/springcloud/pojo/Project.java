package com.meng.springcloud.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Project {
    private int id;
    private String code;
    private String name;
    private String address;
    private int u_id;
    private String company;
    private int status;
    private int parentId;
    private int personNum;
    private String region;
    private String description;

}
