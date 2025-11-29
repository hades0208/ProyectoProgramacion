import java.util.Random;

public class ComprarInversion {

    private String[] vistas = {
            "Vista Principal", "Galería", "Perfil", "Ajustes", "Favoritos", "Historial"
    };

    // compras: [codigo, nombre, cantidad]
    private String[][] compras = new String[50][3];
    private int comprasSize = 0;

    private Random random = new Random();
    private VistaStorage storage = new VistaStorage();

    // Genera 3 compras aleatorias y guarda en archivo
    public void comprarVista() {
        for (int i = 0; i < 3; i++) {
            int codigo = random.nextInt(vistas.length); // índice válido
            String nombreVista = vistas[codigo];

            int pos = buscarCompras(codigo);
            if (pos != -1) {
                int cantidadActual = Integer.parseInt(compras[pos][2]);
                compras[pos][2] = String.valueOf(cantidadActual + 1);
            } else {
                compras[comprasSize][0] = String.valueOf(codigo);
                compras[comprasSize][1] = nombreVista;
                compras[comprasSize][2] = "1";
                comprasSize++;
            }
        }

        // Guardar después de cada compra
        storage.guardar(compras, comprasSize);
    }

    private int buscarCompras(int codigo) {
        for (int i = 0; i < comprasSize; i++) {
            if (Integer.parseInt(compras[i][0]) == codigo) {
                return i;
            }
        }
        return -1;
    }

    public void verVistas() {
        System.out.println("\n===== VISTAS COMPRADAS =====");

        if (comprasSize == 0) {
            System.out.println("Aún no hay vistas registradas.");
            return;
        }

        for (int i = 0; i < comprasSize; i++) {
            System.out.println(
                    "Código: " + compras[i][0] +
                            " | Nombre: " + compras[i][1] +
                            " | Cantidad: " + compras[i][2]
            );
        }
    }
}

