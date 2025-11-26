public class VistaStorage {
    private static String[] vistas = new String[255];
    private static int contador = 0;

    public static boolean insertarVista(String nombre) {
        if (contador >= 255) {
            return false;
        }
        vistas[contador] = nombre;
        contador++;
        return true;
    }

    public static boolean estaLleno() {
        return contador >= 255;
    }

    public static String[] obtenerVistas() {
        return vistas;
    }

    public static int getCantidadVistas() {
        return contador;
    }
}

