import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Path path = Paths.get("input.txt");
        Condition condition = new Condition(12, 13, 14);
        try (Stream<String> linesStream = Files.lines(path)) {
            var result = linesStream.map(Game::fromString)
                    .filter(condition::isGamePossible)
                    .mapToInt(Game::id)
                    .sum();
            System.out.println(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
