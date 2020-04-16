package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyStreamService implements StreamService {
    @Override
    public void sortAndPrint(List<String> names) {
        names.stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Override
    public int distinctAndCountNumbers(int[] numbers) {
         return Math.toIntExact(Arrays.stream(numbers)
                 .distinct().count());
    }

    @Override
    public List<String> computeMaleNames(List<String> names) {
        List<String> maleNames = new ArrayList<>();
        long numberOfMaleNames = names.stream()
                .filter(e -> !e.endsWith("a"))
                .count();
        System.out.println(numberOfMaleNames);
        return maleNames;
    }

    @Override
    public void printNumbersOfRange(int[] numbers, int minValue, int maxValue) {

        Arrays.stream(numbers).filter(n -> n >= minValue)
                .limit(maxValue + 1)
                .forEach(System.out::println);
        // nie wiem czy chodziło o zakres elementów tablicy czy zakres wartości tych elementów, ale to co zrobiłem
        // jest ciekawe :D

    }

    @Override
    public List<Integer> computeNamesLength(List<String> names) {
        return names.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> buildPeopleWithNames(List<String> names) {
        return names.stream()
                .map(MyPerson::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> findPeopleOfIdGreaterThan(List<Person> people, int id) {
        return people.stream()
                .filter(p -> p.getId() > id)
                .collect(Collectors.toList());

    }

    @Override
    public boolean hasSenior(List<Person> people) {
        return people.stream()
                .anyMatch(person -> person.getAge() > 60);

    }

    @Override
    public double sumTotalCash(List<Person> people) {
        return people.stream()
                .mapToDouble(Person::getCash)
                .sum();
    }

    @Override
    public Person findRichestPerson(List<Person> people) {
        return people.stream()
                .max(Comparator.comparing(Person::getCash)).get();
    }

    @Override
    public double computeAverageAge(List<Person> people) {
        return people.stream()
                .mapToDouble(Person::getAge)
                .average()
                .getAsDouble();
    }
}
