
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Main {
    private final static String WILD_CARD = ".";
    private final static char GEAR = '*';

    public static void main(String[] args) {
        Path path = Paths.get("input.txt");

        try (Stream<String> lineStream = Files.lines(path)) {
            List<String> lines = lineStream.toList();
            List<String> paddedLines = padLines(lines);
            Map<Gear, Integer> gearProductMap = new HashMap<>();

            for (int i = 2; i < paddedLines.size(); i++) {
                List<String> rows = IntStream.rangeClosed(i - 2, i).mapToObj(paddedLines::get).toList();
                String mainRow = rows.get(1);
                int j = 0;
                while (j < mainRow.length()) {
                    int current = 0;
                    Optional<Gear> gear = Optional.empty();

                    while (j < mainRow.length() && Character.isDigit(mainRow.charAt(j))) {
                        current = current * 10 + (mainRow.charAt(j) - '0');
                        gear = Stream.of(
                                gear,
                                hasPrevGear(j, rows, i),
                                hasNextGear(j, mainRow.length(), rows, i),
                                hasTopOrBottomGear(j, rows, i)
                        ).filter(Optional::isPresent).map(Optional::get).findFirst();

                        j++;
                    }

                    if (gear.isPresent()) {
                        gearProductMap.merge(gear.get(), -1 * current, (a, b) -> a * b);
                    }
                    j++;
                }
            }
            var result = gearProductMap.values().stream().filter(value -> value > 0).mapToInt(x -> x).sum();

            System.out.println(result);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> padLines(List<String> lines) {
        String emptyLine = WILD_CARD.repeat(lines.get(0).length());
        List<String> paddedLines = new ArrayList<>();
        paddedLines.add(emptyLine);
        paddedLines.addAll(lines);
        paddedLines.add(emptyLine);
        return paddedLines;
    }

    private static Optional<Gear> hasTopOrBottomGear(int j, List<String> rows, int i) {
        return getGear(rows, j, i);
    }

    private static Optional<Gear> hasPrevGear(int j, List<String> rows, int i) {
        int prevIndex = j - 1;
        if (prevIndex < 0) return Optional.empty();
        return getGear(rows, prevIndex, i);
    }

    private static Optional<Gear> hasNextGear(int j, int length, List<String> rows, int i) {
        int nextIndex = j + 1;
        if (nextIndex >= length) return Optional.empty();
        return getGear(rows, nextIndex, i);
    }

    private static Optional<Gear> getGear(List<String> rows, int index, int i) {
        return IntStream.range(0, rows.size()).filter(rowIndex -> isGear(rows.get(rowIndex).charAt(index))).mapToObj(x -> new Gear(x + i, index)).findFirst();
    }

    private static boolean isGear(char c) {
        return c == GEAR;
    }
}
