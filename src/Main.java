import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class Main {
    private static final String FILENAME = "toys5.csv";
    public static void main(String[] args) {
        try { ToyShop shop = new ToyShop();
            File toyFile = new File(FILENAME);
                if (!toyFile.exists()) { toyFile.createNewFile();
                    shop.add(new Toy(1, "Кукла Барби", 5, 20));
                    shop.add(new Toy(2, "Машинка Хот Вилс", 3, 15));
                    shop.add(new Toy(3, "Мишка Тедди", 10, 10));
                    shop.saveToFile(FILENAME);
                } else {
                    shop.loadFromFile(FILENAME); }
                shop.setWeight(1, 15); // тут можно изменить вес отдельной игрушки номер по id

            ArrayList<String> toyList = shop.getToyList(); // получить список игрушек в магазине
            for (String toy : toyList) {
                System.out.println(toy);
            }

        ArrayList<Toy> winners = shop.playGame(3); // Разыграть игрушки

        System.out.println("Выиграли следующие игрушки:");
        for (Toy t : winners) {
            System.out.println(t.getName());
        }

        shop.saveToFile(FILENAME);       // сохранить данные об игрушках
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}