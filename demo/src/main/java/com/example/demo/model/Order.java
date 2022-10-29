package com.example.demo.model;

import javax.persistence.*;

//lombok или record?
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clientid")
    private Integer clientid;

    @Column(name = "amount")
    private Double amount;


    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getClientId(){return clientid; }

    public void setClientId(Integer clientid){
        this.clientid = clientid;
    }

    public Double getAmount(){
        return amount;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }


}
