import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {

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
      
    public static double calcularTotal(ArrayList<Double> montos){
        double Total=0;
        for(double item:montos){
            Total += item;
        }
        return Total;
    }

    public static int obtenerPosicionGastoMayor(ArrayList<Double> montos){
        int PosicionGastoMayor=0;
        for(int i=1; i<montos.size(); i++){
            if( montos.get(i) > montos.get(PosicionGastoMayor) ){
                PosicionGastoMayor = i;
            }
        }
        return PosicionGastoMayor;
    }

    public static double calcularTotalPorCategoria(ArrayList<String> categorias,
                                                   ArrayList<Double> montos,
                                                   String categoriaBuscada){
        double total = 0.0;
        for(int i = 0; i < categorias.size(); i++){
            if( categorias.get(i).equalsIgnoreCase(categoriaBuscada )){
                total += montos.get(i);                                      
            }
        }
        return total;
    }

    public static void mostrarMenu(){
        System.out.println("\n1) Registrar nuevo gasto");
        System.out.println("2) Mostrar todos los gastos");
        System.out.println("3) Mostrar total de gastos");
        System.out.println("4) Mostrar gasto mayor");
        System.out.println("5) Consultar gasto por categoria");
        System.out.println("6) Mostrar resumen");
        System.out.println("7) Salir");
    }

    public static void mostrarGastoMayor(ArrayList<String> conceptos,
                                         ArrayList<String> categorias,
                                         ArrayList<Double> montos){
        int posicion = obtenerPosicionGastoMayor(montos);
        System.out.println("Gasto mayor:");
        System.out.println("Concepto: " + conceptos.get(posicion));
        System.out.println("Categoria: " + categorias.get(posicion));
        System.out.println("Monto: $" + montos.get(posicion));
    }

    public static void consultarGastosPorCategoria(ArrayList<String> categorias,
                                                   ArrayList<Double> montos,
                                                   Scanner scanner){
        System.out.print("Ingresar categoria a consultar: ");
        String categoria = scanner.nextLine();
        Double total = calcularTotalPorCategoria(categorias, montos, categoria);
        System.out.println("Gasto total de " + categoria + ": $" + total);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gestor semanal de gastos");

        ArrayList<String> conceptos = new ArrayList<>();
        ArrayList<String> categorias = new ArrayList<>();
        ArrayList<Double> montos = new ArrayList<>();

        int opcion;

        do {

            mostrarMenu();

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    registrarGasto(conceptos, categorias, montos, scanner);
                    break;

                case 2:
                    mostrarGastos(conceptos, categorias, montos);
                    break;

                case 3:
                    System.out.println("Total: $" + calcularTotal(montos));
                    break;

                case 4:
                    mostrarGastoMayor(conceptos, categorias, montos);
                    break;

                case 5:
                    consultarGastosPorCategoria(categorias, montos, scanner);
                    break;

                case 6:
                    mostrarResumen(conceptos, categorias, montos);
                    break;

                case 7:
                    System.out.println("Programa terminado.");
                    break;

                default:
                    System.out.println("Opción no válida.");

            }
        } while (opcion != 7);
        scanner.close();
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