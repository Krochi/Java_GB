import java.io.*;

public class FileOperations<T> implements SerializableInterface<T> {
    
    @Override
    public void saveToFile(T obj, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(obj);
        }
    }

    @Override
    public T loadFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (T) ois.readObject();
        }
    }
}
