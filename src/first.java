import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class first {
    public static void main(String[] args) {
        List<Person> team = Arrays.asList(new Person("Mohan", 20), new Person("Rajin", 22), new Person("Kushal", 40), new Person("mehool", 26));
        printWithoutStreams(team);
        printTeam(team);

    }

    public static void printWithoutStreams(List<Person> team) {
        Set<Person> freshBlood = new HashSet<>();
        for (Person person : team) {
            if (person.age <= 25) {
                freshBlood.add(person);
            }
        }
        List<Person> sortedFreshBlood = new ArrayList<>(freshBlood);
        Collections.sort(sortedFreshBlood, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age, o2.age);
            }

        });
        for (Person person : sortedFreshBlood) {
            System.out.println(person.name);
        }
    }

    public static void printTeam(List<Person> team) {
        team.stream()
                .filter(person -> person.age <= 25)
                .collect(Collectors.toSet())
                .stream()
                .sorted(comparing(person -> person.age))
                .forEach(person -> System.out.println(person.name));


    }


    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
