import model.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import service.PersonService;

import java.util.List;

public class PersonServiceTest {

    public PersonService initializePersonService() {
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

        return new PersonService(personList);
    }

    @Test
    public void listPersonsNamesTest() {
        PersonService personService = initializePersonService();
        Assertions.assertThat(personService.listPersonsNames().size()).isEqualTo(8);
    }

    @Test
    public void listMajorPersonsTest() {
        PersonService personService = initializePersonService();
        Assertions.assertThat(personService.listMajorPersons().size()).isEqualTo(3);
    }

    @Test
    public void listPersonsFromCityTest() {
        PersonService personService = initializePersonService();
        List<String> cities = List.of("Brasov", "Oradea", "Cluj");
        Assertions.assertThat(personService.listPersonsFromCity(cities).size()).isEqualTo(4);
    }

    @Test
    public void listFirstNamesCapitalisedTest() {
        PersonService personService = initializePersonService();
        Assertions.assertThat(personService.listFirstNamesCapitalised()).contains("VLAD", "ALEXANDRU", "ANDREI");
    }

    @Test
    public void listPersonsNamesShortTest() {
        PersonService personService = initializePersonService();
        Assertions.assertThat(personService.listPersonsNamesShort().size()).isEqualTo(7);
    }

    @Test
    public void listPersonsBetweenTwoAgesTest() {
        PersonService personService = initializePersonService();
        Assertions.assertThat(personService.listPersonsBetweenTwoAges(0, 10).size()).isEqualTo(1);
    }

    @Test
    public void listPersonsFirstNameStartsWithEmptyLetterTest() {
        PersonService personService = initializePersonService();
        Assertions.assertThat(personService.listPersonsFirstNameStartsWithLetter("").size()).isEqualTo(0);
    }

    @Test
    public void listPersonsFirstNameStartsWithALetterTest() {
        PersonService personService = initializePersonService();
        Assertions.assertThat(personService.listPersonsFirstNameStartsWithLetter("A").size()).isEqualTo(4);
    }

    @Test
    public void listUniqueFirstNamesTest() {
        PersonService personService = initializePersonService();
        Assertions.assertThat(personService.listUniqueFirstNames().size()).isEqualTo(6);
    }

    @Test
    public void sortPersonsByFirstNameTest() {
        PersonService personService = new PersonService(List.of(
                new Person("Alexandru", "Lapusneanu", 77, "Iasi"),
                new Person("Mihai", "Viteazul", 17, "Cluj"),
                new Person("Iancu", "Hunedoara", 55, "Hunedoara")
        ));
        Assertions.assertThat(personService.sortPersonsByFirstName().get(2).getFirstName()).isEqualTo("Mihai");
    }

    @Test
    public void sortPersonsByLastNameTest() {
        PersonService personService = new PersonService(List.of(
                new Person("Alexandru", "Lapusneanu", 77, "Iasi"),
                new Person("Mihai", "Viteazul", 17, "Cluj"),
                new Person("Iancu", "Hunedoara", 55, "Hunedoara")
        ));
        Assertions.assertThat(personService.sortPersonsByLastName().get(2).getLastName()).isEqualTo("Viteazul");
    }

    @Test
    public void sortPersonsByFirstNameLastNameAndAgeTest() {
        PersonService personService = new PersonService(List.of(
                new Person("Alexandru", "Lapusneanu", 77, "Iasi"),
                new Person("Iancu", "Viteazul", 17, "Cluj"),
                new Person("Iancu", "Hunedoara", 55, "Hunedoara"),
                new Person("Iancu", "Hunedoara", 7, "Bucuresti")
        ));
        Assertions.assertThat(personService.sortPersonsByFirstNameLastNameAndAge().get(1).getCity()).isEqualTo("Bucuresti");
    }
}
