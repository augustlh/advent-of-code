4import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class day4 {
    public static void part1() throws Exception {
        String[] content = new String(Files.readAllBytes(Paths.get("day4.txt"))).split("\n");
        char[][] contents = new char[content.length][content[0].length()];

        int res = 0;

        for(int i = 0; i < content.length; i++) {
            contents[i] = content[i].toCharArray();
        }

        for(int row = 0; row < contents.length; row++) {
            for(int col = 0; col < contents[row].length; col++) {
                if(horizontal(contents[row], col)) {
                    res++;
                }

                if(vertical(contents, row, col)) {
                    res++;
                } 

                if(rightdiagonal(contents, row, col)) {
                    res++;
                }
                
                if(leftdiagonal(contents, row, col)) {
                    res++;
                }
            }
        }
        
        System.out.println("Result: " + res);

    }
    
    public static void part2() throws Exception {
        String[] content = new String(Files.readAllBytes(Paths.get("day4.txt"))).split("\n");
        char[][] contents = new char[content.length][content[0].length()];

        
        for(int i = 0; i < content.length; i++) {
            contents[i] = content[i].toCharArray();
        }
        
        int res = 0;
                
        for(int row = 0; row < contents.length; row++) {
            for(int col = 0; col < contents[row].length; col++) {
                if(x_mas_diagonal(contents, row, col)) {
                    res++;
                }
            }
        }
        
        System.out.println("Result: " + res);

    }
    
    private static boolean x_mas_diagonal(char[][] content, int row, int col) {
        return x_mas_rightdiagonal(content, row, col) && x_mas_leftdiagonal(content, row, col);
    }
    
    private static boolean x_mas_rightdiagonal(char[][] content, int row, int col) {
        if(row - 1 < 0 || row + 1 >= content.length || col - 1 < 0 || col + 1 >= content[0].length) {
            return false;
        }
        
        if(content[row][col] == 'A' && content[row-1][col-1] == 'M' && content[row+1][col+1] == 'S' || content[row][col] == 'A' && content[row-1][col-1] == 'S' && content[row+1][col+1] == 'M') {
            return true;
        }
        
        return false;
    }
    
        private static boolean x_mas_leftdiagonal(char[][] content, int row, int col) {
        if(row + 1 >= content.length || col - 1 < 0 || col + 1 >= content[0].length || row - 1 < 0) {
            return false;
        }
        
        if(content[row][col] == 'A' && content[row+1][col-1] == 'M' && content[row-1][col+1] == 'S' || content[row][col] == 'A' && content[row+1][col-1] == 'S' && content[row-1][col+1] == 'M') {
            return true;
        }        
        return false;
    }

    private static boolean horizontal(char[] content, int i) {
        if(i+3 >= content.length) {
            return false;
        }

        if(content[i] == 'X' && content[i+1] == 'M' && content[i+2] == 'A' && content[i+3] == 'S' || content[i] == 'S' && content[i+1] == 'A' && content[i+2] == 'M' && content[i+3] == 'X') {
            System.out.println("horizontal cook");
            return true;
        }

        return false;
    }

    private static boolean vertical(char[][] content, int row, int col) {
        if(row + 3 >= content.length) {
            return false;
        }

        if(content[row][col] == 'X' && content[row+1][col] == 'M' && content[row+2][col] == 'A' && content[row+3][col] == 'S' || content[row][col] == 'S' && content[row + 1][col] == 'A' && content[row + 2][col] == 'M' && content[row + 3][col] == 'X') {
            System.out.println("vertical cook");
            return true;
        }

        return false;
    }

    private static boolean rightdiagonal(char[][] content, int row, int col) {
        if(col + 3 >= content[0].length || row + 3 >= content.length) {
            return false;
        }

        if(content[row][col] == 'X' && content[row+1][col+1] == 'M' && content[row+2][col+2] == 'A' && content[row+3][col+3] == 'S' || content[row][col] == 'S' && content[row+1][col+1] == 'A' && content[row+2][col+2] == 'M' && content[row+3][col+3] == 'X') {
            System.out.println("Right diagonal cook");
            return true;
        }
        
        return false;
    }

    private static boolean leftdiagonal(char[][] content, int row, int col) {
        if(col - 3 < 0 || row + 3 >= content.length) {
            return false;
        }

        if(content[row][col] == 'X' && content[row+1][col-1] == 'M' && content[row+2][col-2] == 'A' && content[row+3][col-3] == 'S' || content[row][col] == 'S' && content[row+1][col-1] == 'A' && content[row+2][col-2] == 'M' && content[row+3][col-3] == 'X') {
            System.out.println("Left diagonal cook");
            return true;
        }

        return false;
    }
}
