import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatórios =
        Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        numerosAleatórios.stream().forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros numeros e coloque dentro de um set: ");
        numerosAleatórios.stream()
        .limit(5)
        .collect(Collectors.toSet())
        .forEach(System.out::println);

        System.out.println("Transforme esta lista de String em uma lista de numeros inteiros: ");
        List<Integer> numerosAleatorios1 = numerosAleatórios.stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numerosAletoriosInteger = numerosAleatórios.stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());

        //.forEach(System.out::println);
        
        System.out.println("Pegue os numeros pares e maiores que 2 e coloque em uma lista: ");
        numerosAleatórios.stream()
        .map(Integer::parseInt)
        .filter(i -> i % 2 == 0 && i > 2)
        .collect(Collectors.toList())
        .forEach(System.out::println);

        System.out.println("Mostre a média dos numeros: ");
        numerosAleatórios.stream()
        .mapToInt(Integer::parseInt)
        .average()
        .ifPresent(System.out::println);

        System.out.println("Remova os valores Impares: ");
        numerosAletoriosInteger.removeIf(i -> (i % 2 !=0));
        System.out.println(numerosAletoriosInteger);

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante: ");
        numerosAleatórios.stream()
        .skip(3)
        .forEach(System.out::println);
        
        
        List<Integer> apagarCopias = numerosAleatorios1.stream()
        .distinct()
        .collect(Collectors.toList());
        System.out.println("Retirando os numeros repetidos da lista, quantos ficam?: " + apagarCopias);

        System.out.println("Mostre o menor valor da lista: ");
        numerosAleatorios1.stream()
        .mapToInt(Integer::intValue)
        .min()
        .ifPresent(System.out::println);

        System.out.println("Mostre o maior valor da lista: ");
        numerosAleatorios1.stream()
        .mapToInt(Integer::intValue)
        .max()
        .ifPresent(System.out::println);

        int numerosParesSoma = numerosAleatórios.stream()
        .map(Integer::parseInt)
        .filter(i -> i % 2 == 0 && i > 2)
        .mapToInt(Integer::intValue)
        .sum();
        System.out.println("Soma apenas dos numeros pares: " + numerosParesSoma);

        System.out.println("Mostre a lista na ordem númerica: ");
        List<Integer> ordemNatural = numerosAleatórios.stream()
        .map(Integer::parseInt)
        .sorted()
        .collect(Collectors.toList());
        System.out.println(ordemNatural);

        System.out.println("Agrupe os valores ímpares multiplos de 3 ou de 5: ");
        Map<Boolean, List<Integer>> valoresMultiplos = numerosAletoriosInteger.stream()
        .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(valoresMultiplos);
    }
}