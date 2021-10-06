package edu.apis.restTemplate.model;

import lombok.Data;

@Data
public class UniversityDTO {
    private String[] domains;
    private String name;
    private String country;
    private String alpha_two_code;
    private String state_province;
    private String[] web_pages;
}
