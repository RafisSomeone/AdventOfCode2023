import java.util.Arrays;
import java.util.stream.Collectors;

public record Round(int redCounter, int blueCounter, int greenCounter) {
    public static Round fromStringArray(String[] strings) {
        var colorMap = Arrays.stream(strings)
                .map(String::trim)
                .map(round -> round.split(" "))
                .collect(Collectors.toMap(part -> Color.valueOf(part[1].toUpperCase()), part -> Integer.parseInt(part[0]), Integer::sum));

        return new Round(colorMap.getOrDefault(Color.RED, 0), colorMap.getOrDefault(Color.BLUE, 0), colorMap.getOrDefault(Color.GREEN, 0));
    }
}
