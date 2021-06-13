package gb.lesson5.RaceStages;

import gb.lesson5.Race;

public class Running extends RaceStage{
    public Running(Race race) {
        super(race);
    }

    @Override
    public void printInfo() {
        try {
            race.getPreparationLatch().await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            nextStage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nextStage() {
        race.setRaceStage(new Finished(race));
        race.getRaceStage().printInfo();
    }
}
