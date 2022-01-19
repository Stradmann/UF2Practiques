/*2. Escriu una funció anomenada “CalcularIVA” a la que se li passa un preu, un
tipus d’IVA i la data de la compra i retorna el preu amb l’IVA aplicat. El tipus
d’IVA pot ser General, Reduït, Superreduït o Exempt. El percentatge a aplicar
és el vigent en la data de compra i el podem trobar en aquesta taula:
Data inici vigència General Reduït Superreduit Exempt
01-01-1986 12% 6% No existeix 0%
01-01-1992 15% 6% No existeix 0%
01-01-1993 15% 6% 3% 0%
01-01-1995 16% 7% 4% 0%
01-01-2010 18% 8% 4% 0%
15-07-2012 21% 10% 4% 0%*/
package Practica7;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Exercici2 {

    public static double CalcularIVA(double preu, String iva, Date data_compra) {
        int ordenacio = Ordenacio_data(data_compra);
        double iva_per_aplicar = 0, preu_final = 0;
        switch (ordenacio) {
            case 1:
                iva_per_aplicar = Primera_data_IVA(iva);
                preu_final = preu + (preu * iva_per_aplicar);
                break;
            case 2:
                iva_per_aplicar = Segona_data_IVA(iva);
                preu_final = preu + (preu * iva_per_aplicar);
                break;
            case 3:
                iva_per_aplicar = Tercera_data_IVA(iva);
                preu_final = preu + (preu * iva_per_aplicar);
                break;
            case 4:
                iva_per_aplicar = Quarta_data_IVA(iva);
                preu_final = preu + (preu * iva_per_aplicar);
                break;
            case 5:
                iva_per_aplicar = Cinquena_data_IVA(iva);
                preu_final = preu + (preu * iva_per_aplicar);
                break;
            case 6:
                iva_per_aplicar = Sisena_data_IVA(iva);
                preu_final = preu + (preu * iva_per_aplicar);
                break;
        }
        return preu_final;
    }

    public static void PasarDataDate(Date data, String data_pasar) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = formatter.parse(data_pasar);
        } catch (ParseException e) {
            // Ara per ara, no farem res
            System.out.println("La data no és vàlida");
        }
    }

    public static int Ordenacio_data(Date data) {
        final Date PRIMERA_DATA = null;
        final Date SEGONA_DATA = null;
        final Date TERCERA_DATA = null;
        final Date QUARTA_DATA = null;
        final Date CINQUENA_DATA = null;
        final Date SISENA_DATA = null;
        final String DATA_STRING_PRIMERA = "01/01/1986";
        final String DATA_STRING_SEGONA = "01/01/1992";
        final String DATA_STRING_TERCERA = "01/01/1993";
        final String DATA_STRING_QUARTA = "01/01/1995";
        final String DATA_STRING_CINQUENA = "01/01/2010";
        final String DATA_STRING_SISENA = "15/07/2012";
        int ordenacio = 0;
        PasarDataDate(PRIMERA_DATA, DATA_STRING_PRIMERA);
        PasarDataDate(SEGONA_DATA, DATA_STRING_SEGONA);
        PasarDataDate(TERCERA_DATA, DATA_STRING_TERCERA);
        PasarDataDate(QUARTA_DATA, DATA_STRING_QUARTA);
        PasarDataDate(CINQUENA_DATA, DATA_STRING_CINQUENA);
        PasarDataDate(SISENA_DATA, DATA_STRING_SISENA);
        if ((data.after(PRIMERA_DATA) || data.equals(PRIMERA_DATA)) && data.before(SEGONA_DATA)) {
            ordenacio = 1;
        } else if ((data.after(SEGONA_DATA) || data.equals(SEGONA_DATA)) && data.before(TERCERA_DATA)) {
            ordenacio = 2;
        } else if ((data.after(TERCERA_DATA) || data.equals(TERCERA_DATA)) && data.before(QUARTA_DATA)) {
            ordenacio = 3;
        } else if ((data.after(QUARTA_DATA) || data.equals(QUARTA_DATA)) && data.before(CINQUENA_DATA)) {
            ordenacio = 4;
        } else if ((data.after(CINQUENA_DATA) || data.equals(CINQUENA_DATA)) && data.before(SISENA_DATA)) {
            ordenacio = 5;
        } else {
            ordenacio = 6;
        }
        return ordenacio;
    }

    public static double Primera_data_IVA(String iva_aplicar) {
        final double IVA_GENERAL = 0.12, IVA_REDUIT = 0.06, IVA_EXEMPT = 1;
        double iva = 0;
        switch (iva_aplicar) {
            case "G":
            case "g":
                iva = IVA_GENERAL;
                break;
            case "R":
            case "r":
                iva = IVA_REDUIT;
                break;
            case "E":
            case "e":
                iva = IVA_EXEMPT;
                break;
        }
        return iva;
    }

    public static double Segona_data_IVA(String iva_aplicar) {
        final double IVA_GENERAL = 0.15, IVA_REDUIT = 0.06, IVA_EXEMPT = 1;
        double iva = 0;
        switch (iva_aplicar) {
            case "G":
            case "g":
                iva = IVA_GENERAL;
                break;
            case "R":
            case "r":
                iva = IVA_REDUIT;
                break;
            case "E":
            case "e":
                iva = IVA_EXEMPT;
                break;
        }
        return iva;
    }

    public static double Tercera_data_IVA(String iva_aplicar) {
        final double IVA_GENERAL = 0.15, IVA_REDUIT = 0.06, IVA_SUPER = 0.03, IVA_EXEMPT = 1;
        double iva = 0;
        switch (iva_aplicar) {
            case "G":
            case "g":
                iva = IVA_GENERAL;
                break;
            case "R":
            case "r":
                iva = IVA_REDUIT;
                break;
            case "S":
            case "s":
                iva = IVA_SUPER;
                break;
            case "E":
            case "e":
                iva = IVA_EXEMPT;
                break;
        }
        return iva;
    }

    public static double Quarta_data_IVA(String iva_aplicar) {
        final double IVA_GENERAL = 0.16, IVA_REDUIT = 0.07, IVA_SUPER = 0.04, IVA_EXEMPT = 1;
        double iva = 0;
        switch (iva_aplicar) {
            case "G":
            case "g":
                iva = IVA_GENERAL;
                break;
            case "R":
            case "r":
                iva = IVA_REDUIT;
                break;
            case "S":
            case "s":
                iva = IVA_SUPER;
                break;
            case "E":
            case "e":
                iva = IVA_EXEMPT;
                break;
        }
        return iva;
    }

    public static double Cinquena_data_IVA(String iva_aplicar) {
        final double IVA_GENERAL = 0.18, IVA_REDUIT = 0.08, IVA_SUPER = 0.04, IVA_EXEMPT = 1;
        double iva = 0;
        switch (iva_aplicar) {
            case "G":
            case "g":
                iva = IVA_GENERAL;
                break;
            case "R":
            case "r":
                iva = IVA_REDUIT;
                break;
            case "S":
            case "s":
                iva = IVA_SUPER;
                break;
            case "E":
            case "e":
                iva = IVA_EXEMPT;
                break;
        }
        return iva;
    }

    public static double Sisena_data_IVA(String iva_aplicar) {
        final double IVA_GENERAL = 0.21, IVA_REDUIT = 0.1, IVA_SUPER = 0.04, IVA_EXEMPT = 1;
        double iva = 0;
        switch (iva_aplicar) {
            case "G":
            case "g":
                iva = IVA_GENERAL;
                break;
            case "R":
            case "r":
                iva = IVA_REDUIT;
                break;
            case "S":
            case "s":
                iva = IVA_SUPER;
                break;
            case "E":
            case "e":
                iva = IVA_EXEMPT;
                break;
        }
        return iva;
    }

    public static double LlegirDouble(Scanner scan, String missatge) {
        boolean dadesCorrectes;
        double result = 0;
        do {
            if (missatge != null) {
                System.out.print(missatge);
            }
            dadesCorrectes = scan.hasNextDouble();
            if (dadesCorrectes) {
                result = scan.nextDouble();
            } else if (scan.hasNext()) {
                scan.nextLine();
            }
        } while (!dadesCorrectes);

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Date data_compra = null;
        Double preu = LlegirDouble(scan, "Quin preu té el teu producte? ");
        scan.next();
        System.out.print("Escriu la data en la que vas comprar el producte(no pot ser anterior a 01/01/1986 i la data introduida té que estar en format DD/MM/AAAA): ");
        String string_data_compra = scan.nextLine();
        PasarDataDate(data_compra, string_data_compra);
        System.out.print("Quin tipus d'IVA tens? G (general), R (reduït), S (Superreduït), E (exempt) ");
        String tipus_iva = scan.nextLine();
        Double preu_final = CalcularIVA(preu, tipus_iva, data_compra);
        System.out.println(preu_final);
    }
}
