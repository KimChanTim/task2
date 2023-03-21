import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")), 8192))) {
            Parser parser = new Parser(scanner);
            parser.parse();
            parser.printNames();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}