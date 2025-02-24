package lesson16;

public class RandomNumberGenerator {
    static int generateRandomNumber(int min, int max){
        int randomNumber = (int)(Math.random() * (max - min + 1)) + min;
        return randomNumber;
    }
}
