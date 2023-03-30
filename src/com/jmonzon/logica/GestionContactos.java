package com.jmonzon.logica;

import com.jmonzon.beans.Contacto;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author Jorge Monzón
 * @project ejercicio04_agenda
 */
public class GestionContactos {

    //  CLAVE Y TIPO DE VALOR
    HashMap<String, Contacto> agenda;

    public GestionContactos() {
//        incializar mi instancia de mi objeto HashMap
        agenda = new HashMap<>();
    }

    public boolean agregar(String nombre, String email, int edad) {
//        si existe, se añade
        if (!agenda.containsKey(email)) {
            Contacto contactonuevo = new Contacto(nombre, email, edad);
            agenda.put(email, contactonuevo);
            return true;
        } else {
            return false;
        }
    }

    public Contacto buscar(String email) {

        Contacto contactoBuscado = null;

        if (agenda.containsKey(email)) {
//            obtengo el obejto de tipo Contacto mediante el metodo get y parametro clave
            contactoBuscado = agenda.get(email);
        }
//        Devuelve el contacto encontrado, y si no null
        return contactoBuscado;
    }

    public boolean eliminar(String email) {

//        si encuentra la clave dentro de la colección
        if (agenda.containsKey(email)) {
//            elimina
            agenda.remove(email);
            return true;
        } else {

            return false;
        }
    }

    public Contacto[] recuperarContactor(){
//        Crea un array con el tamaño de los existentes
//        y vuelca en el los contactos almacenados
        Contacto[] existentes = new Contacto[agenda.size()];
        int i = 0;
//        obtengo los valores de hasmap y los asigno a una coleeción de tipo de dato de los values del hashMap
        Collection<Contacto> valores = agenda.values();
        for(Contacto elemento: valores){
            existentes[i] = elemento;
            i++;
        }
        return existentes;
    }


}
