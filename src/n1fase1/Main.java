package n1fase1;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        /*Tenint una llista de cadenes de noms propis,  escriu un mètode que retorn e una llista de totes les cadenes
        que  comencen amb la lletra 'a' (mayuscula ) i  tenen exactament 3  lletres. Imprimeix el resultat . */
        List<String> noms = new ArrayList<>(Arrays.asList("oan", "Ana", "ana", "Araceli", "Ava"));
        noms = filtrarNoms(noms);

        System.out.println("Exercici 1 = ");
        noms.forEach(System.out::println);

        /*Escriu un mètode que retorne una cadena separada per comes basada en una llista d’Integers.
         Cada element  hauria d'anar precedit per la  lletra  "e" si el nombre és parell , i precedit de la lletra  "o"
          si el nombre és im parell. Per exemple, si la llista  d'entrada és (3,44), la  sortida hauria de ser "o3, e44".
            Imprimeix el  resultat. */
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,5,12,44,987,55,34));
        String result = entersACadena(integerList);

        System.out.println("Exercici 2 = " + result);

        /*Tenint una llista de Strings, escriu un mètode que retorni una llista de totes les cadenes que continguin
        la lletra ‘o’ i imprimeix el resultat. */
        List<String> filtrat = new ArrayList<>(Arrays.asList("oan", "Ana", "anoa", "Aracoeli", "Ava"));
        filtrat = filtrarPerOMinuscula(filtrat);

        System.out.println("Exercici 3 = " + filtrat);

        /*Has de fer el mateix que en el punt anterior, però retornant una llista que
        incloga els elements amb més de 5 lletres. Imprimeix el resultat. */
        filtrat = new ArrayList<>(Arrays.asList("oan", "Ana", "anoa", "Aracoeli", "Ava"));
        filtrat = filtrarPerOMinuscula(filtrat);

        System.out.println("Exercici 4 = " + filtrat);

        /*Crea una llista amb  els nombs dels mesos de  l’any. Imprimeix tots els  elements de la llista amb  una
        lambda. */
        List<String> mesos = Arrays.stream(Month.values()).map(Enum::name).toList();
        System.out.println("Exercici 5 = ");
        mesos.stream().forEach(s -> System.out.println(s));

        /*Has de  fer la mateixa impressió del punt  anterior  però fent-ho mitjançant method   reference.  */
        System.out.println("Exercici 6 = ");
        mesos.stream().forEach(System.out::println);
    }

    private static List<String> filtrarNoms(List<String> noms) {
        return noms.stream().
                filter(nom -> nom.length() == 3).
                filter(nom -> nom.startsWith("A")).
                collect(Collectors.toList());
    }

    private static String entersACadena(List<Integer> integerList) {
        return integerList.stream()
                .map(integer -> integer % 2 == 0 ? "e" + integer : "o" + integer).collect(Collectors.joining(","));
    }

    private static List<String> filtrarPerOMinuscula(List<String> filtrat) {
        return filtrat.stream().
                filter(s -> s.contains("o")).
                collect(Collectors.toList());
    }

    private static List<String> filtrarPerOMinusculaITamany5(List<String> filtrat) {
        return filtrat.stream().
                filter(s -> s.contains("o")).
                filter(s -> s.length() > 5).
                collect(Collectors.toList());
    }
}
