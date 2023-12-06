package ait.tarakan;

import ait.tarakan.model.Tarakan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TarakanRaceAppl {
    static int minSleepTime = 2;
    static int maxSleepTime = 5;
    static String winner;
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException, IOException {
        int sleepTime = minSleepTime + random.nextInt((maxSleepTime + 1) - minSleepTime);
        System.out.println();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numbers of tarakans:");
        int tarakansQuantity = Integer.parseInt(br.readLine());
        System.out.println("Enter distance:");
        int distance = Integer.parseInt(br.readLine());
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i < tarakansQuantity + 1; i++) {
            threads.add(new Thread(new Tarakan("tarakan#" + i, distance, sleepTime)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Congratulations to " + winner);
    }

    public static void setWinner(String name) {
        if (winner == null) winner = name;
    }
}