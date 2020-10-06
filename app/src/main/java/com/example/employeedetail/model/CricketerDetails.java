package com.example.employeedetail.model;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class CricketerDetails implements Serializable {



    private String cricketerFullName;
    private String cricketerRole;
    private int cricketerImage;
    private int cricketerAge;
    private String cricketerCountry;

    public CricketerDetails( String cricketerFullName, String cricketerRole, int cricketerImage, int cricketerAge, String cricketerCountry) {

        this.cricketerFullName = cricketerFullName;
        this.cricketerRole = cricketerRole;
        this.cricketerImage = cricketerImage;
        this.cricketerAge = cricketerAge;
        this.cricketerCountry = cricketerCountry;
    }



    public String getCricketerFullName() {
        return cricketerFullName;
    }

    public String getCricketerRole() {
        return cricketerRole;
    }

    public int getCricketerImage() {
        return cricketerImage;
    }

    public int getCricketerAge() {
        return cricketerAge;
    }

    public String getCricketerCountry() {
        return cricketerCountry;
    }
}
