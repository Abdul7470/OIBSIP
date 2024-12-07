import javax.swing.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int targetNumber = (int) (Math.random() * 100 + 1);
        int userGuess = 0;
        int attempts = 1;

        try {
            while (userGuess != targetNumber) {
                String input = JOptionPane.showInputDialog(null, "Guess a number between 1 and 100:");
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game exited. Thanks for playing!");
                    return; // Exit if user cancels
                }

                userGuess = Integer.parseInt(input);
                JOptionPane.showMessageDialog(null, generateFeedback(userGuess, targetNumber, attempts));
                attempts++;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.");
        }
    }

    public static String generateFeedback(int guess, int target, int attempt) {
        if (guess <= 0 || guess > 100) {
            return "Invalid guess! Please enter a number between 1 and 100.";
        } else if (guess == target) {
            return "          🎉 Congratulations!\n You've guessed the correct number!\n                Attempts: " + attempt;
        } else if (Math.abs(guess - target) <= 3) {
            return "🔥 You're very close! Keep going!\n              Attempt: " + attempt;
        } else if (guess > target) {
            return "📈 Too high! Try a lower number.\n              Attempt: " + attempt;
        } else {
            return "📉 Too low! Try a higher number.\n              Attempt: " + attempt;
        } 
    }
}
