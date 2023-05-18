package ejecutable;

import modelo.Fecha;

public class Test{
    public static void main(String[] args) {

        System.out.println("\n");

        Fecha f = new Fecha(1,12,1980);
        f.addDias(180);

        Fecha f2 = new Fecha(2,9,1333);
        f2.addDias(180);

        System.out.println(f.toString());
        System.out.println(f2.toString());


        if(f.equals(f2)){
            System.out.println("Las fechas son iguales");
            }
            else{
                System.out.println("Las fechas son diferentes");
            }
    }
}