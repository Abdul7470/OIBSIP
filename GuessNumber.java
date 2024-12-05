import javax.swing.*;

public class GuessNumber {
    public static void main(String[] args) {
        int computeNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        int count = 1;
        try {
            while (userAnswer != computeNumber) {
                String response = JOptionPane.showInputDialog(null, " GUESS THE NUMBER (1 - 100)");
                userAnswer = Integer.parseInt(response);
                JOptionPane.showMessageDialog(null, " " + determineGuess(userAnswer, computeNumber, count));
                count++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static String determineGuess(int userAnswer , int computeNumber , int count)
    {
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computeNumber) {
            return " GREAT : ) \n you guessed it!! \n Total Guesses : " + count;
        } else if (userAnswer <= computeNumber + 3 && userAnswer >= computeNumber - 3) {
            return " You're so close!  Almost there! \n Try Number :  " + count;
        } else if (userAnswer > computeNumber) {
            return "        A bit too high \n  Try lowering your guess! \n        Try Number : " + count;
        } else if (userAnswer < computeNumber) {
            return "        A bit too low \n  Try raising your guess! \n         Try Number :  " + count;
        } else {
            return "Your guess is incorrect \n Try Number : " + count;
        }
    }
}