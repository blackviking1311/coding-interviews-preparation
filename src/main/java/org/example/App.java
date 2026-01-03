package org.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int el : arr) {
            map.put(el, map.getOrDefault(el, 1) + 1);
        }

        map = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));

        map = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        HashMap::new
                ));

        List<Integer> integers = new ArrayList<>();
        Iterator<Integer> iterator = map.keySet().iterator();

        for (int i = 0 ; i < k ; i++) {
            integers.add(iterator.next());
        }

        System.out.print("First two frequent numbers in the array: ");
        for (int el : integers) {
            System.out.print(el + " : ");
        }
    }
}
