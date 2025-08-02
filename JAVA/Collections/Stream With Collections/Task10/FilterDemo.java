package StreamsWithCollections;

import java.util.*;
import java.util.stream.*;

public class FilterDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java", "Python", "JavaScript", "C++", "Julia");

        List<String> result = names.stream()
                                   .filter(name -> name.startsWith("J"))
                                   .collect(Collectors.toList());

        System.out.println("Strings starting with 'J': \n" + result);
    }
}
