package tij.chapter17_stander_io;//package stander_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OSExecute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        command(scanner.nextLine());
    }

    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(
                    command.split(" ")).start();
            try (
                    BufferedReader results = new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream()));
                    BufferedReader errors = new BufferedReader(
                            new InputStreamReader(
                                    process.getErrorStream()))
            ) {
                results.lines()
                        .forEach(System.out::println);
                err = errors.lines()
                        .peek(System.err::println)
                        .count() > 0;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (err)
            throw new RuntimeException("Errors executing " + command);
    }
}
