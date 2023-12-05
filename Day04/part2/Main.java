import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class Main {
    public static Map<Integer, Integer> cardCounter = new HashMap<>();

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

        cardCounter.merge(card.id(), 1, Integer::sum);
        int numberOfCards = cardCounter.getOrDefault(card.id(), 0);

        if (numberOfCards > 0) {
            int winningCounter = lottery.countLotteryWinnings(card);
            for (int i = card.id() + 1; i < card.id() + winningCounter + 1; i++) {
                cardCounter.merge(i, numberOfCards, Integer::sum);
            }
        }
        return numberOfCards;
    }
}

