package com.example;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final String USER = "user";
    static final String PASSWORD = "password";

    public static void main(String[] args) {

        Scanner sede = new Scanner(System.in);
        System.out.println("\nSelecione la  sede a la cual desea realizar su PQRSF");
        System.out.println("1.Sede Bello");
        System.out.println("2. Otras Sedes");

        int eleccion = sede.nextInt();
        sede.nextLine();

        if (eleccion == 1) {
            System.out.println("\nSelecione tipo de usuario");
            System.out.println("1. Anonimo");
            System.out.println("2. Otros");
            System.out.println("3. Administrador");
            System.out.println("4. Salir");
            int usuarioSeleccionado = sede.nextInt();
            sede.nextLine();

            switch (usuarioSeleccionado) {
                case 1:
                    Anonimo();
                    break;
                case 2:
                    Otros();
                    break;
                case 3:
                    Admin();
                    break;

                default:
                    break;
            }

        } else if (eleccion == 2) {
            System.out.println(
                    "usted debe dirigirse  ala web https://forms.office.com/Pages/ResponsePage.aspx?id=ZB3r34MsSkO_IcZpbVMi7DSiM9OjpPJDuahWiTvzBQpUMktRWlU2Vk83MUo4QVJNWEFSMkhFT1ZHNiQlQCN0PWcu");
        } else {
            System.out.println("Seleccione una opcion valida");
        }
        sede.close();

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
                System.out.println("2. Responder PQRSF");
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
        // Creamos una lista de tipo ArrayList
        ArrayList<String> listaEntradas = new ArrayList<>();
        String telefono;
        String correo;
        String salida;
        String tipoPQRSF;
        String descripcionPQRSF;
        int terminos;
        // while (!opcionValida) quiere decir que el bucle while se ejecutará mientras
        // opcionValida sea falso.
        boolean opcionValida = false;
        while (!opcionValida) {
            System.out.println("\nAcepta el manejo de la politica de datos?");
            System.out.println("1.Si");
            System.out.println("2.No");
            terminos = scanner.nextInt();
            scanner.nextLine();
            switch (terminos) {
                case 1:
                    // este opcionValida = true hace que salgamos del while (!opcionValida) ya que
                    // deja de ser falso
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
                        // Agrega elementos a la lista usando el método .add
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
                    System.out.println("Informacion Ingresada:");
                    // Muestra el contenido de la lista
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

                    System.out.println("\nInformacion Ingresada:");

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
