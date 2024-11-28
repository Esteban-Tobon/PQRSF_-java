package com.example;

// Importación de clases necesarias
import java.util.ArrayList;
import java.util.Scanner;

// Clase principal que contiene toda la lógica del sistema
public class Main {
    static ArrayList<String> peticionesDetalles = new ArrayList<>();
    static ArrayList<String> quejasDetalles = new ArrayList<>();
    static ArrayList<String> reclamosDetalles = new ArrayList<>();
    static ArrayList<String> sugerenciasDetalles = new ArrayList<>();
    static ArrayList<String> felicitacionesDetalles = new ArrayList<>();
    static ArrayList<String> usuarioAnonimo = new ArrayList<>();
    static ArrayList<String> usuarioOtros = new ArrayList<>();

    // Método principal que inicia el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// Escáner para leer entradas del usuario
        mostrarMenu(scanner);
        scanner.close();// Cierra el escáner
    }

    // Método que muestra el menú principal
    static void mostrarMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nSeleccione la sede a la cual desea realizar su PQRSF");
            System.out.println("--------------------------------");
            System.out.println("1. Sede Bello");
            System.out.println("2. Otras Sedes");
            System.out.println("3. Salir");
            System.out.println("--------------------------------");

            int eleccion = obtenerOpcion(scanner, 3); // Método que valida la opción seleccionada

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
    // Método para seleccionar el tipo de usuario
    static void seleccionarTipoUsuario(Scanner scanner) {
        System.out.println("\nSeleccione tipo de usuario");
        System.out.println("--------------------------------");
        System.out.println("1. Anónimo");
        System.out.println("2. Otros");
        System.out.println("3. Administrador");
        System.out.println("4. Volver a la selección de sede");
        System.out.println("--------------------------------");

        int usuarioSeleccionado = obtenerOpcion(scanner, 4); // Validar opción seleccionada

        switch (usuarioSeleccionado) {
            case 1 -> procesarUsuario(scanner, "Anónimo");
            case 2 -> procesarUsuario(scanner, "Otros");
            case 3 -> admin(scanner);
        }
    }

    // Método que procesa un usuario y su PQRSF
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

    // Método que solicita aceptar la política de manejo de datos
    static boolean aceptarPoliticaDatos(Scanner scanner) {
        System.out.println("\n¿Acepta la política de manejo de datos?");
        System.out.println("1. Sí");
        System.out.println("2. No");

        int opcion = obtenerOpcion(scanner, 2);

        if (opcion == 2) {
            System.out.println("No es posible continuar.");
            return false;// Si no acepta, se detiene el proceso
        }
        return true;
    }

    // Método para seleccionar el tipo de PQRSF
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

        // Retorna los detalles de la PQRSF según la opción seleccionada
        return switch (opcion) {
            case 1 -> registrarDetalle(scanner, peticionesDetalles, "petición");
            case 2 -> registrarDetalle(scanner, quejasDetalles, "queja");
            case 3 -> registrarDetalle(scanner, reclamosDetalles, "reclamo");
            case 4 -> registrarDetalle(scanner, sugerenciasDetalles, "sugerencia");
            case 5 -> registrarDetalle(scanner, felicitacionesDetalles, "felicitación");
            default -> "";
        };
    }

    // Método para registrar detalles de una PQRSF
    static String registrarDetalle(Scanner scanner, ArrayList<String> lista, String tipo) {
        System.out.println("Por favor ingrese los detalles de su " + tipo + ":");
        String detalle = scanner.nextLine();// Leer los detalles ingresados
        lista.add(detalle); // Agregar los detalles a la lista correspondiente
        return detalle;// Retornar los detalles
    }

    // Método para agregar un usuario anónimo con correo, teléfono y detalles.
    static void agregarUsuarioAnonimo(Scanner scanner, String detalles) {
        String correo = solicitarDato(scanner, "Correo: ", Main::validarCorreo);
        String telefono = solicitarDato(scanner, "Teléfono: ", Main::validarTelefono);

        // Agrega la información del usuario anónimo a la lista
        usuarioAnonimo.add("Correo: " + correo + "\nTeléfono: " + telefono + "\nDetalles: " + detalles);
        // Muestra la información ingresada
        mostrarInformacion("Anónimo", correo, telefono, detalles);
    }

    // Método para agregar un usuario identificado (estudiante, egresado, docente, viditante u otros.)
    static void agregarUsuarioIdentificado(Scanner scanner, String detalles) {
        System.out.println("\nPor favor seleccione su tipo de usuario:");
        System.out.println("--------------------------------");
        System.out.println("1. Estudiante");
        System.out.println("2. Egresado");
        System.out.println("3. Docente");
        System.out.println("4. Visitantes u Otros");
        System.out.println("--------------------------------");

        int opcion = obtenerOpcion(scanner, 4);

        // Asocia la opción seleccionada con el tipo de usuario
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

        // Agrega la información del usuario identificado a la lista
        usuarioOtros.add("Usuario: " + tipoUsuario + "\nNombre: " + nombre + "\nCorreo: " + correo +
                "\nTeléfono: " + telefono + "\nDetalles: " + detalles);
        // Muestra la información ingresada
        mostrarInformacion(tipoUsuario, correo, telefono, detalles);
    }

    
    static void mostrarInformacion(String tipoUsuario, String correo, String telefono, String detalles) {
        System.out.println("\nInformación ingresada:");
        System.out.println("Tipo de Usuario: " + tipoUsuario);
        System.out.println("Correo: " + correo);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Detalles: " + detalles);
    }

    // Menú de administración para gestionar PQRSF y usuarios
    static void admin(Scanner scanner) {
        String user = "User";// Usuario de administrador
        String password = "123456";// Contraseña de administrador
        boolean accesoCorrecto = false;// Control de acceso
        int maximoIntentos = 3;// Máximo de intentos para iniciar sesión

        // Ciclo para validar las credenciales de administrador
        while (!accesoCorrecto) {
            System.out.println("Por favor, inicie sesión");
             // Intenta validar las credenciales con un máximo de intentos
            for (int intento = 1; intento <= maximoIntentos; intento++) {
                System.out.print("Ingrese su Usuario: ");
                String userName = scanner.nextLine();
                System.out.print("Ingrese contraseña: ");
                String passwordTry = scanner.nextLine();

                // Valida las credenciales
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

        boolean salir = false;// Control para salir del menú

        // Ciclo del menú de administrador
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

            // Solicita la opción seleccionada y valida entrada
            System.out.print("Seleccione una opción: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Ingrese un número entre 1 y 8.");
                scanner.nextLine(); // Limpiar buffer
                continue;
            }

            // Procesa la opción seleccionada
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

    // Método para mostrar todas las PQRSF agrupadas por tipo
    static void mostrarTodasLasPQRSF() {
        System.out.println("\n--- Todas las PQRSF ---");
        mostrarLista("Peticiones", peticionesDetalles);
        mostrarLista("Quejas", quejasDetalles);
        mostrarLista("Reclamos", reclamosDetalles);
        mostrarLista("Sugerencias", sugerenciasDetalles);
        mostrarLista("Felicitaciones", felicitacionesDetalles);
    }

    // Método para mostrar PQRSF según el tipo seleccionado por el usuario
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

        // Selecciona el tipo de PQRSF a mostrar basado en la opción ingresada
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

    // Método para mostrar información de usuarios anónimos
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

    // Método para mostrar información de usuarios identificados
    static void mostrarUsuariosIdentificados() {
        System.out.println("\n--- Usuarios Identificados ---");
        if (usuarioOtros.isEmpty()) {// Verifica si la lista está vacía
            System.out.println("No hay usuarios identificados registrados.");
        } else {
            // Itera sobre la lista y muestra la información de cada usuario
            for (String usuario : usuarioOtros) {
                System.out.println("--------------------------------");
                System.out.println(usuario);
                System.out.println("--------------------------------");
            }
        }
    }

    // Método genérico para mostrar una lista de PQRSF por tipo
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

    // Método para eliminar todas las PQRSF y usuarios registrados
    static void eliminarTodasPQRSF() {
        // Limpia todas las listas de PQRSF y usuarios
        peticionesDetalles.clear();
        quejasDetalles.clear();
        reclamosDetalles.clear();
        sugerenciasDetalles.clear();
        felicitacionesDetalles.clear();
        usuarioAnonimo.clear();
        usuarioOtros.clear();
        System.out.println("\nTodas las PQRSF y usuarios han sido eliminados.");
    }

    // Método para eliminar una PQRSF específica de usuarios anónimos
    static void eliminarPQRSFPorIndiceAnonimo(Scanner scanner) {
        eliminarPorIndice(scanner, usuarioAnonimo, "Usuarios Anónimos");
    }

    // Método para eliminar una PQRSF específica de usuarios identificados
    static void eliminarPQRSFPorIndiceOtros(Scanner scanner) {
        eliminarPorIndice(scanner, usuarioOtros, "Usuarios Identificados");
    }

    // Método genérico para eliminar una PQRSF por su índice en una lista
    static void eliminarPorIndice(Scanner scanner, ArrayList<String> lista, String tipoUsuario) {
        
        if (lista.isEmpty()) {
            System.out.println("\nNo hay PQRSF en " + tipoUsuario + ".");
            return;
        }
        

        System.out.println("\n--- PQRSF de " + tipoUsuario + " ---");
        // Muestra todas las PQRSF con índices
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("--------------------------------");
            System.out.println((i + 1) + ". " + lista.get(i));
            System.out.println("--------------------------------");
        }


        System.out.print("\nIngrese el índice de la PQRSF a eliminar: ");
        if (!scanner.hasNextInt()) {// Verifica si la entrada no es un número
            System.out.println("Entrada inválida. Debe ingresar un número.");
            scanner.nextLine(); // Limpiar buffer
            return;
        }

        int indice = scanner.nextInt() - 1;// Ajusta el índice a base 0
        scanner.nextLine(); // Limpiar buffer

        if (indice >= 0 && indice < lista.size()) { // Verifica que el índice sea válido
            lista.remove(indice);// Elimina el elemento de la lista
            System.out.println("PQRSF eliminada exitosamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para obtener una opción válida dentro de un rango determinado
    static int obtenerOpcion(Scanner scanner, int maxOpciones) {
        int opcion;
        do {
            System.out.print("Seleccione una opción: ");
            while (!scanner.hasNextInt()) { // Verifica si la entrada no es un número entero
                System.out.println("Ingrese un número válido.");
                scanner.next(); // Descartar la entrada inválida
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

    // Método para validar un correo electrónico
    static void validarCorreo(String correo) {
        // Verificar si el correo contiene el carácter '@'
        if (!correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener '@'.");// Lanza una excepción si no es válido
        }
    }

    // Método para validar un número de teléfono
    static void validarTelefono(String telefono) {
         // Verificar que el teléfono solo contenga dígitos
        if (!telefono.matches("\\d+")) {
            throw new IllegalArgumentException("El teléfono debe ser numérico.");// Lanza una excepción si no es válido
        }
         // Verificar que el teléfono tenga al menos 10 dígitos
        if (telefono.length() < 10) {
            throw new IllegalArgumentException("El teléfono debe tener al menos 10 dígitos."); // Lanza una excepción si no es válido
        }
    }

    // Interfaz funcional que define un validador para entradas personalizadas
    interface Validador {
        void validar(String input);// Método que valida una entrada
    }
}