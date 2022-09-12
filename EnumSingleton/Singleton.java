package EnumSingleton;

public enum Singleton {
    INSTANCE;

    private String string = "1";

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
