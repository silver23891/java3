package gb.lesson5;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));

            race.getPreparationLatch().countDown();
            System.out.println(this.name + " готов");
            race.getPreparationLatch().await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            race.getFinishLatch().countDown();
            if (!race.haveWinner().get()) {
                race.setHaveWinner();
                System.out.println(name + " победитель!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
