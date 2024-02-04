package com.productservices.productservices.models;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class Category extends BaseMode {

    private  String name;
    private String  description;
    private List<Product> products;
}
