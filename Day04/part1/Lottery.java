import java.util.Arrays;
import java.util.List;

record Lottery(List<Integer> winningNumbers) {
    public static Lottery fromString(String line) {
        String[] numbers = line.split(" ");
        List<Integer> winningNumbers = Arrays.stream(numbers).filter(number -> !number.isEmpty()).map(Integer::valueOf).toList();
        return new Lottery(winningNumbers);
    }

    public int countLotteryWinnings(Card card) {
        return (int) card.pickedNumbers().stream().filter(winningNumbers::contains).count();
    }
}
