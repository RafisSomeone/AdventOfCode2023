import java.nio.file.*;
import java.util.stream.Stream;
import java.util.Map;
import java.io.IOException;
import java.lang.IllegalStateException;

class Main {

    private final static int MIN_WORD_LENGTH = 3;
    private final static int MAX_WORD_LENGTH = 5;
    private final static int MULTIPLIER = 10;
    private final static Map<String, Integer> digitDict = Map.of(
            "zero", 0,
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    );

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
        return findFirstNumber(line) * MULTIPLIER + findLastNumber(line);
    }

    private static int findFirstNumber(String line) {
        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if (Character.isDigit(current)) {
                return Character.getNumericValue(current);
            }

            for (int j = MIN_WORD_LENGTH; j <= MAX_WORD_LENGTH; j++) {
                if (i + j <= line.length()) {
                    int digit = checkSubString(line, i, i + j);
                    if (digit != -1) {
                        return digit;
                    }
                }
            }
        }

        throw new IllegalStateException("This situation shouldn't ever happen");
    }

    private static int findLastNumber(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            char current = line.charAt(i);
            if (Character.isDigit(current)) {
                return Character.getNumericValue(current);
            }
            for (int j = MIN_WORD_LENGTH; j <= MAX_WORD_LENGTH; j++) {
                if (i - j >= 0) {
                    int offset = i + 1;
                    int digit = checkSubString(line, offset - j, offset);
                    if (digit != -1) {
                        return digit;
                    }
                }
            }
        }

        throw new IllegalStateException("This situation shouldn't ever happen");
    }

    private static int checkSubString(String line, int from, int to) {
        if (to <= line.length()) {
            String potentialNumber = line.substring(from, to);
            if (digitDict.get(potentialNumber) != null) {
                return digitDict.get(potentialNumber);
            }
        }
        return -1;
    }

}
