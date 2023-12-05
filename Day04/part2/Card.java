import java.util.Arrays;
import java.util.List;

record Card(int id, List<Integer> pickedNumbers) {
    public static Card fromString(String line) {
        String[] prefixNumbersTuple = line.split(":");
        int id = getIdFromPrefix(prefixNumbersTuple[0]);
        List<Integer> numbers = getNumbersFromString(prefixNumbersTuple[1]);
        return new Card(id, numbers);
    }

    private static List<Integer> getNumbersFromString(String line) {
        String[] numbers = line.split(" ");
        return Arrays.stream(numbers).filter(number -> !number.isEmpty()).map(Integer::valueOf).toList();
    }

    private static int getIdFromPrefix(String prefix) {
        String[] parsedPrefix = prefix.split(" ");
        String number = parsedPrefix[parsedPrefix.length - 1];
        return Integer.parseInt(number);
    }
}
