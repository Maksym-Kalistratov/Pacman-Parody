package Other;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyList {
    private static List<Record> save = new ArrayList<>();

    static {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/save_records.ser"))) {
            save = (List<Record>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) { //itelij idea reccomended adding ClassNotFoundException
            e.printStackTrace();
        }
    }

    public static void add(Record record) {
        save.add(record);
        save.sort(null);
    }


    public static List<Record> getData() {
        return new ArrayList<>(save);
    }


    public static void remove(int index) {
        save.remove(index);
    }

    public static void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/save_records.ser"))) {
            oos.writeObject(save);
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
}