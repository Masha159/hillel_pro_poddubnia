package org.lessons.lesson20.petrolStation;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(new AtomicLong(3000));

        petrolStation.doRefuel(1000);
        petrolStation.doRefuel(200);
        petrolStation.doRefuel(300);
        petrolStation.doRefuel(400000);
        petrolStation.doRefuel(500);
        petrolStation.doRefuel(600);
        petrolStation.doRefuel(700);
        petrolStation.closePetrolStation();
    }
}
