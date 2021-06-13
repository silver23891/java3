package gb.lesson5.RaceStages;

import gb.lesson5.Race;

public abstract class RaceStage {
    protected Race race;

    public RaceStage(Race race) {
        this.race = race;
    }

    public abstract void printInfo();
    public abstract void nextStage();
}
