import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {

    public static void guardarVistasEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("vistas.txt"))) {
            for (int i = 0; i < VistaStorage.getCantidadVistas(); i++) {
                writer.println(VistaStorage.obtenerVistas()[i]);
            }
            System.out.println("Vistas guardadas en 'vistas.txt'");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}