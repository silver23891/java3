package gb.lesson5.RaceStages;

import gb.lesson5.Race;

public class Preparation extends RaceStage{
    public Preparation(Race race) {
        super(race);
    }

    @Override
    public void printInfo() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    }

    @Override
    public void nextStage() {
        race.setRaceStage(new Running(race));
        race.getRaceStage().printInfo();
    }
}
