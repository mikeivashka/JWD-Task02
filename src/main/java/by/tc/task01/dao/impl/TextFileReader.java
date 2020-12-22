package by.tc.task01.dao.impl;

import by.tc.task01.dao.AbstractFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

class TextFileReader extends AbstractFileReader {

    private final BufferedReader reader;


    TextFileReader(String path) throws FileNotFoundException {
        super(path);
        reader = new BufferedReader(new FileReader(path));
    }

    public List<String> linesList() {
        return reader.lines().collect(Collectors.toList());
    }
}
