package enums;

public enum Options {
    STOP,
    START,
    CHECK,
    EXIT;

    public static boolean contains(String userOption) {

        for (Options option : Options.values()) {
            if (option.name().equals(userOption.toUpperCase()))
                return true;
        }

        return false;
    }

    public static Options getOption(String userOption) {
        return Options.valueOf(userOption.toUpperCase());
    }
}
