package com.EasyParking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "operador")
@NoArgsConstructor
@AllArgsConstructor
public class Operador {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idoperador;
    private String nombre;
    private String apellido;
    private String cargo;
}
