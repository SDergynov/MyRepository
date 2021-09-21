package sortMap;

import java.util.*;

/**
 * @author S.Dergunov sdergynov@gmail.com
 * "Keep it simply stupid!"
 *
 *<br> Отсортировать MAP по значению
 */

public class Main {

 public static void main(String[] args) {

  Map<String, Integer> nonSortedMap = Map.of(
          "Two",2,
          "Three",3,
          "Five",5,
          "One",1,
          "Four",4
  );

  Map<String, Integer> sortedMap = sortByValue(nonSortedMap);
  sortedMap.entrySet().forEach(System.out::println);
 }

 static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {
  Map<String, Integer> map = new LinkedHashMap<>();
  unsortedMap
          .entrySet()
          .stream()
          .sorted(Map.Entry.<String, Integer>comparingByValue())
          .forEach(x -> map.put(x.getKey(), x.getValue()));
  return map;
 }
}
