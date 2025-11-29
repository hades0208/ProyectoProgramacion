import java.io.FileWriter;
import java.io.IOException;

public class VistaStorage {


    public void guardar(String[][] compras, int size) {
        try (FileWriter writer = new FileWriter("compras.txt")) {

            writer.write("CÓDIGO | NOMBRE | CANTIDAD\n");
            writer.write("-----------------------------------------\n");

            for (int i = 0; i < size; i++) {
                writer.write(
                        compras[i][0] + " | " +
                                compras[i][1] + " | " +
                                compras[i][2] + "\n"
                );
            }

        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }
}
