import java.util.Arrays;
import java.util.List;

record Game(int id, List<Round> rounds) {

    public static Game fromString(String line) {
        String[] prefixRoundsTuple = line.split(":");
        int id = extractId(prefixRoundsTuple[0]);
        List<Round> rounds = extractRounds(prefixRoundsTuple[1]);

        return new Game(id, rounds);
    }

    private static int extractId(String linePrefix) {
        String id = linePrefix.substring(4).trim();
        return Integer.parseInt(id);
    }

    private static List<Round> extractRounds(String rounds) {
        return Arrays.stream(rounds.split(";"))
                .map(round -> round.split(","))
                .map(Round::fromStringArray)
                .toList();
    }
}
