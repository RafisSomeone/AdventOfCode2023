import java.nio.file.*;
import java.util.stream.Stream;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.stream.IntStream;
import java.util.OptionalInt;

class Main {

    private final static int MULTIPLIER = 10;

    public static void main(String[] args) {
        Path path = Paths.get("input.txt");
        try (Stream<String> linesStream = Files.lines(path)) {
            var result = linesStream.mapToInt(Main::processLine).sum();
            System.out.println(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static int processLine(String line) {
        int firstNumber = findFirstNumber(line).orElseThrow(() -> new IllegalStateException("This situation shouldn't ever happen"));
        int lastNumber = findLastNumber(line).orElseThrow(() -> new IllegalStateException("This situation shouldn't ever happen"));
        return firstNumber * MULTIPLIER + lastNumber;
    }

    private static OptionalInt findFirstNumber(String line) {
        return line.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .findFirst();
    }

    private static OptionalInt findLastNumber(String line) {
        return IntStream.iterate(line.length() - 1, i -> i >= 0, i -> i - 1)
                .map(line::charAt)
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .findFirst();
    }
}
