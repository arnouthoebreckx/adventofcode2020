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

    public List<Password> parse() {
        List<Password> result = new ArrayList<>();
        try {
            String curr;
            FileReader reader = new FileReader(input);
            BufferedReader bufReader = new BufferedReader(reader);
            while((curr = bufReader.readLine()) != null) {
                String[] spaceSplit = curr.split(" ");
                int min = Integer.parseInt(spaceSplit[0].split("-")[0]);
                int max = Integer.parseInt(spaceSplit[0].split("-")[1]);
                char c = spaceSplit[1].charAt(0);
                String pass = spaceSplit[2];
                result.add(new Password(min, max, c, pass));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
