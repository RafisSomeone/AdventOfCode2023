import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Path path = Paths.get("input.txt");
        try (Stream<String> linesStream = Files.lines(path)) {
            var result = linesStream.map(Game::fromString)
                    .mapToInt(Game::getMinimalNumberOfCubesProduct)
                    .sum();
            System.out.println(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
