package com.devacademy.profileprototype;

/**
 * Created by Alin on 4/8/2016.
 */
public abstract class MenuItem {
    abstract public String getName();
    abstract public void setName(String name);
    abstract public Object getValue();
    abstract public void setValue(String value);

    String name;
    Object value;


}
