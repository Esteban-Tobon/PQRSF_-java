package com.example;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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