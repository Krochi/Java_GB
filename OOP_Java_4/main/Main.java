package main;

import model.FamilyTree;
import model.Person;
import service.FileOperations;
import service.FileOperationsImpl;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        
        // Создание и добавление людей в дерево
        Person john = new Person("John", 1950);
        Person mary = new Person("Mary", 1955);
        Person susan = new Person("Susan", 1980);
        susan.setMother(mary);
        susan.setFather(john);
        john.addChild(susan);
        mary.addChild(susan);
        
        familyTree.addMember(john);
        familyTree.addMember(mary);
        familyTree.addMember(susan);

        CommandManager commandManager = new CommandManager(familyTree);
        commandManager.start();
    }
}
