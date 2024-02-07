import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        if(args==null || args.length!=1){
            System.out.println("Unknown argument");
            return;
        }
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader scanner =new BufferedReader(
                                        new InputStreamReader(
                                        new FileInputStream("students.txt")));
                String lines = scanner.readLine();
                String words[] = lines.split(",");
                for (String word : words) {
                    System.out.println(word);
                }
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader scanner = new BufferedReader(
                                   new InputStreamReader(
                                   new FileInputStream("students.txt")));
                String line = scanner.readLine();
                // System.out.println(line);
                String words [] = line.split(",");
                Random random = new Random();
                int randomNumber = random.nextInt(words.length);
                System.out.println(words[randomNumber]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter scanner = new BufferedWriter(new FileWriter("students.txt", true));
                String newElement = args[0].substring(1);
                Date date = new Date();
                String dateformate = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateformate);
                String presetDate = dateFormat.format(date);
                scanner.write(", " + newElement + "\nList last updated on " + presetDate);
                scanner.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader scanner = new BufferedReader(
                                         new InputStreamReader(
                                         new FileInputStream("students.txt")));
                String line = scanner.readLine();
                String words [] = line.split(",");
                boolean done = false;
                String target = args[0].substring(1);
                for (int index = 0; index < words.length && !done; index++) {
                    if (words[index].equals(target)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader scanner =new BufferedReader(
                                        new InputStreamReader(
                                        new FileInputStream("students.txt")));
                String line = scanner.readLine();
                char characters [] = line.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char character : characters) {
                    if (character == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + characters.length);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
    }
}