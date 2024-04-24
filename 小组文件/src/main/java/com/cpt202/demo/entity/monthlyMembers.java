package com.cpt202.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class monthlyMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String months;
    private int members;

    

    public monthlyMembers(long id, String months, int members) {
        this.id = id;
        this.months = months;
        this.members = members;
    }
    public monthlyMembers() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMonths() {
        return months;
    }
    public void setMonths(String months) {
        this.months = months;
    }
    public int getMembers() {
        return members;
    }
    public void setMembers(int members) {
        this.members = members;
    }

}
