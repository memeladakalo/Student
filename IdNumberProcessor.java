/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class IdNumberProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String idNumber;
        boolean continueFlag = true;

        while (continueFlag) {
            // Read name and ID number from the user
            System.out.print("Enter your Name: ");
            name = scanner.nextLine();

            System.out.print("Enter your ID Number format 'xxxxxx xxxx xxx': ");
            idNumber = scanner.nextLine();

            try {
                // Validate the ID number using isValid method
                if (isValid(idNumber)) {
                    System.out.println(name + " " + idNumber + " is valid");
                }
            } catch (IdNumberException e) {
                // Catch and print the exception message
                System.out.println(name + " " + idNumber + ": " + e.getMessage());
            }

            // Ask the user if they want to continue
            System.out.print("Continue? (y/n): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                continueFlag = false;
            }
        }

        scanner.close();
    }

    // Static method to validate the ID number
    public static boolean isValid(String id) throws IdNumberException {
        // Check if the ID length is 15
        if (id.length() != 15) {
            throw new IdNumberException("Wrong number of characters");
        }

        // Check for spaces in the wrong spots
        if (id.charAt(6) != ' ' || id.charAt(11) != ' ') {
            throw new IdNumberException("Spaces in the wrong spots");
        }

        // Check if all other characters are digits
        for (int i = 0; i < id.length(); i++) {
            if (i != 6 && i != 11) {
                if (!Character.isDigit(id.charAt(i))) {
                    throw new IdNumberException("Non-digit character found");
                }
            }
        }

        // If all checks passed, return true
        return true;
    }
}
    

