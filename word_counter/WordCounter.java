import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter text Ctrl+D on Linux/Unix, Ctrl+Z on Windows to end): ");

        StringBuilder inputText = new StringBuilder();

        while (scan.hasNextLine()) {
            inputText.append(scan.nextLine()).append("\n");
        }

        int wordCount = countWords(inputText.toString());
        int charCount = countCharacters(inputText.toString());
        int lineCount = countLines(inputText.toString());

        System.out.println("Word count: " + wordCount);
        System.out.println("Character count: " + charCount);
        System.out.println("Line count: " + lineCount);   
        
        scan.close();
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s");
        return words.length;
    }

    private static int countCharacters(String text) {
        return text.length();
    }

    private static int countLines(String text) {
        String[] lines = text.split("\n");
        return lines.length;
    }
}