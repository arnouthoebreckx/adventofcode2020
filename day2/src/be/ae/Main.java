package be.ae;

import java.util.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here
        File input = new File("C:\\Users\\ArnoutHoebreckx\\git-repos\\adventofcode2020\\day2\\src\\be\\ae\\input.txt");
        FileParser fileParser = new FileParser(input);
        List<Password> passwordList = fileParser.parse();
        long validCount = passwordList.stream().map(Password::isValid).filter(e -> e).count();
        long validCount2 = passwordList.stream().map(Password::isValid2).filter(e -> e).count();
        System.out.println("Amount of valid passwords: " + validCount);
        System.out.println("Amount of real valid passwords: " + validCount2);
    }
}
