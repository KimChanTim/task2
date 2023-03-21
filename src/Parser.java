import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {
    private final Scanner scanner;
    private Map<String, Integer> namesMap;

    public Parser(Scanner scanner) {
        this.scanner = scanner;
    }
    private void parseAdd() throws IOException {
        String name;
        if (scanner.hasNext()) {
            name = scanner.next();
        } else {
            throw new IOException("missing name");
        }

        if (scanner.hasNextInt()) {
            namesMap.put(name, namesMap.getOrDefault(name, 0) + scanner.nextInt());
        } else {
            throw new IOException("missing number");
        }
    }
    private void parseSub() throws IOException {
        String name;
        if (scanner.hasNext()) {
            name = scanner.next();
        } else {
            throw new IOException("missing name");
        }

        if (scanner.hasNextInt()) {
            namesMap.put(name, namesMap.getOrDefault(name, 0) - scanner.nextInt());
        } else {
            throw new IOException("missing number");
        }
    }
    private void parseDel() throws IOException {
        if (scanner.hasNext()) {
            namesMap.replace(scanner.next(), 0);
        } else {
            throw new IOException("missing name");
        }
    }
    public void parse() throws IOException {
        namesMap = new HashMap<>();

        while (scanner.hasNext()) {

            String word = scanner.next();
            switch (word) {
                case "add" -> {
                    parseAdd();
                }
                case "sub" -> {
                    parseSub();
                }
                case "del" -> {
                    parseDel();
                }
                default -> throw new IOException("undefined operation");
            }
        }
    }

    public void printNames() {
        System.out.println(namesMap);
    }
}
