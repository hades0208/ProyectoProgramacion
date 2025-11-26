import java.util.Scanner;

public class AdminMain {
    private static Scanner Teclado = new Scanner(System.in);

    public static void mostrar() {
        int opcion;
        do {
            System.out.println("--- Menu Administrador ---");
            System.out.println("1. Insertar Nueva Vista");
            System.out.println("2. Imprimir Vistas");
            System.out.println("3. Menú Principal");
            System.out.print("Elegir una opcion: ");

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    insertarNuevaVista();
                    break;
                case 2:
                    imprimirVistas();
                    break;
                case 3:
                    System.out.println("Regresando al Menu Principal...");
                    break;
                default:
                    System.out.println("Opción invalida. Por favor, elija 1, 2 o 3.");
            }
        } while (opcion != 3);
    }

    private static void insertarNuevaVista() {
        if (VistaStorage.estaLleno()) {
            System.out.println("Almacén de vistas lleno (máximo 255). No se pueden agregar mas.");
            return;
        }

        System.out.print("Ingresa el nombre de la vista: ");
        String nombre = Teclado.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        boolean exito = VistaStorage.insertarVista(nombre);

        if (exito) {

            FileManager.guardarVistasEnArchivo();
            System.out.println("Vista \"" + nombre + "\" agregada correctamente.");
        } else {
            System.out.println("No se pudo agregar la vista.");
        }
    }

    private static void imprimirVistas() {
        String[] vistas = VistaStorage.obtenerVistas();
        int cantidad = VistaStorage.getCantidadVistas();

        if (cantidad == 0) {
            System.out.println("No hay vistas registradas.");
            return;
        }

        System.out.println("--- Listado de Vistas ---");
        for (int i = 0; i < cantidad; i++) {
            System.out.println((i + 1) + ". " + vistas[i]);
        }
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(Teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
