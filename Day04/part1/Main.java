import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Path path = Paths.get("input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            int result = lines.mapToInt(Main::processLine)
                    .sum();
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int processLine(String line) {
        String[] cardLotteryTuple = line.split("\\|");
        Card card = Card.fromString(cardLotteryTuple[0]);
        Lottery lottery = Lottery.fromString(cardLotteryTuple[1]);

        int winningCounter = lottery.countLotteryWinnings(card);

        return winningCounter != 0 ? (int) Math.pow(2, winningCounter - 1) : 0;
    }
}

