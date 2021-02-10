package com.nextgate.assesment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import com.nextgate.assesment.models.Singer;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    private Integer id;

    // @OneToOne(cascade = CascadeType.ALL)
    // // @JoinColumn(name = "singer_id", referencedColumnName = "id")
    // @PrimaryKeyJoinColumn
    private String singer;

    private String album;
    
    // YYYY
    private String year;

    private String company;

    // Constructors

    protected Album() {}

    public Album (String singer, String album, String year, String company){
        this.singer = singer;
        this.album = album;
        this.year = year;
        this.company = company;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, singer='%s', album='%s', year='%s', company='%s']",
            id, singer, album, year, company);
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


}