package com.devacademy.profileprototype;

/**
 * Created by Alin on 4/8/2016.
 */
public class SimpleMenuItem extends MenuItem {
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.value = name;
    }

    @Override
    public String getValue() {
        return (String) value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    public SimpleMenuItem(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
