import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Создаем людей
        Person john = new Person("John", 1980);
        Person mary = new Person("Mary", 1985);
        Person anna = new Person("Anna", 2010);
        Person tom = new Person("Tom", 2012);

        // Устанавливаем родительские связи
        anna.setMother(mary);
        anna.setFather(john);
        tom.setMother(mary);
        tom.setFather(john);

        // Добавляем детей
        john.addChild(anna);
        john.addChild(tom);
        mary.addChild(anna);
        mary.addChild(tom);

        // Создаем генеалогическое древо
        FamilyTree tree = new FamilyTree();
        tree.addPerson(john);
        tree.addPerson(mary);
        tree.addPerson(anna);
        tree.addPerson(tom);

        // Находим человека по имени и выводим его детей
        Person foundPerson = tree.findPersonByName("John");
        if (foundPerson != null) {
            System.out.println("Children of John:");
            for (Person child : tree.getChildren(foundPerson)) {
                System.out.println(child.getName());
            }
        }

        // Получаем братьев и сестер
        List<Person> siblings = tree.getSiblings(anna);
        System.out.println("Siblings of Anna:");
        for (Person sibling : siblings) {
            System.out.println(sibling.getName());
        }
    }
}
