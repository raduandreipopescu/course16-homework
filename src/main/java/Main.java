import model.Person;
import service.PersonService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Stefan", "Mare", 33, "Oradea"),
                new Person("Alexandru", "Lapusneanu", 77, "Iasi"),
                new Person("Mihai", "Viteazul", 17, "Cluj"),
                new Person("Iancu", "Hunedoara", 55, "Hunedoara"),
                new Person("Vlad", "Tepes", 17, "Bucuresti"),
                new Person("Alexandru", "Cuza", 15, "Oradea"),
                new Person("Alexandru", "Lapusneanu", 7, "Bucuresti"),
                new Person(),
                Person.builder().firstName("Andrei").city("Cluj").build()
        );

        PersonService persons = new PersonService(personList);

        System.out.println("\nPersons names: " + persons.listPersonsNames());
        System.out.println("\nMajor persons: " + persons.listMajorPersons());
        System.out.println("\nPersons from Oradea: " + persons.listPersonsFromCity(List.of("Oradea")));
        System.out.println("\nPersons from Oradea or Cluj: " + persons.listPersonsFromCity(List.of("Oradea", "Cluj")));
        System.out.println("\nPersons first names capitalised: " + persons.listFirstNamesCapitalised());
        System.out.println("\nPersons names shorted: " + persons.listPersonsNamesShort());
        System.out.println("\nPersons between 18 and 60 years: " + persons.listPersonsBetweenTwoAges(18, 60));
        System.out.println("\nPersons whose first name starts with 'A': " + persons.listPersonsFirstNameStartsWithLetter("A"));
        System.out.println("\nUnique first names of persons: " + persons.listUniqueFirstNames());
        System.out.println("\nPersons sorted by first name: " + persons.sortPersonsByFirstName());
        System.out.println("\nPersons sorted by last name: " + persons.sortPersonsByLastName());
        System.out.println("\nPersons sorted by first name, last name and age: " + persons.sortPersonsByFirstNameLastNameAndAge());
    }
}
