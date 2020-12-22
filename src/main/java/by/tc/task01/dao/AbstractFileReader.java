package by.tc.task01.dao;

public abstract class AbstractFileReader {
    private final String fileName;

    protected AbstractFileReader(String fileName) {
        this.fileName = fileName;
    }
}
