package org.ia.stores;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Status {


    private @Id @GeneratedValue Long id;
    private int price;
    private String model;
    private String stored;



}
