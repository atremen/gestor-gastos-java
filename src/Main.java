import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> conceptos = new ArrayList<>();
        ArrayList<String> categorias = new ArrayList<>();
        ArrayList<Double> montos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        registrarGasto(conceptos, categorias, montos, scanner);
        mostrarGastos(conceptos, categorias, montos);

        scanner.close();
    }

    public static void registrarGasto(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos,
            Scanner scanner) {

        out.print("Ingrese el concepto: ");
        String concepto = scanner.nextLine();

        String categoria = "";
        boolean categoriaValida = false;

        while (!categoriaValida) {
            out.println("Categorías disponibles: Alimentos, Transporte, Materiales Escolares, Entretenimiento, Otros");
            out.print("Ingrese la categoría: ");
            categoria = scanner.nextLine();

            if (categoria.equalsIgnoreCase("Alimentos") ||
                    categoria.equalsIgnoreCase("Transporte") ||
                    categoria.equalsIgnoreCase("Materiales Escolares")
                    || categoria.equalsIgnoreCase("Entretenimiento") ||
                    categoria.equalsIgnoreCase("Otros")) {
                categoriaValida = true;
            } else {
                out.println("Categoría no válida. Intente de nuevo.");
            }
        }

        double monto = 0;

        while (monto <= 0) {
            out.print("Ingrese el monto: ");
            if (scanner.hasNextDouble()) {
                monto = scanner.nextDouble();
                if (monto <= 0) {
                    out.println("Error: El monto debe ser mayor a cero.");
                }
            } else {
                out.println("Error: Ingrese un valor numérico.");
                scanner.next();
            }
        }
        scanner.nextLine();

        conceptos.add(concepto);
        categorias.add(categoria);
        montos.add(monto);
    }

    public static void mostrarGastos(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos) {

        out.println("\nGASTOS REGISTRADOS\n");

        for (int i = 0; i < conceptos.size(); i++) {
            out.printf("%d. %-11s | %-10s | $%.2f\n",
                    (i + 1),
                    conceptos.get(i),
                    categorias.get(i),
                    montos.get(i));
        }
    }
}