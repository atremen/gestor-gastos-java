import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {

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

}
