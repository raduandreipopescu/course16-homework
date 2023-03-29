package service;

import model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService {
    private List<Person> persons = new ArrayList<>();

    public PersonService(List<Person> persons) {
        if (persons == null) {
            this.persons = new ArrayList<>();
        } else {
            this.persons.addAll(persons);
        }
    }

    public List<String> listPersonsNames() {
        return persons.stream()
                .filter(person -> (person.getFirstName() != null || person.getLastName() != null))
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .toList();
    }

    public List<Person> listMajorPersons() {
        return persons.stream()
                .filter(person -> person.getAge() != null)
                .filter(person -> person.getAge() >= 18)
                .toList();
    }

    public List<Person> listPersonsFromCity(List<String> cities) {
        return persons.stream()
                .filter(person -> person.getCity() != null)
                .filter(person -> cities.contains(person.getCity()))
                .toList();
    }

    public List<String> listFirstNamesCapitalised() {
        return persons.stream()
                .filter(person -> person.getFirstName() != null)
                .map(person -> person.getFirstName().toUpperCase())
                .toList();
    }

    public List<String> listPersonsNamesShort() {
        return persons.stream()
                .filter(person -> (person.getFirstName() != null && person.getLastName() != null))
                .map(person -> person.getFirstName() + " " + person.getLastName().charAt(0) + ".")
                .toList();
    }

    public List<Person> listPersonsBetweenTwoAges(int lowerAge, int upperAge) {
        return persons.stream()
                .filter(person -> person.getAge() != null)
                .filter(person -> person.getAge() > lowerAge && person.getAge() < upperAge)
                .toList();
    }

    public List<Person> listPersonsFirstNameStartsWithLetter(String firstLetter) {
        if (firstLetter.isBlank()) {
            return new ArrayList<>();
        } else {
            return persons.stream()
                    .filter(person -> person.getFirstName() != null)
                    .filter(person -> person.getFirstName().startsWith(firstLetter))
                    .toList();
        }
    }

    public Set<String> listUniqueFirstNames() {
        return persons.stream()
                .map(Person::getFirstName)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public List<Person> sortPersonsByFirstName() {
        return persons.stream()
                .filter(person -> person.getFirstName() != null)
                .sorted(Comparator.comparing(Person::getFirstName))
                .toList();
    }

    public List<Person> sortPersonsByLastName() {
        return persons.stream()
                .filter(person -> person.getLastName() != null)
                .sorted(Comparator.comparing(Person::getLastName))
                .toList();
    }

    public List<Person> sortPersonsByFirstNameLastNameAndAge() {
        return persons.stream()
                .filter(person -> person.getFirstName() != null && person.getLastName() != null && person.getAge() != null)
                .sorted(Comparator
                        .comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName)
                        .thenComparing(Person::getAge)
                )
                .toList();
    }
}
