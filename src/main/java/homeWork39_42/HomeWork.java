package homeWork39_42;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**Создать список оценок учеников с помощью ArrayList,
*заполнить случайными оценками. Удалить неудовлетворительные оценки из списка.
*/

public class HomeWork{
    public static ArrayList<Student> grades;
    public static class Student {
        String name;
        int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Имя: " + name + "\t Оценка : " + grade;
        }
    }



    public static void main(String[] args) {
        int count = 12;//Количество студентов
        int minGrade = 4;//С оценкой ниже будут отчислены
        grades = new ArrayList<>();
        fill(count);
        System.out.println("До сессии: ");
        printList(grades);
        removeNonAcceptableWithStream(minGrade);
        System.out.printf("После сессии: (с оценкой %d и ниже отчислены)\n",minGrade);
        printList(grades);
        System.out.println("Лучший(е) студент(ы) :");
        printList(findTheBestsWithStream());
      }

    static void fill(int count) {
        String[] names = new String[]{"Миша", "Маша", "Петя", "Вова", "Максим", "Игорь"};
        for (int i = 0; i < count; i++) {
            Student student = new Student(names[(int) (Math.random() * 6)], (int) (Math.random() * 10) + 1);
            grades.add(student);
        }
    }

    static void removeNonAcceptableWithStream(int grade) {
        Stream<Student> studentsStream = grades.stream();
         grades = (ArrayList<Student>) studentsStream.filter(x -> x.grade > grade).collect(Collectors.toList());
    }

    static void printList(ArrayList<Student> arrayList) {
        arrayList.forEach(System.out::println);
    }

    static ArrayList <Student> findTheBestsWithStream() {
        Stream<Student> studentsStream = grades.stream();
        Student bestStudent = studentsStream.max(HomeWork::compare).get();
        studentsStream = grades.stream();
        return (ArrayList<Student>) studentsStream.filter(x -> x.grade == bestStudent.grade).collect(Collectors.toList());
    }

    private static int compare(Student std1, Student std2) {
        return (Integer.compare(std1.grade, std2.grade));
    }

}
