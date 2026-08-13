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

    public static double calcularTotalPorCategoria(ArrayList<String> categorias, ArrayList<Double> montos, String categoriaBuscada){
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

        int numCategoria;
        float total = 0;
        if(categoriaBuscada.equalsIgnoreCase("Alimentos"){
            for(float item:montosAlimentos){
                total += item;
            }
        }
        if(categoriaBuscada.equalsIgnoreCase("Transporte"){
            for(float item:montosTransporte){
                total += item;
            }
        }
        if(categoriaBuscada.equalsIgnoreCase("Materiales Escolares"){
            for(float item:montosMaterialesEscolares){
                total += item;
            }
        }
        if(categoriaBuscada.equalsIgnoreCase("Entretenimiento"){
            for(float item:montosEntretenimiento){
                total += item;
            }
        }
        if(categoriaBuscada.equalsIgnoreCase("Otros")){
            for(float item:montosOtros){
                total += item;
            }
        }
        return total;
    }

    public static void mostrarResumen(ArrayList<String> conceptos, ArrayList<String> categorias, ArrayList<Double> montos, float total){
        System.out.println("\nRESUMEN SEMANAL\n");
        System.out.println("\nNumero de gastos: %d", montos.size() );
        System.out.println("\nGasto total: $%.2f", total);
        System.out.println("\nPromedio por gasto: $%.2f");
    }

    public static void main(String[] args) {
        System.out.println("Gestor semanal de gastos");

        ArrayList<String> conceptos = new ArrayList<>();
        String[] categorias = new String[5];
        double[] montos = new double[5];

        categorias[0] = "Alimentos";
        conceptos.add("Cheeseburger");
        conceptos.add("Pizza pizza");
        conceptos.add("YUMMY :P");
        conceptos.add(1, "NOM NOM NOM");

        for(String item:conceptos){
            System.out.println(item);
        }

        if(conceptos.contains("Cheeseburger")){
            System.out.println("\nmmm cheeseburger");
        }

        //System.out.println(categorias[0]);
        //System.out.println(conceptos.get(2));




    }

}
