package ua.com.test;

import java.util.Scanner;

public class Reader {

    private final Scanner scanner = new Scanner(System.in);
    StringBuilder stringBuilder = new StringBuilder();

    public String read() {
        while (true) {
            String currentLine = scanner.nextLine();
            if (currentLine.equals("")) {
                break;
            } else stringBuilder.append(currentLine);
        }
        return stringBuilder.toString();
    }
}
