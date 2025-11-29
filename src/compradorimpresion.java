import java.util.Scanner;

public class compradorimpresion {

    // Método para imprimir solo las compras que tienen datos
    public void imprimirCompras(String[][] compras) {
        System.out.println("Código\tNombre\tCantidad");

        if (compras == null) return;

        for (int i = 0; i < compras.length; i++) {
            String[] fila = compras[i];
            // Solo imprimir si la fila no es null y la primera columna tiene datos
            if (fila != null && fila[0] != null) {
                String codigo = (fila[0] != null) ? fila[0] : "N/A";
                String nombre = (fila[1] != null) ? fila[1] : "N/A";
                String cantidad = (fila[2] != null) ? fila[2] : "N/A";

                System.out.println(codigo + "\t" + nombre + "\t" + cantidad);
            }
        }
    }

    // Método main de prueba
    public static void main(String[] args) {
        // Crear arreglo de ejemplo
        String[][] compras = new String[255][3];

        // Solo llenamos algunas filas
        compras[0][0] = "0";
        compras[0][1] = "Messi";
        compras[0][2] = "1";

        compras[5][0] = "1";
        compras[5][1] = "Ronaldo";
        compras[5][2] = "2";

        compras[10][0] = "3";
        compras[10][1] = "Neymar";
        compras[10][2] = "1";

        // Crear objeto e imprimir
        compradorimpresion comprador = new compradorimpresion();
        comprador.imprimirCompras(compras);
    }
}