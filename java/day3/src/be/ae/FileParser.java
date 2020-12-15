package be.ae;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.util.*;
import java.io.File;

public class FileParser {
    File input;

    public FileParser(File input) {
        this.input = input;
    }

    public List<String[]> parse() {
        List<String[]> main = new ArrayList<>();
        try {
            String curr;
            FileReader reader = new FileReader(input);
            BufferedReader bufReader = new BufferedReader(reader);
            while((curr = bufReader.readLine()) != null) {
                String[] row = curr.split("");
                main.add(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return main;
    }
}
