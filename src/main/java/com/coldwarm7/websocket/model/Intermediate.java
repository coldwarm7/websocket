package com.coldwarm7.websocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "intermediate_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Intermediate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int user_id;
    private int glossary_id;
}
