package be.ae;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here

        File input = new File("C:\\Users\\ArnoutHoebreckx\\git-repos\\adventofcode2020\\java\\day3\\src\\be\\ae\\input.txt");
        FileParser fileParser = new FileParser(input);
        List<String[]> field = fileParser.parse();

        int[][] tuples = {{3,1},{1,1},{5,1},{7,1},{1,2}};

        Long result = Arrays.stream(tuples).map(c -> findTrees(field, c)).reduce(1L, (a,b)-> a*b);
        System.out.println("Multiplication: " + result);

    }

    public static Long findTrees(List<String[]> field, int[] steps) {
        Long result = 0L;
        int x, y, x_step, y_step;
        x = y = 0;
        x_step = steps[0];
        y_step = steps[1];

        while (y < field.size()-1) {
            y += y_step;
            x += x_step;
            int inbounds = x % (field.get(y).length);
            if (field.get(y)[inbounds].equals("#")) {
                result+=1;
            }
        }
        System.out.println("Result: " + result);
        return result;
    }
}
