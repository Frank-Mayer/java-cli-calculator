package io.frankmayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Float.parseFloat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern cmdPattern = Pattern.compile("^\\s*(\\d+|\\d+[,.]\\d+)\\s*([*+-/])\\s*(\\d+|\\d+[,.]\\d+)\\s*$");
        String command = "";

        while (true) {
            command = reader.readLine();
            Matcher matcher = cmdPattern.matcher(command);
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("bye");
                break;
            } else if (!matcher.matches()) {
                System.out.println("Syntax error");
            } else {
                Float a = parseFloat(matcher.group(1));
                String operator = matcher.group(2);
                Float b = parseFloat(matcher.group(3));

                System.out.printf("%s %s %s = ", a, operator, b);

                switch (operator) {
                    case "+":
                        System.out.println(a + b);
                        break;
                    case "-":
                        System.out.println(a - b);
                        break;
                    case "*":
                        System.out.println(a * b);
                        break;
                    case "/":
                        System.out.println(a / b);
                        break;
                }
            }
        }
    }
}
