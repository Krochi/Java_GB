import java.io.IOException;

public interface SerializableInterface<T> {
    void saveToFile(T obj, String filePath) throws IOException;
    T loadFromFile(String filePath) throws IOException, ClassNotFoundException;
}
