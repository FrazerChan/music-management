package com.nextgate.assesment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Singer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    private Integer id;

    private String name;

    // YYYMMDD
    private String dob;
    
    private String sex;

    private String company;


    // Constructors

    /**
     * Default constructor
     */
    protected Singer() {}

    /**
     * Primary constructor
     * 
     * @param name singer's name
     * @param dob singers dob YYYYMMDD
     * @param sex sex of the singer
     * @param company company of the singer
     */
    public Singer (String name, String dob, String sex, String company){
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.company = company;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, name='%s', dob='%s', sex='%s', company='%s']",
            id, name, dob, sex, company);
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


}