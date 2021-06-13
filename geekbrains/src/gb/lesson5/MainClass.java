package gb.lesson5;

import gb.lesson5.stages.Road;
import gb.lesson5.stages.Tunnel;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        race.getRaceStage().printInfo();
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        race.getRaceStage().nextStage();
    }
}