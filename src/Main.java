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
                                                   String categoriaBuscada,
                                                   ArrayList<Double> montosAlimentos,
                                                   ArrayList<Double> montosTransporte,
                                                   ArrayList<Double> montosMaterialesEscolares,
                                                   ArrayList<Double> montosEntretenimiento,
                                                   ArrayList<Double> montosOtros,
                                                   Scanner scanner){
        boolean categoriaValida = false;
        String categoria = "";
        while (!categoriaValida) {
            out.println("Categorías disponibles: Alimentos, Transporte, Materiales Escolares, Entretenimiento, Otros");
            out.print("Ingrese la categoría: ");
            categoria = scanner.nextLine();

            if (categoria.equalsIgnoreCase("Alimentos") ||
                    categoria.equalsIgnoreCase("Transporte") ||
                    categoria.equalsIgnoreCase("Materiales Escolares") ||
                    categoria.equalsIgnoreCase("Entretenimiento") ||
                    categoria.equalsIgnoreCase("Otros")) {
                categoriaValida = true;
            } else {
                out.println("Categoría no válida. Intente de nuevo.");
            }
        }

        int numCategoria;
        float total = 0;
        if(categoriaBuscada.equalsIgnoreCase("Alimentos"){
            for(Double item:montosAlimentos){
                total += item;
            }
        }
        scanner.nextLine(); // Limpiar el buffer

        conceptos.add(concepto);
        categorias.add(categoria);
        montos.add(monto);

        out.println("¡Gasto registrado exitosamente!");
        if(categoriaBuscada.equalsIgnoreCase("Transporte"){
            for(Double item:montosTransporte){
                total += item;
            }
        }
        if(categoriaBuscada.equalsIgnoreCase("Materiales Escolares"){
            for(Double item:montosMaterialesEscolares){
                total += item;
            }
        }
        if(categoriaBuscada.equalsIgnoreCase("Entretenimiento"){
            for(Double item:montosEntretenimiento){
                total += item;
            }
        }
        if(categoriaBuscada.equalsIgnoreCase("Otros")){
            for(Double item:montosOtros){
                total += item;
            }
        }
        return total;
    }

    public static void mostrarResumen(ArrayList<String> conceptos, ArrayList<String> categorias, ArrayList<Double> montos, float total, int posicionGastoMayor){
        float promedio = total / montos.size();
        out.print("\nRESUMEN SEMANAL\n");
        out.printf("\nNumero de gastos: %d", montos.size() );
        out.printf("\nGasto total: $%.2f", total);
        out.printf("\nPromedio por gasto: $%.2f", promedio);
        out.printf("\nGasto mayor: %s, %.2f", conceptos.get(posicionGastoMayor), montos.get(posicionGastoMayor) );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gestor semanal de gastos");

        ArrayList<String> conceptos = new ArrayList<>();
        String[] categorias = new String[5];
        double[] montos = new double[5];

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