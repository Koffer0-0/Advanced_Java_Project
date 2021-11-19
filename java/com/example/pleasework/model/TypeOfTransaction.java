package com.example.pleasework.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "typeOfTransaction")
public class TypeOfTransaction {
    @Id
    private Long id;
    private String name;

    public TypeOfTransaction(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeOfTransaction(){}
}

