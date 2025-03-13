package lesson20.petrolStation;

public class Main {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation();
        petrolStation.setAmount(3000);
        petrolStation.doRefuel(100000);
        petrolStation.doRefuel(1000);
        petrolStation.doRefuel(300);
        petrolStation.doRefuel(500);
        petrolStation.doRefuel(1000);
        petrolStation.doRefuel(300);
        petrolStation.doRefuel(1000);
        petrolStation.closePetrolStation();
    }
}
