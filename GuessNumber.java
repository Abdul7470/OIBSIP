import javax.swing.*;

public class GuessNumber {
    public static void main(String[] args) {
        int System_num = (int) (Math.random() * 100 + 1);
        int User_input = 0;
        int count = 1;
        try {
            while (User_input !=  System_num) {
                String response = JOptionPane.showInputDialog(null, " GUESS THE NUMBER (1 - 100)");
                User_input = Integer.parseInt(response);
                JOptionPane.showMessageDialog(null, " " + determineGuess(User_input,  System_num, count));
                count++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static String determineGuess(int User_input , int  System_num , int count)
    {
        if (User_input <= 0 || User_input > 100) {
            return "Your guess is invalid";
        } else if (User_input ==  System_num) {
            return " GREAT : ) \n you guessed it!! \n Total Guesses : " + count;
        } else if (User_input <=  System_num + 3 && User_input >=  System_num - 3) {
            return " You're so close!  Almost there! \n Try Number :  " + count;
        } else if (User_input >  System_num) {
            return "        A bit too high \n  Try lowering your guess! \n        Try Number : " + count;
        } else if (User_input <  System_num) {
            return "        A bit too low \n  Try raising your guess! \n         Try Number :  " + count;
        } else {
            return "Your guess is incorrect \n Try Number : " + count;
        }
    }
}