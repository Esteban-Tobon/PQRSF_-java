package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> peticionesDetalles = new ArrayList<>();
    static ArrayList<String> quejasDetalles = new ArrayList<>();
    static ArrayList<String> reclamosDetalles = new ArrayList<>();
    static ArrayList<String> sugerenciasDetalles = new ArrayList<>();
    static ArrayList<String> felicitacionesDetalles = new ArrayList<>();
    static ArrayList<String> usuarioAnonimo = new ArrayList<>();
    static ArrayList<String> usuarioOtros = new ArrayList<>();

    public static void main(String[] args) {
        seleccionSede();

        // Inicializar las listas de PQRSF con datos

    }

    static void seleccionSede() {
        Scanner sede = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nSeleccione la sede a la cual desea realizar su PQRSF");
            System.out.println("1. Sede Bello");
            System.out.println("2. Otras Sedes");
            System.out.println("3. Salir");

            int eleccion = sede.nextInt();
            sede.nextLine();

            switch (eleccion) {
                case 1:
                    System.out.println("\nSeleccione tipo de usuario");
                    System.out.println("1. Anónimo");
                    System.out.println("2. Otros");
                    System.out.println("3. Administrador");
                    System.out.println("4. Volver a la selección de sede");

                    int usuarioSeleccionado = sede.nextInt();
                    sede.nextLine();

                    switch (usuarioSeleccionado) {
                        case 1:
                            usuarioAnonimo();
                            selecionDePQRSF();
                            break;

                        case 2:
                            usuarioOtros();
                            selecionDePQRSF();
                            break;

                        case 3:
                            admin();
                            break;

                        case 4:
                            seleccionSede();
                            break;

                        default:
                            System.out.println("Ingrese una opción válida.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println(
                            "usted debe dirigirse  ala web https://forms.office.com/Pages/ResponsePage.aspx?id=ZB3r34MsSkO_IcZpbVMi7DSiM9OjpPJDuahWiTvzBQpUMktRWlU2Vk83MUo4QVJNWEFSMkhFT1ZHNiQlQCN0PWcu");
                    salir = true;
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                    break;

                default:
                    System.out.println("Seleccione una opción válida.");
                    break;
            }
        }
    }

    static void admin() {
        String user = "User";
        String password = "123456";
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

                if (user.equals(userName) && password.equals(passwordTry)) {
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

                switch (tarea) {
                    case 1:
                        // Aquí llamas a la función de validación pasando las listas correctas
                        System.out.println("Peticiones: " + peticionesDetalles.size());
                        System.out.println("Quejas: " + quejasDetalles.size());
                        System.out.println("Reclamos: " + reclamosDetalles.size());
                        System.out.println("Sugerencias: " + sugerenciasDetalles.size());
                        System.out.println("Felicitaciones: " + felicitacionesDetalles.size());
                        break;
                    case 2:
                        System.out.println("\nSelecione que desea responder");
                        System.out.println("1. Peticiones");
                        System.out.println("2. Quejas");
                        System.out.println("3. Reclamos");
                        System.out.println("4. Sugerencias");
                        System.out.println("5. Felicitaciones");
                        System.out.println("6. Volver");

                        int seleccion = tareas.nextInt();

                        switch (seleccion) {
                            case 1:
                                System.out.println("\nContenido de Usuarios Anónimos:");
                                for (String anonimo : usuarioAnonimo) {
                                    System.out.println("- " + anonimo);
                                }

                                System.out.println("Contenido de Peticiones:");
                                for (String peticion : peticionesDetalles) {
                                    System.out.println("- " + peticion);
                                }

                                break;
                            case 2:
                                System.out.println("\nContenido de Usuarios Anónimos:");
                                for (String anonimo : usuarioAnonimo) {
                                    System.out.println("- " + anonimo);
                                }

                                System.out.println("\nContenido de Quejas:");
                                for (String queja : quejasDetalles) {
                                    System.out.println("- " + queja);
                                }

                                break;
                            case 3:
                                System.out.println("\nContenido de Usuarios Anónimos:");
                                for (String anonimo : usuarioAnonimo) {
                                    System.out.println("- " + anonimo);
                                }

                                System.out.println("\nContenido de Otros Usuarios:");
                                for (String otroUsuario : usuarioOtros) {
                                    System.out.println("- " + otroUsuario);
                                }

                                System.out.println("\nContenido de Reclamos:");
                                for (String reclamo : reclamosDetalles) {
                                    System.out.println("- " + reclamo);
                                }

                                break;
                            case 4:
                                System.out.println("\nContenido de Usuarios Anónimos:");
                                for (String anonimo : usuarioAnonimo) {
                                    System.out.println("- " + anonimo);
                                }

                                System.out.println("\nContenido de Otros Usuarios:");
                                for (String otroUsuario : usuarioOtros) {
                                    System.out.println("- " + otroUsuario);
                                }

                                System.out.println("\nContenido de Sugerencias:");
                                for (String sugerencia : sugerenciasDetalles) {
                                    System.out.println("- " + sugerencia);
                                }

                                break;
                            case 5:
                                System.out.println("\nContenido de Usuarios Anónimos:");
                                for (String anonimo : usuarioAnonimo) {
                                    System.out.println("- " + anonimo);
                                }

                                System.out.println("\nContenido de Otros Usuarios:");
                                for (String otroUsuario : usuarioOtros) {
                                    System.out.println("- " + otroUsuario);
                                }

                                System.out.println("\nContenido de Felicitaciones:");
                                for (String felicitacion : felicitacionesDetalles) {
                                    System.out.println("- " + felicitacion);
                                }

                                break;

                            case 6:
                                break; // Volver al menú anterior
                            default:
                                System.out.println("Ingrese una opcion valida. ");
                                break;
                        }
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema");
                        seleccionSede();
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida. ");
                        break;
                }

            } while (true);
        }
    }

    //////////////////////////////////////////////////////////////////////////

    // Inicio de la creacion de los metodos de usuarios

    static void usuarioAnonimo() {

        // Creamos un Arraylist para elingreso de datos del usuario
        ArrayList<String> datosAnonimo = new ArrayList<>();

        Scanner scanner = new Scanner(System.in); // se crea el escanar para tomar los datos deingreso

        // Se solicita dos metodo de contacto
        System.out.println("\n Porfavor ingrese  metodos de contacto:");

        String correo;
        while (true) {
            System.out.print("Correo: ");
            correo = scanner.nextLine(); // se toman datos ingresados
            try {
                validarEmail(correo);
                System.out.println("El correo electrónico es válido.");
                break; // Salir del bucle si el correo es válido
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + ". Inténtalo nuevamente.");
            }
        }

        // se agrega el correo a la lista una vez validado
        usuarioAnonimo.add(correo);

        // se solicita el ingreso de un numero de telefono valido que se verfica con el
        // metodo validar numero
        String telefono;

        while (true) {
            System.out.println("Teléfono: ");
            telefono = scanner.nextLine();
            try {
                validarNumero(telefono);
                System.out.println("El número ingresado es válido.");
                break; // Salir del bucle si el número es válido
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + ". Inténtalo nuevamente.");
            }
        }
        usuarioAnonimo.add(telefono);

    }

    static void usuarioOtros() {

        // Creamos un Arraylist para elingreso de datos del usuario
        ArrayList<String> datosOtros = new ArrayList<>();

        Scanner scanner = new Scanner(System.in); // se crea el escanar para tomar los datos deingreso

        System.out.println("\nPor favor selecione su tipo de usuario");
        System.out.println("1. Estudiante ");
        System.out.println("2. Egresado ");
        System.out.println("3. Docente");
        System.out.println("4. Visitantes u Otros ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1, 2, 3, 4:
                System.out.println("Ingrese su nombre completo por favor: ");
                String nombre = scanner.nextLine();
                datosOtros.add(nombre);
                break;

            default:
                System.out.println("Por favor seleccione una opción valida. ");
                break;
        }

        // Se solicita dos metodo de contacto
        System.out.println("\n Porfavor ingrese  metodos de contacto:");

        String correo;
        while (true) {
            System.out.print("Correo: ");
            correo = scanner.nextLine(); // se toman datos ingresados
            try {
                validarEmail(correo);
                System.out.println("El correo electrónico es válido.");
                break; // Salir del bucle si el correo es válido
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + ". Inténtalo nuevamente.");
            }
        }

        // se agrega el correo a la lista una vez validado
        usuarioOtros.add(correo);

        // se solicita el ingreso de un numero de telefono valido que se verfica con el
        // metodo validar numero
        String telefono;

        while (true) {
            System.out.println("Teléfono: ");
            telefono = scanner.nextLine();
            try {
                validarNumero(telefono);
                System.out.println("El número ingresado es válido.");
                break; // Salir del bucle si el número es válido
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + ". Inténtalo nuevamente.");
            }
        }
        usuarioOtros.add(telefono);

    }

    ////////////////////////////////////////////////////////////////////

    // metodos de validacionde correo y numeros ingresados

    /*
     * throw es una instrucción que lanza una excepción, interrumpiendo el flujo
     * normal del programa en ese punto.
     * new IllegalArgumentException(...) crea una nueva instancia de la clase
     * IllegalArgumentException, una excepción que indica que un argumento
     * proporcionado a un método es inválido.
     */

    static void validarEmail(String correo) {
        if (!correo.contains("@")) {
            throw new IllegalArgumentException("El correo electrónico debe contener '@'.");
        }
    }

    /*
     * throw es una instrucción que lanza una excepción, interrumpiendo el flujo
     * normal del programa en ese punto.
     * new IllegalArgumentException(...) crea una nueva instancia de la clase
     * IllegalArgumentException, una excepción que indica que un argumento
     * proporcionado a un método es inválido.
     * El mensaje "El String debe contener al menos 10 dígitos." se incluye como
     * argumento del constructor. Este mensaje se usa para describir el error, de
     * modo que, si se lanza la excepción, el programa mostrará este mensaje de
     * error.
     */
    static void validarNumero(String telefono) {
        // Verificar si el String contiene solo dígitos y tiene al menos 10 caracteres
        if (!telefono.matches("\\d+")) {
            throw new IllegalArgumentException("El telefono contiene letras o caracteres no numéricos.");
        }
        if (telefono.length() < 10) {
            throw new IllegalArgumentException("El telefono debe contener al menos 10 dígitos.");
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    // metodo de seleccion de PQRSF
    static void selecionDePQRSF() {
        Scanner scanner = new Scanner(System.in);

        // se cre elmenu con las diferentes opciones

        System.out.println("\nSeleccione el tipo de PQRSF");
        System.out.println("----------------------------------");
        System.out.println("1. Peticiones ");
        System.out.println("2. Quejas ");
        System.out.println("3. Reclamos");
        System.out.println("4. Sugerencias");
        System.out.println("5. Felicitaciones");
        System.out.println("----------------------------------");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // para limpiar el ingreso del scanner

        // secrea un switch que contiene cada uno de los metodos dependiendo la opcion
        // se llama al metodo correspondiente

        switch (opcion) {
            case 1:
                peticiones();
                break;

            case 2:
                quejas();
                break;

            case 3:
                reclamos();
                break;

            case 4:
                sugerencias();
                break;

            case 5:
                felicitaciones();
                break;

            default:
                System.out.println("Ingrese  una opcion valida. ");
                break;
        }
        scanner.close();

    }

    /////////////////////////////////////////////////////////////////////////////
    // secrea cada uno de los metodos co su respectivo arrayslist

    static void peticiones() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar detalles para la petición y almacenarlos en la lista estática
        System.out.println("Por favor ingrese los detalles de su petición: ");
        String detalles = scanner.nextLine();

        peticionesDetalles.add(detalles); // Agregar directamente a la lista estática

        cierre(); // método de cierre
    }

    static void quejas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese los detalles de su queja: ");
        String detalles = scanner.nextLine();

        quejasDetalles.add(detalles); // Agregar directamente a la lista estática

        cierre(); // método de cierre
    }

    static void reclamos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese los detalles de su reclamo: ");
        String detalles = scanner.nextLine();

        reclamosDetalles.add(detalles); // Agregar directamente a la lista estática

        cierre(); // método de cierre
    }

    static void sugerencias() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese los detalles de su sugerencia: ");
        String detalles = scanner.nextLine();

        sugerenciasDetalles.add(detalles); // Agregar directamente a la lista estática

        cierre(); // método de cierre
    }

    static void felicitaciones() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese los detalles de su felicitación: ");
        String detalles = scanner.nextLine();

        felicitacionesDetalles.add(detalles); // Agregar directamente a la lista estática

        cierre(); // método de cierre
    }

    // fin de los metodos correspondientes a PQRSF
    ///////////////////////////////////////////////////////////////

    // Secre un metodo cierre que finaliza o da la opcion de continuar con otra
    // PQRSF

    static void cierre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n¿Desea ingresar otra PQRSF?");
        System.out.println("1. Si ");
        System.out.println("2. No ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                seleccionSede();
                break;

            case 2:

                System.out.println(
                        "Gracias por  suministra la informacion  necesaria para atender  su inquietus sera notificado  tanpronto como sea posible  a los metodos de contacto suministrados. ");

                break;
            default:
                System.out.println("Ingrese  una opcion valida. ");
                break;
        }
        scanner.close();

    }

    ///////////////////////////////////////////////////////////////////////////
    // Incio de metods de tareas del Administrador
    // Método para validar PQRSF y mostrar los tamaños de las listas.
    static void validarPQRSF(ArrayList<String> peticiones, ArrayList<String> quejas,
            ArrayList<String> reclamos, ArrayList<String> sugerencias,
            ArrayList<String> felicitaciones) {

        // Muestra el tamaño de las listas sin pedir más detalles.
        System.out.println("Peticiones: " + peticiones.size() + " elementos.");
        System.out.println("Quejas: " + quejas.size() + " elementos.");
        System.out.println("Reclamos: " + reclamos.size() + " elementos.");
        System.out.println("Sugerencias: " + sugerencias.size() + " elementos.");
        System.out.println("Felicitaciones: " + felicitaciones.size() + " elementos.");
    }

}
