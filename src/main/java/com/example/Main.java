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
        Scanner scanner = new Scanner(System.in);
        mostrarMenu(scanner);
        scanner.close();
    }

    static void mostrarMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nSeleccione la sede a la cual desea realizar su PQRSF");
            System.out.println("--------------------------------");
            System.out.println("1. Sede Bello");
            System.out.println("2. Otras Sedes");
            System.out.println("3. Salir");
            System.out.println("--------------------------------");

            int eleccion = obtenerOpcion(scanner, 3);

            switch (eleccion) {
                case 1 -> seleccionarTipoUsuario(scanner);
                case 2 -> System.out.println("Usted debe dirigirse a la web: https://forms.office.com/Pages/ResponsePage.aspx?id=ZB3r34MsSkO_IcZpbVMi7DSiM9OjpPJDuahWiTvzBQpUMktRWlU2Vk83MUo4QVJNWEFSMkhFT1ZHNiQlQCN0PWcu");
                case 3 -> {
                    System.out.println("Saliendo del sistema...");
                    return;
                }
            }
        }
    }

    static void seleccionarTipoUsuario(Scanner scanner) {
        System.out.println("\nSeleccione tipo de usuario");
        System.out.println("--------------------------------");
        System.out.println("1. Anónimo");
        System.out.println("2. Otros");
        System.out.println("3. Administrador");
        System.out.println("4. Volver a la selección de sede");
        System.out.println("--------------------------------");

        int usuarioSeleccionado = obtenerOpcion(scanner, 4);

        switch (usuarioSeleccionado) {
            case 1 -> procesarUsuario(scanner, "Anónimo");
            case 2 -> procesarUsuario(scanner, "Otros");
            case 3 -> admin(scanner);
        }
    }

    static void procesarUsuario(Scanner scanner, String tipoUsuario) {
        if (!aceptarPoliticaDatos(scanner))
            return;

        String detalles = seleccionarTipoPQRSF(scanner);
        if (tipoUsuario.equals("Anónimo")) {
            agregarUsuarioAnonimo(scanner, detalles);
        } else {
            agregarUsuarioIdentificado(scanner, detalles);
        }
    }

    static boolean aceptarPoliticaDatos(Scanner scanner) {
        System.out.println("\n¿Acepta la política de manejo de datos?");
        System.out.println("1. Sí");
        System.out.println("2. No");

        int opcion = obtenerOpcion(scanner, 2);

        if (opcion == 2) {
            System.out.println("No es posible continuar.");
            return false;
        }
        return true;
    }

    static String seleccionarTipoPQRSF(Scanner scanner) {
        System.out.println("\nSeleccione el tipo de PQRSF");
        System.out.println("--------------------------------");
        System.out.println("1. Peticiones");
        System.out.println("2. Quejas");
        System.out.println("3. Reclamos");
        System.out.println("4. Sugerencias");
        System.out.println("5. Felicitaciones");
        System.out.println("--------------------------------");

        int opcion = obtenerOpcion(scanner, 5);

        return switch (opcion) {
            case 1 -> registrarDetalle(scanner, peticionesDetalles, "petición");
            case 2 -> registrarDetalle(scanner, quejasDetalles, "queja");
            case 3 -> registrarDetalle(scanner, reclamosDetalles, "reclamo");
            case 4 -> registrarDetalle(scanner, sugerenciasDetalles, "sugerencia");
            case 5 -> registrarDetalle(scanner, felicitacionesDetalles, "felicitación");
            default -> "";
        };
    }

    static String registrarDetalle(Scanner scanner, ArrayList<String> lista, String tipo) {
        System.out.println("Por favor ingrese los detalles de su " + tipo + ":");
        String detalle = scanner.nextLine();
        lista.add(detalle);
        return detalle;
    }

    static void agregarUsuarioAnonimo(Scanner scanner, String detalles) {
        String correo = solicitarDato(scanner, "Correo: ", Main::validarCorreo);
        String telefono = solicitarDato(scanner, "Teléfono: ", Main::validarTelefono);

        usuarioAnonimo.add("Correo: " + correo + "\nTeléfono: " + telefono + "\nDetalles: " + detalles);
        mostrarInformacion("Anónimo", correo, telefono, detalles);
    }

    static void agregarUsuarioIdentificado(Scanner scanner, String detalles) {
        System.out.println("\nPor favor seleccione su tipo de usuario:");
        System.out.println("--------------------------------");
        System.out.println("1. Estudiante");
        System.out.println("2. Egresado");
        System.out.println("3. Docente");
        System.out.println("4. Visitantes u Otros");
        System.out.println("--------------------------------");

        int opcion = obtenerOpcion(scanner, 4);
        String tipoUsuario = switch (opcion) {
            case 1 -> "Estudiante";
            case 2 -> "Egresado";
            case 3 -> "Docente";
            case 4 -> "Visitantes u Otros";
            default -> "";
        };

        System.out.println("Ingrese su nombre completo:");
        String nombre = scanner.nextLine();
        String correo = solicitarDato(scanner, "Correo: ", Main::validarCorreo);
        String telefono = solicitarDato(scanner, "Teléfono: ", Main::validarTelefono);

        usuarioOtros.add("Usuario: " + tipoUsuario + "\nNombre: " + nombre + "\nCorreo: " + correo +
                "\nTeléfono: " + telefono + "\nDetalles: " + detalles);
        mostrarInformacion(tipoUsuario, correo, telefono, detalles);
    }

    static void mostrarInformacion(String tipoUsuario, String correo, String telefono, String detalles) {
        System.out.println("\nInformación ingresada:");
        System.out.println("Tipo de Usuario: " + tipoUsuario);
        System.out.println("Correo: " + correo);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Detalles: " + detalles);
    }

    static void admin(Scanner scanner) {
        String user = "User";
        String password = "123456";
        boolean accesoCorrecto = false;
        int maximoIntentos = 3;

        // Validar usuario y contraseña
        while (!accesoCorrecto) {
            System.out.println("Por favor, inicie sesión");

            for (int intento = 1; intento <= maximoIntentos; intento++) {
                System.out.print("Ingrese su Usuario: ");
                String userName = scanner.nextLine();
                System.out.print("Ingrese contraseña: ");
                String passwordTry = scanner.nextLine();

                if (user.equals(userName) && password.equals(passwordTry)) {
                    System.out.println("Acceso correcto");
                    accesoCorrecto = true;
                    break;
                } else if (intento == maximoIntentos) {
                    System.out.println("Número máximo de intentos alcanzado. Acceso bloqueado.");
                    return;
                } else {
                    System.out.println("Usuario o contraseña incorrectos. Tiene " + (maximoIntentos - intento)
                            + " intentos adicionales");
                }
            }
        }

        boolean salir = false;

        while (!salir) {
            System.out.println("\n---- Menú de Administrador ----");
            System.out.println("1. Ver todas las PQRSF");
            System.out.println("2. Ver PQRSF por tipo");
            System.out.println("3. Ver usuarios anónimos");
            System.out.println("4. Ver usuarios identificados");
            System.out.println("5. Eliminar una PQRSF por índice (Anónimos)");
            System.out.println("6. Eliminar una PQRSF por índice (Identificados)");
            System.out.println("7. Eliminar todas las PQRSF");
            System.out.println("8. Salir");
            System.out.println("----------------------------------");

            System.out.print("Seleccione una opción: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Ingrese un número entre 1 y 8.");
                scanner.nextLine(); // Limpiar buffer
                continue;
            }

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    mostrarTodasLasPQRSF();
                    break;
                case 2:
                    mostrarPQRSFPorTipo(scanner);
                    break;
                case 3:
                    mostrarUsuariosAnonimos();
                    break;
                case 4:
                    mostrarUsuariosIdentificados();
                    break;
                case 5:
                    eliminarPQRSFPorIndiceAnonimo(scanner);
                    break;
                case 6:
                    eliminarPQRSFPorIndiceOtros(scanner);
                    break;
                case 7:
                    eliminarTodasPQRSF();
                    break;
                case 8:
                    System.out.println("Saliendo del menú de administrador...");
                    salir = true;
                    break;
                default:
                    System.out.println("Seleccione una opción válida.");
            }
        }
    }

    static void mostrarTodasLasPQRSF() {
        System.out.println("\n--- Todas las PQRSF ---");
        mostrarLista("Peticiones", peticionesDetalles);
        mostrarLista("Quejas", quejasDetalles);
        mostrarLista("Reclamos", reclamosDetalles);
        mostrarLista("Sugerencias", sugerenciasDetalles);
        mostrarLista("Felicitaciones", felicitacionesDetalles);
    }

    static void mostrarPQRSFPorTipo(Scanner scanner) {
        System.out.println("\nSeleccione el tipo de PQRSF a visualizar:");
        System.out.println("--------------------------------");
        System.out.println("1. Peticiones");
        System.out.println("2. Quejas");
        System.out.println("3. Reclamos");
        System.out.println("4. Sugerencias");
        System.out.println("5. Felicitaciones");
        System.out.println("--------------------------------");

        System.out.print("Seleccione una opción: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            scanner.nextLine(); // Limpiar buffer
            return;
        }

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                mostrarLista("Peticiones", peticionesDetalles);
                break;
            case 2:
                mostrarLista("Quejas", quejasDetalles);
                break;
            case 3:
                mostrarLista("Reclamos", reclamosDetalles);
                break;
            case 4:
                mostrarLista("Sugerencias", sugerenciasDetalles);
                break;
            case 5:
                mostrarLista("Felicitaciones", felicitacionesDetalles);
                break;
            default:
                System.out.println("Seleccione una opción válida.");
        }
    }

    static void mostrarUsuariosAnonimos() {
        System.out.println("\n--- Usuarios Anónimos ---");
        if (usuarioAnonimo.isEmpty()) {
            System.out.println("No hay usuarios anónimos registrados.");
        } else {
            for (String usuario : usuarioAnonimo) {
                System.out.println("--------------------------------");
                System.out.println(usuario);
                System.out.println("--------------------------------");
            }
        }
    }

    static void mostrarUsuariosIdentificados() {
        System.out.println("\n--- Usuarios Identificados ---");
        if (usuarioOtros.isEmpty()) {
            System.out.println("No hay usuarios identificados registrados.");
        } else {
            for (String usuario : usuarioOtros) {
                System.out.println("--------------------------------");
                System.out.println(usuario);
                System.out.println("--------------------------------");
            }
        }
    }

    static void mostrarLista(String tipo, ArrayList<String> lista) {
        System.out.println("\n--- " + tipo + " ---");
        if (lista.isEmpty()) {
            System.out.println("No hay " + tipo.toLowerCase() + " registradas.");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + ". " + lista.get(i));
            }
        }
    }

    static void eliminarTodasPQRSF() {
        peticionesDetalles.clear();
        quejasDetalles.clear();
        reclamosDetalles.clear();
        sugerenciasDetalles.clear();
        felicitacionesDetalles.clear();
        usuarioAnonimo.clear();
        usuarioOtros.clear();
        System.out.println("\nTodas las PQRSF y usuarios han sido eliminados.");
    }

    static void eliminarPQRSFPorIndiceAnonimo(Scanner scanner) {
        eliminarPorIndice(scanner, usuarioAnonimo, "Usuarios Anónimos");
    }

    static void eliminarPQRSFPorIndiceOtros(Scanner scanner) {
        eliminarPorIndice(scanner, usuarioOtros, "Usuarios Identificados");
    }

    static void eliminarPorIndice(Scanner scanner, ArrayList<String> lista, String tipoUsuario) {
        
        if (lista.isEmpty()) {
            System.out.println("\nNo hay PQRSF en " + tipoUsuario + ".");
            return;
        }
        

        System.out.println("\n--- PQRSF de " + tipoUsuario + " ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("--------------------------------");
            System.out.println((i + 1) + ". " + lista.get(i));
            System.out.println("--------------------------------");
        }

        System.out.print("\nIngrese el índice de la PQRSF a eliminar: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            scanner.nextLine(); // Limpiar buffer
            return;
        }

        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer

        if (indice >= 0 && indice < lista.size()) {
            lista.remove(indice);
            System.out.println("PQRSF eliminada exitosamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    static int obtenerOpcion(Scanner scanner, int maxOpciones) {
        int opcion;
        do {
            System.out.print("Seleccione una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            if (opcion < 1 || opcion > maxOpciones) {
                System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion < 1 || opcion > maxOpciones);
        return opcion;
    }

    static String solicitarDato(Scanner scanner, String mensaje, Validador validador) {
        while (true) { // Ciclo infinito hasta que la validación pase
            System.out.print(mensaje); // Mostrar mensaje al usuario
            String input = scanner.nextLine(); // Leer entrada del usuario
            try {
                validador.validar(input); // Intentar validar el dato ingresado
                return input; // Si no hay excepción, retorna el dato válido
            } catch (IllegalArgumentException e) { 
                System.out.println("Error: " + e.getMessage()); // Si la validación falla, muestra el error y repite el ciclo
            }
        }
    }

    static void validarCorreo(String correo) {
        if (!correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener '@'.");
        }
    }

    static void validarTelefono(String telefono) {
        if (!telefono.matches("\\d+")) {
            throw new IllegalArgumentException("El teléfono debe ser numérico.");
        }
        if (telefono.length() < 10) {
            throw new IllegalArgumentException("El teléfono debe tener al menos 10 dígitos.");
        }
    }

    interface Validador {
        void validar(String input);
    }
}