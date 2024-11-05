package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void Otros() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaEntradas = new ArrayList<>();

        // Vriabes asignadas a las entradas.
        String nombre;
        String usuario;
        String correo;
        String telefono;
        String salida;
        String tipoPQRSF;
        String descripcionPQRSF;
        int terminos;
        boolean opcionValida = false;

        while (!opcionValida) {
            System.out.println("\nAcepta el manejo de la política de datos?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            terminos = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt()


            // Entrada de datos usuario en el formuaio.
            switch (terminos) {
                case 1:
                    opcionValida = true;
                    while (true) {
                        System.out.print("Nombre: ");
                        nombre = scanner.nextLine();

                        System.out.print("Usuario: ");
                        usuario = scanner.nextLine();

                        System.out.print("Ingrese su correo: ");
                        correo = scanner.nextLine();

                        System.out.print("Ingrese su teléfono: ");
                        telefono = scanner.nextLine();

                        System.out.println("\nSeleccione el tipo de PQRSF");
                        System.out.println("----------------------------------");
                        System.out.println("Peticiones");
                        System.out.println("Quejas");
                        System.out.println("Reclamos");
                        System.out.println("Sugerencias");
                        System.out.println("Felicitaciones");
                        System.out.println("----------------------------------");
                        tipoPQRSF = scanner.nextLine();

                        System.out.println("Descripción de la PQRSF:");
                        descripcionPQRSF = scanner.nextLine();

                        listaEntradas.add("Nombre: " + nombre +
                                "\nUsuario: " + usuario +
                                "\nCorreo: " + correo +
                                "\nTeléfono: " + telefono +
                                "\nTipo de PQRSF: " + tipoPQRSF +
                                "\nDescripción de la PQRSF: " + descripcionPQRSF);

                        System.out.println("Ingrese 'salir' para terminar o presione Enter para continuar.");
                        salida = scanner.nextLine();

                        if (salida.equalsIgnoreCase("salir")) {
                            break;
                        }
                    }

                    System.out.println("\nEntradas guardadas:");
                    for (String texto : listaEntradas) {
                        System.out.println(texto);
                    }
                    break;

                case 2:
                    System.out.println("No es posible continuar con la PQRSF.");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
