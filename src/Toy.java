public class Toy {
    private int id;
    private String name;
    private double frequency;

//    Создаем конструктор и гетеры и сетеры

    public Toy(int id, String name, double frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFrequency() {
        return frequency;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

//    Создаем массив игрушек, первый массив это id, второй массив name, третий массив frequency

    int[] ids = {1, 2, 3, 4, 5};
    String[] names = {"Кукла", "Мяч", "Машинка", "Пазл", "Конструктор"};
    double[] frequencys = {0.2, 0.3, 0.1, 0.2, 0.2};

}
