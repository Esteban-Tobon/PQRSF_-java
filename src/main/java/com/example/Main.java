package com.example;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static final String USER = "user";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        
    }

    public static void Admin() {

        Scanner tareas = new Scanner(System.in);
        boolean accesoCorrecto = false;
        int maximoIntentos = 3;

        // sevalida usuario y contraseña correcto
        while (!accesoCorrecto) {
            System.out.println("Por favor, inicie sesión");

            for (int intento = 1; intento <= maximoIntentos; intento++) {
                System.out.println("Ingrese su Usuario");
                String userName = tareas.nextLine();
                System.out.println("Ingrese contraseña");
                String passwordTry = tareas.nextLine();

                if (USER.equals(userName) && PASSWORD.equals(passwordTry)) {
                    System.out.println("Acceso correcto");
                    accesoCorrecto = true;
                    break; // Salimos del for y permitimos acceder al do-while
                } else if (intento == maximoIntentos) {
                    System.out.println("Número máximo de intentos alcanzado. Acceso bloqueado.");
                    return; // Termina el método si los intentos se han agotado
                } else {
                    System.out.println("Usuario o contraseña incorrectos. Tiene " + (maximoIntentos - intento)
                            + " intentos adicionales");
                }

            }

            do {
                System.out.println("\nElija su tarea");
                System.out.println("1. Validar PQRSF");
                System.out.println("2. Responder QRSF");
                System.out.println("3. Salir");
                int tarea = tareas.nextInt();
                tareas.nextLine();

                if (tarea == 1) {
                    System.out.println("Hay PQRSF en su bandeja");

                } else if (tarea == 2) {
                    System.out.println("\nSelecione que desea responder");
                    System.out.println("1. Peticiones");
                    System.out.println("2. Quejas");
                    System.out.println("3. Reclamos");
                    System.out.println("4. Sugerencias");
                    System.out.println("5. Felicitaciones");
                    System.out.println("6. Volver");

                    int responder = tareas.nextInt();
                    tareas.nextLine();
                } else if (tarea == 3) {
                    System.out.println("Saliendo del sistema");
                    break;
                } else {
                    System.out.println("Ingrese una opcion valida. ");
                }
            } while (true);

            tareas.close();
        }
    }

    public static void Anonimo() {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> listaEntradas = new ArrayList<>();

        String telefono;
        String correo;
        String salida;
        String tipoPQRSF;
        String descripcionPQRSF;
        int terminos;
        boolean opcionValida = false;

        while (!opcionValida) {

            System.out.println("\nAcepta el manejo de la politica de datos?");
            System.out.println("1.Si");
            System.out.println("2.No");
            terminos = scanner.nextInt();

            scanner.nextLine();

            switch (terminos) {
                case 1:
                    opcionValida = true;
                    while (true) {
                        System.out.print("Ingrese su correo: ");
                        correo = scanner.nextLine();

                        System.out.print("Ingrese su telefono: ");
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

                        System.out.println("Descripcion de la PQRSF");
                        descripcionPQRSF = scanner.nextLine();

                        listaEntradas
                                .add("correo: " + correo + " \ntelefono: " + telefono + " \nTipo de PQRSF: " + tipoPQRSF
                                        + " \nDescripcion de la PQRSF: " + descripcionPQRSF);

                        System.out.println("Ingrese salir para terminar");
                        salida = scanner.nextLine();

                        if (salida.equalsIgnoreCase("salir")) {
                            break;
                        }

                    }

                    scanner.close();

                    System.out.println("Entradas guardadas:");
                    for (String texto : listaEntradas) {
                        System.out.println(texto);
                    }
                    break;

                case 2:
                    System.out.println("no es posible continuar con la PQRSF");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
}