import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileOperations<FamilyTree> fileOperations = new FileOperations<>();
        
        // Создание объектов для сохранения
        Person person1 = new Person("Иван", 30);
        Person person2 = new Person("Маша", 28);
        FamilyTree familyTree = new FamilyTree(Arrays.asList(person1, person2));

        // Сохранение объекта в файл
        String filePath = "familyTree.ser";
        try {
            fileOperations.saveToFile(familyTree, filePath);
            System.out.println("Данные успешно сохранены в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении файла: " + e.getMessage());
        }

        // Загрузка объекта из файла
        try {
            FamilyTree loadedFamilyTree = fileOperations.loadFromFile(filePath);
            System.out.println("Загруженные данные: " + loadedFamilyTree);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке файла: " + e.getMessage());
        }
    }
}
