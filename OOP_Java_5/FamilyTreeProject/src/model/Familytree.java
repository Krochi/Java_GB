package model;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T> {
    private List<T> members = new ArrayList<>();

    public void addMember(T person) {
        members.add(person);
    }

    public List<T> getMembers() {
        return members;
    }

    public void sortByName() {
        // Логика сортировки по имени
    }

    public void sortByBirthYear() {
        // Логика сортировки по году рождения
    }
}
