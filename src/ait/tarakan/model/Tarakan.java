package ait.tarakan.model;

import ait.tarakan.TarakanRaceAppl;

public class Tarakan implements Runnable {
    String name;
    int distance;
    int sleepTime;

    public Tarakan(String name, int distance, int sleepTime) {
        this.name = name;
        this.distance = distance;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.println(name + Thread.currentThread().getName());

        for (int i = 0; i < distance; i++) {
            System.out.println(name + " on a distance " + (i + 1));

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " finished");

        TarakanRaceAppl.setWinner(name);
    }
}
