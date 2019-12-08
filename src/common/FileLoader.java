package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLoader {

    /**
     * loads a comma separated file of numbers into an ArrayList of integers
     *
     * @param path path of the file to load
     * @return ArrayList of Integers in the file
     */
    public static ArrayList<Integer> loadCommaFile(String path) {
        ArrayList<Integer> codeList = new ArrayList<>();
        String bigToke;
        String[] tokens;

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            while ((bigToke = in.readLine()) != null) {
                for (int i = 0; i < (tokens = bigToke.split(",")).length; i++) {
                    codeList.add(Integer.parseInt(tokens[i]));
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load File");
            e.printStackTrace();
        }

        return codeList;
    }

    /**
     * loads a line separated file of numbers into an ArrayList of integers
     *
     * @param path path of the file to load
     * @return ArrayList of Integers in the file
     */
    public static ArrayList<Integer> loadNewLineFile(String path) {
        ArrayList<Integer> codeList = new ArrayList<>();
        String token;

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            while ((token = in.readLine()) != null) {
                codeList.add(Integer.parseInt(token));
            }
        } catch (IOException e) {
            System.err.println("Failed to load File");
            e.printStackTrace();
        }

        return codeList;
    }
}
