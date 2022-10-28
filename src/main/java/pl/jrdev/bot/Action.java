package pl.jrdev.bot;

import java.util.Objects;

public enum Action {
    LIST("list"), ADD("add"), DELETE("delete"), UPTDATE("update"),
    HELP("help");

    private final String value;

    Action(String value) {
        this.value = value;
    }

    public static Action of(String value) {
        for (Action action : values()) {
            if (Objects.equals(action.value, value)) {
                return action;
            }
        }
        throw new IllegalArgumentException("Unknown action: " + value);
    }

    public String getValue() {
        return value;
    }
}







