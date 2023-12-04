import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    private final static String WILD_CARD = ".";

    public static void main(String[] args) {
        Path path = Paths.get("input.txt");

        try (Stream<String> lineStream = Files.lines(path)) {
            List<String> lines = lineStream.toList();
            List<String> paddedLines = padLines(lines);

            int sum = 0;
            for (int i = 2; i < paddedLines.size(); i++) {
                List<String> rows = IntStream.rangeClosed(i - 2, i).mapToObj(paddedLines::get).toList();
                String mainRow = rows.get(1);

                int j = 0;
                while (j < mainRow.length()) {
                    int current = 0;
                    boolean hasSymbol = false;

                    while (j < mainRow.length() && Character.isDigit(mainRow.charAt(j))) {
                        current = current * 10 + (mainRow.charAt(j) - '0');
                        if (hasPrevSymbol(j, rows) || hasNextSymbol(j, mainRow.length(), rows) || hasTopOrBottomSymbol(j, rows)) {
                            hasSymbol = true;
                        }
                        j++;
                    }

                    if (hasSymbol) {
                        sum += current;
                    }
                    j++;
                }
            }

            System.out.println(sum);
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

    private static boolean hasTopOrBottomSymbol(int j, List<String> rows) {
        return hasSymbol(j, rows);
    }


    private static boolean hasPrevSymbol(int j, List<String> rows) {
        int prevIndex = j - 1;
        if (prevIndex < 0) return false;
        return hasSymbol(prevIndex, rows);
    }

    private static boolean hasNextSymbol(int j, int length, List<String> rows) {
        int nextIndex = j + 1;
        if (nextIndex >= length) return false;
        return hasSymbol(nextIndex, rows);
    }

    private static boolean hasSymbol(int j, List<String> rows) {
        return rows.stream().map(row -> row.charAt(j)).anyMatch(Main::isSymbol);
    }

    private static boolean isSymbol(char c) {
        return c != '.' && !Character.isDigit(c);
    }
}
