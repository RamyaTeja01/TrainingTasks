package StreamsWithCollections;

import java.util.*;
import java.util.stream.*;

public class MapAndCollectDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6);

        List<Integer> squares = numbers.stream()
                                       .map(n -> n * n)
                                       .collect(Collectors.toList());

        System.out.println("Original Numbers: " + numbers);
        System.out.println("Squared Numbers: " + squares);
    }
}
