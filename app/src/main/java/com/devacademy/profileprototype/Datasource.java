package com.devacademy.profileprototype;

import java.util.ArrayList;

/**
 * Created by Alin on 4/9/2016.
 */
public class Datasource {
    private static ArrayList<MenuItem> arrayOfMenuItems;

    public void initDatasource () {
        arrayOfMenuItems = new ArrayList<>();
        arrayOfMenuItems.add(new SimpleMenuItem("Name", "empty"));
        arrayOfMenuItems.add(new SimpleMenuItem("Age", "empty"));
        arrayOfMenuItems.add(new SimpleMenuItem("E-Mail", "empty"));
        arrayOfMenuItems.add(new SimpleMenuItem("Country", "empty"));
        arrayOfMenuItems.add(new SimpleMenuItem("Phone number", "empty"));
    }

    public ArrayList<MenuItem> getDatasource () {
        if (arrayOfMenuItems == null) {
            initDatasource ();
        }
        return  arrayOfMenuItems;
    }

    public void setValue(String propertyName, String value) {
        for(MenuItem item : arrayOfMenuItems) {
            if(item.getName().compareTo(propertyName) == 0) {
                item.setValue(value);
            }
        }
    }

}
