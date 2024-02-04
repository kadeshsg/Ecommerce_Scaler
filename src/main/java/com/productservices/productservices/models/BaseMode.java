package com.productservices.productservices.models;
import lombok.Getter;
import lombok.Setter;

import  java.util.*;

@Getter
@Setter
public class BaseMode {

    private  Long id;
    private Date CreatedAt;
    private  Date lastUpdatedAt;
    private boolean isDeleted;


}
