
import java.util.ArrayList;

public class ToyShop {
    private ArrayList<Toy> toys;
    public ToyShop() { toys = new ArrayList<>();
    }

    // Метод добавления игрушек в магазин
    public void add(Toy toy) {
        boolean foundToy = false;
        for (Toy t : toys) {
            if (t.getId() == toy.getId()) {
                t.setQuantity(t.getQuantity() + toy.getQuantity());
                foundToy = true;
                break;
            }
        }
        if (!foundToy) {
            toys.add(toy);
        }
    }

    // Метод изменения веса игрушек
    public void setWeight(int toyId, double weight) {
        for (Toy t : toys) {
            if (t.getId() == toyId) {
                t.setWeight(weight);
                break;
            }
        }
    }

    // Метод получения списка игрушек с их атрибутами (id, название
    public ArrayList<String> getToyList() {
        ArrayList<String> toyList = new ArrayList<>();
        for (Toy t : toys) {
            toyList.add("ID: " + t.getId() + " Название: " + t.getName());
        }
        return toyList;
    }
}
