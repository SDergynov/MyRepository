package homeWork62;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * @author S.Dergunov sdergynov@gmail.com
 * "Keep it simply stupid!"
 *
<br>Создайте класс Person с полями name, surname, age. Сгенерируйте группу из 100 человек в возрасте от 15 до 30. Напишите ОДНУ НЕПРЕРЫВНУЮ цепочку stream вызовов, которая:
        1) выбирает объекты, возраст которых меньше 21;
        2) распечатывает их на экран;
        3) сортирует по фамилии, а потом по имени (использовать thenComparing у объекта Comparator);
        4) берет 4 первых объекта;
        5) формирует коллекцию из фамилий объектов;
        6) агрегирует все в коллекцию.*/

public class Runner {
    static private final ArrayList <Person>personsList = new ArrayList<>();
    static int age;

    public static void main(String[] args){
        createPersonsList();
        Stream<Person> streamPersons = personsList.stream();
        printList();
        System.out.println();
        ArrayList<String> acceptableSurnames = (ArrayList<String>) streamPersons.
                filter(x -> x.age < 21).                            //Фильтр возраст менее 21
                        peek(System.out::println).                          //напечатать
                        sorted(Comparator.comparing(Person::getSurname).    //сортировать по фамилии
                        thenComparing(Person::getName)).                    //затем по имени
                        limit(4).                                           //лимит элементов - первые 4
                        map(Person::getSurname).                            //взять фамилии
                        collect((Collectors.toList()));                     // положить в коллекцию
        System.out.println();
        printSurnameList(acceptableSurnames);
      }

    static void createPersonsList() {
        for (int i = 0; i < 100; i++) {
            age = (int) (15 + Math.random() * 15);
            Name name = Name.values()[(int) (Math.random() * Name.values().length)];
            Surname surname = Surname.values()[(int) (Math.random() * Surname.values().length)];
            Person person = new Person(name, surname, age);
            personsList.add(person);
        }
    }

    static void printList() {
      Runner.personsList.forEach(System.out::println);
         }

    static void printSurnameList(ArrayList<String> arrayList) {
        arrayList.forEach(System.out::println);
    }
}

