package server;

import java.util.function.UnaryOperator;

public record Broker(Repository repository) implements UnaryOperator<String> {

    @Override
    public String apply(final String request) {
        var args = request.split("\\s+", 3);
        var key = Integer.parseInt(args[1]);
        return switch (args[0]) {
            case "get" -> repository().get(key);
            case "delete" -> repository().delete(key);
            case "set" -> repository().set(key, args[2]);
            default -> Repository.ERROR;
        };
    }
}
