package gb.lesson5.RaceStages;

import gb.lesson5.Race;

public class Finished extends RaceStage{
    public Finished(Race race) {
        super(race);
    }

    @Override
    public void printInfo() {
        try {
            race.getFinishLatch().await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nextStage() {

    }
}
