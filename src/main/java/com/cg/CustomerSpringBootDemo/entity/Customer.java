package com.cg.CustomerSpringBootDemo.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer phonenumber;

    @Column
    private String address;

//    public Customer(Integer id, String name, Integer phonenumber, String address) {
//        this.id = id;
//        this.name = name;
//        this.phonenumber = phonenumber;
//        this.address = address;
//    }

    public Customer(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phonenumber=" + phonenumber +
                ", address='" + address + '\'' +
                '}';
    }
}
