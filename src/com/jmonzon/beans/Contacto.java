package com.jmonzon.beans;

import lombok.*;

/**
 * @author Jorge Monzón
 * @project ejercicio04_agenda
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Contacto {

    private String nombre;
    private String email;
    private int edad;

}
