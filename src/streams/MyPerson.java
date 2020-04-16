package streams;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MyPerson extends Person {
    public MyPerson(String name) {
        super(name);
    }

    @Override
    protected int getRandomCash() {
        Random random = new Random();


        return (random.nextInt(10) + 1);
    }

    @Override
    public LocalDate getRandomBirthDate() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        return randomDate;
    }

    @Override
    public int getAge() {
        Random random = new Random();
        return (random.nextInt(80) + 1);
    }
}
