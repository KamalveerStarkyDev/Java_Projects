import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int length = scan.nextInt();

        System.out.print("Include number ? (yes/no): ");
        boolean includeNumbers = scan.next().equalsIgnoreCase("yes");

        System.out.println("Include special characters? (yes/no): ");
        boolean includeSpecialCharacters = scan.next().equalsIgnoreCase("yes");

        String generatePassword = generatePassword( length, includeNumbers, includeSpecialCharacters);
        System.out.println("Generated Password: " + generatePassword);
    } 

    private static String generatePassword(int length, boolean includeNumbers, boolean includeSpecialCharacters){
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()_-+=<>?";

        StringBuilder validChars = new StringBuilder(uppercaseLetters + lowercaseLetters);

        if (includeNumbers) {
            validChars.append(numbers);
        }

        if (includeSpecialCharacters) {
            validChars.append(specialCharacters);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}