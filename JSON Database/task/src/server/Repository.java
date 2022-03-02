package server;

public class Repository {
    private static final int MAX = 100;
    public static final String OK = "OK";
    public static final String ERROR = "ERROR";

    private final String[] database = new String[MAX];

    public String set(int key, String value) {
        if (isValidKey(key)) {
            int index = key - 1;
            database[index] = value;
            return OK;
        } else {
            return ERROR;
        }
    }

    public String get(int key) {
        if (isValidKey(key) && database[key - 1] != null) {
            return database[key - 1];
        } else {
            return ERROR;
        }
    }

    public String delete(int key) {
        if (isValidKey(key)) {
            database[key - 1] = null;
            return OK;
        }
        return ERROR;
    }

    private boolean isValidKey(int key) {
        return key > 0 && key <= MAX;
    }
}
