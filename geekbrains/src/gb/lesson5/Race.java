package gb.lesson5;

import gb.lesson5.RaceStages.Preparation;
import gb.lesson5.RaceStages.RaceStage;
import gb.lesson5.stages.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class Race {
    private RaceStage raceStage = new Preparation(this);
    private ArrayList<Stage> stages;

    private CountDownLatch preparationLatch = new CountDownLatch(MainClass.CARS_COUNT);
    private CountDownLatch finishLatch = new CountDownLatch(MainClass.CARS_COUNT);
    private AtomicBoolean haveWinner = new AtomicBoolean(false);

    public RaceStage getRaceStage() {
        return raceStage;
    }

    public void setRaceStage(RaceStage raceStage) {
        this.raceStage = raceStage;
    }

    public ArrayList<Stage> getStages() { return stages; }

    public CountDownLatch getPreparationLatch() {
        return preparationLatch;
    }

    public CountDownLatch getFinishLatch() {
        return finishLatch;
    }

    public AtomicBoolean haveWinner() {
        return haveWinner;
    }

    public void setHaveWinner() {
        this.haveWinner.set(true);
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}