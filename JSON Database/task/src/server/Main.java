package server;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var broker = new Broker(new Repository());

        Stream.generate(scanner::nextLine)
                .takeWhile(Predicate.not("exit"::equals))
                .map(broker)
                .forEach(System.out::println);
    }
}
