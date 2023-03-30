package com.jmonzon.presentacion;

import com.jmonzon.beans.Contacto;
import com.jmonzon.logica.GestionContactos;

import java.util.Scanner;

/**
 * @author Principal
 * @project ejercicio04_agenda
 */
public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        GestionContactos gestor = new GestionContactos();

        int operacion;
        int edad;
        String nombre, email;

        do {

            System.out.println("\nMenu");
            System.out.println("1- Añadir Contacto");
            System.out.println("2- Buscar Contacto");
            System.out.println("3- Eliminar Contacto");
            System.out.println("4- Mostrar Todos");
            System.out.println("5- Salir");
            System.out.println("Ingresar la operación");
            operacion = entrada.nextInt();


            switch (operacion) {
                case 1:
                    System.out.println("\nIngresar nombre");
                    entrada.nextLine();
                    nombre = entrada.nextLine();
                    System.out.println("\nIngresar edad");
                    edad = Integer.parseInt(entrada.nextLine());
                    System.out.println("\nIngresar email");
                    email = entrada.nextLine();

                    if (gestor.agregar(nombre, email, edad)) {
                        System.out.println("Contacto agregado");
                    } else {
                        System.out.println("Contacto ya existe");
                    }
                    break;
                case 2:

                    System.out.println("\nIngresar el email a buscar");
                    entrada.nextLine();
                    email = entrada.nextLine();


                    if (gestor.buscar(email) == null) {
                        System.out.println("No se encontro el email");
                    } else {
                        Contacto emailEncontrado = gestor.buscar(email);
                        System.out.println("Nombre:" + emailEncontrado.toString());
                    }

                    break;
                case 3:

                    System.out.println("\nIngresar email a eliminar");
                    entrada.nextLine();
                    email = entrada.nextLine();

                    if (gestor.eliminar(email)) {
                        System.out.println("Se elimino contacto");
                    } else {
                        System.out.println("No se encontro contacto a eliminar");
                    }
                    break;
                case 4:
                    Contacto arregloMostrar[] = gestor.recuperarContactor();

//                    valido si se encuentran elementos por medio de la longitud del array
                    if (arregloMostrar.length > 0) {
                        for (int i = 0; i < arregloMostrar.length; i++) {
                            System.out.println(arregloMostrar[i].getNombre() + " - " + arregloMostrar[i].getEdad() + " - " + arregloMostrar[i].getEdad());
                        }
                    } else {
                        System.out.println("No se encuentran contacto a mostrar");
                    }

                    break;
                case 5:
                    break;
                default:
                    break;
            }

        } while (operacion != 5);


    }
}
