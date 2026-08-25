import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> conceptos = new ArrayList<>();
        ArrayList<String> categorias = new ArrayList<>();
        ArrayList<Double> montos = new ArrayList<>();

        int opcion;

        do {
            mostrarMenu();

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarGasto(conceptos, categorias, montos, scanner);
                    break;
                case 2:
                    mostrarGastos(conceptos, categorias, montos);
                    break;
                case 3:
                    System.out.printf("\nTotal: $%.2f\n", calcularTotal(montos));
                    break;
                case 4:
                    // mostrarGastoMayor(conceptos, categorias, montos);
                    System.out.println("\n[!] Función Mostrar Gasto Mayor no implementada aún.");
                    break;
                case 5:
                    // consultarGastosPorCategoria(categorias, montos, scanner);
                    System.out.println("\n[!] Función Consultar Gastos por Categoría no implementada aún.");
                    break;
                case 6:
                    mostrarResumen(conceptos, categorias, montos);
                    break;
                case 7:
                    System.out.println("\nPrograma terminado.");
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    public static void mostrarMenu() {
        out.println("\n=== MENÚ PRINCIPAL ===");
        out.println("1. Registrar gasto");
        out.println("2. Mostrar gastos");
        out.println("3. Calcular total");
        out.println("4. Mostrar gasto mayor (Pendiente)");
        out.println("5. Consultar por categoría (Pendiente)");
        out.println("6. Mostrar resumen");
        out.println("7. Salir");
        out.print("Ingrese una opción: ");
    }

    public static void registrarGasto(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos,
            Scanner scanner) {

        out.print("\nIngrese el concepto: ");
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
        scanner.nextLine(); // Limpiar el buffer

        conceptos.add(concepto);
        categorias.add(categoria);
        montos.add(monto);

        out.println("¡Gasto registrado exitosamente!");
    }

    public static void mostrarGastos(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos) {

        out.println("\nGASTOS REGISTRADOS\n");

        if (conceptos.isEmpty()) {
            out.println("No hay gastos registrados.");
            return;
        }

        for (int i = 0; i < conceptos.size(); i++) {
            out.printf("%d. %-15s | %-20s | $%.2f\n",
                    (i + 1),
                    conceptos.get(i),
                    categorias.get(i),
                    montos.get(i));
        }
    }

    // --- NUEVAS FUNCIONES SOLICITADAS ---

    public static double calcularTotal(ArrayList<Double> montos) {
        double total = 0;
        for (double monto : montos) {
            total += monto;
        }
        return total;
    }

    public static void mostrarResumen(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos) {

        out.println("\n--- RESUMEN DE GASTOS ---");

        if (conceptos.isEmpty()) {
            out.println("Aún no hay gastos registrados para mostrar un resumen.");
            return;
        }

        out.println("Total de movimientos: " + conceptos.size());
        out.printf("Gasto total acumulado: $%.2f\n", calcularTotal(montos));
        out.println("-------------------------");
    }
}