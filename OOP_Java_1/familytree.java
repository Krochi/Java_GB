import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getChildren(Person person) {
        return person.getChildren();
    }

    public List<Person> getSiblings(Person person) {
        List<Person> siblings = new ArrayList<>();
        if (person.getMother() != null) {
            for (Person sibling : person.getMother().getChildren()) {
                if (!sibling.equals(person)) {
                    siblings.add(sibling);
                }
            }
        }
        return siblings;
    }
}

