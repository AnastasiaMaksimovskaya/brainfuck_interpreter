package ua.com.test;

public class Interpreter {

    int position = 0;
    private final int LENGTH = 30000;
    byte[] memory = new byte[LENGTH];
    StringBuilder output = new StringBuilder();

    public String interpret(String input) {
        for (int j = 0; j < input.length(); j++) {
            switch (input.charAt(j)) {
                case '>':
                    position++;
                    break;
                case '<':
                    position--;
                    break;
                case '+':
                    memory[position]++;
                    break;
                case '-':
                    memory[position]--;
                    break;
                case '[':
                    if (memory[position] == 0) {
                        String substr = input.substring(j);
                        j += substr.indexOf(']') + 1;
                    }
                    break;
                case ']':
                    if (memory[position] != 0) {
                        j = input.substring(0, j).lastIndexOf('[');
                    }
                    break;
                case '.':
                    if (memory[position] == 10) {
                        break;
                    }
                    output.append((char) memory[position]);
                    break;
            }
        }
        return output.toString();
    }
}
