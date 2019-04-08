package com.coldwarm7.websocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "glossary_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Glossary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String english;
    private String chinese;


}
