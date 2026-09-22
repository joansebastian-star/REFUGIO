import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Refugio refugio = new Refugio();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarAnimal(sc, refugio);
                    break;
                case 2:
                    refugio.mostrarAnimales();
                    break;
                case 3:
                    buscarAnimal(sc, refugio);
                    break;
                case 4:
                    adoptarAnimal(sc, refugio);
                    break;
                case 5:
                    System.out.println("Cerrando el sistema del refugio. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Debe estar entre 1 y 5.");
            }
            System.out.println();
        } while (opcion != 5);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("=========== REFUGIO ===========");
        System.out.println("1. Registrar animal");
        System.out.println("2. Mostrar animales");
        System.out.println("3. Buscar animal por ID");
        System.out.println("4. Adoptar animal");
        System.out.println("5. Salir");
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        int valor = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(sc.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
        return valor;
    }

    private static void registrarAnimal(Scanner sc, Refugio refugio) {
        int tipo = leerEntero(sc, "Elija el tipo (1 = Perro, 2 = Gato): ");
        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo inválido. Debe ser 1 o 2.");
            return;
        }

        int id = leerEntero(sc, "Ingrese ID: ");

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine().trim();

        int edad = leerEntero(sc, "Ingrese edad: ");

        Animal nuevo;
        if (tipo == 1) {
            System.out.print("Ingrese raza: ");
            String raza = sc.nextLine().trim();
            nuevo = new Perro(id, nombre, edad, raza);
        } else {
            System.out.print("Ingrese color: ");
            String color = sc.nextLine().trim();
            nuevo = new Gato(id, nombre, edad, color);
        }

        boolean registrado = refugio.registrarAnimal(nuevo);
        if (registrado) {
            System.out.println("Animal registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el animal. Revise los datos ingresados.");
        }
    }

    private static void buscarAnimal(Scanner sc, Refugio refugio) {
        if (refugio.estaVacio()) {
            System.out.println("No hay animales registrados en el refugio.");
            return;
        }
        int id = leerEntero(sc, "Ingrese el ID a buscar: ");
        Animal a = refugio.buscarPorId(id);
        if (a != null) {
            a.mostrarInformacion();
            a.realizarAccion();
        } else {
            System.out.println("Animal no encontrado.");
        }
    }

    private static void adoptarAnimal(Scanner sc, Refugio refugio) {
        if (refugio.estaVacio()) {
            System.out.println("No hay animales registrados en el refugio.");
            return;
        }
        int id = leerEntero(sc, "Ingrese el ID del animal a adoptar: ");
        refugio.adoptarAnimal(id);
    }
}
