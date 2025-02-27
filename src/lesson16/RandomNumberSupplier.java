package lesson16;

import java.util.function.Supplier;

public class RandomNumberSupplier implements Supplier<Integer> {

    @Override
    public Integer get() {
        return RandomNumberGenerator.generateRandomNumber(1, 100);
    }
}
