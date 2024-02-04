package com.productservices.productservices.models;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter

public class Product extends BaseMode {
    private String title;
    private double price;
    private String description;
    private Category category;
    private String imageUrl;

}