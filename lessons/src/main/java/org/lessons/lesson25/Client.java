package org.lessons.lesson25;

public class Client {
    public void run() {
        CarFactory carFactory = new CarFactory();
        PlaneFactory planeFactory = new PlaneFactory();

        Transport car = carFactory.createTransport();
        car.move();

        Transport plane = planeFactory.createTransport();
        plane.move();

        plane.stop();
        car.stop();
    }

    public static void main(String[] args) {
        new Client().run();
    }
}
