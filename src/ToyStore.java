import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ToyStore {
    private List toys = new ArrayList();
    private List prizeToys = new ArrayList();
    private Random random = new Random();
    private String filename = "toys.dat";
    public ToyStore() {
        loadToys();
    }
    public void addToy(Toy toy) {
        toys.add(toy);
        saveToys();
    }
    public void editToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                saveToys();
                break;
            }
        }
    }

    public Toy play() throws InterruptedException {
        double totalWeight = 0;
        for (Object toy : toys) {
            totalWeight += toy.wait();
        }
        double randomWeight = random.nextDouble() * totalWeight;
        double weightSum = 0;
        for (Object toy : toys) {
            weightSum += toy.wait();
            if (randomWeight <= weightSum) {
                prizeToys.add(toy);
                toy.setQuantity(toy.getQuantity() - 1);
                saveToys();
                return toy;
            }}
        return null;
    }

    public List getPrizeToys() {
        return prizeToys;
    }

    private void saveToys() {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(toys);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadToys() {
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);
                toys = (List) ois.readObject();
                ois.close();
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

