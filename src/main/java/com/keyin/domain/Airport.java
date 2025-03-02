package com.keyin.domain;

public class Airport {

    // Private fields for Airport details
    private Long id;
    private String name;
    private String code;
    private Cities city;

    // Getter and setter methods for each field

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    // method to get the city ID

    public Long getCityByID() {
        return 0L;
    }
}
