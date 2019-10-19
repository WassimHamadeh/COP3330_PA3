import java.util.Scanner;
import java.security.SecureRandom;

public class ComputerAssisted_Instruction
{
    private static double numCorrectAnswers = 0;
    private static double numIncorrectAnswers = 0;

    public static void cycleQuestions()
    {
        Scanner s = new Scanner(System.in);
        int i = 0;
        int dLevel = DifficultyLevel();
        int mathType = mathType();

        while (i != 10)
        {
            Questions(dLevel, mathType);
            i++;
        }
    }

    public static void askQuestion(int num1, int num2, int mathType)
    {
        System.out.println("\nWhat is " + num1 + " " + mathWord(mathType) + " " + num2 + "?\nRound to the nearest hundredth if required.\n");
    }

    public static void checkAnswer(double userNum, int num1, int num2, int mathType)
    {
        Scanner s = new Scanner(System.in);
        double correctNum = 0.0;

        switch(mathType)
        {
            case 1:
                correctNum = (num1 + num2);
                break;
            case 2:
                correctNum = (num1 - num2);
                break;
            case 3:
                correctNum = (num1 * num2);
                break;
            case 4:
                double dnum1 = num1;
                double dnum2 = num2;
                correctNum = (dnum1 / dnum2);
                correctNum = Math.round(correctNum * 100.0) / 100.0;
                break;
        }

        if (userNum != correctNum)
        {
            incorrectAnswer();
        }
        else
        {
            correctAnswer();
        }
    }

    public static void correctAnswer()
    {
        SecureRandom random = new SecureRandom();
        int comResponse = random.nextInt(4);

        switch (comResponse)
        {
            case 0:
                System.out.println("\nVery Good!");
                break;
            case 1:
                System.out.println("\nExcellent!");
                break;
            case 2:
                System.out.println("\nNice work!");
                break;
            case 3:
                System.out.println("\nKeep up the good work!");
                break;
        }

        numCorrectAnswers++;
    }

    public static void incorrectAnswer()
    {
        SecureRandom random = new SecureRandom();
        int comResponse = random.nextInt(4);

        switch (comResponse)
        {
            case 0:
                System.out.println("\nNo. Please try again.");
                break;
            case 1:
                System.out.println("\nWrong. Try once more.");
                break;
            case 2:
                System.out.println("\nDon’t give up!");
                break;
            case 3:
                System.out.println("\nNo. Keep trying.");
                break;
        }

        numIncorrectAnswers++;
    }

    public static void TestScore(double numCorrectAnswers, double numIncorrectAnswers)
    {
        double numAnswers = numCorrectAnswers + numIncorrectAnswers;
        double TotalScore = (numCorrectAnswers / numAnswers) * 100;

        System.out.println("Number of Correct Answers: " + numCorrectAnswers + "\nNumber of Incorrect Answers: " + numIncorrectAnswers + "\n");
        System.out.print("Final Score: ");
        System.out.printf("%.2f", TotalScore);
        System.out.println("%");

        if (TotalScore >= 75)
        {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
        else
        {
            System.out.println("Uh... Please ask your teacher for extra help.");
        }

    }

    public static int DifficultyLevel()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("How difficult would you like this test to be? (1-4)\nThis will be used to determine the amount of digits each number has.\n");
        int dLevel = s.nextInt();
        while (dLevel < 1 || dLevel > 4)
        {
            System.out.println("Uh... not an option. Try again.");
            dLevel = s.nextInt();
        }
        return dLevel;
    }

    public static void Questions(int dLevel, int mathType)
    {
        Scanner s = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        if (mathType == 5)
        {
            mathType = random.nextInt(4) + 1;
        }

        switch (dLevel)
        {
            case 1:
                int num1a = random.nextInt(9) + 1;
                int num1b = random.nextInt(9) + 1;
                askQuestion(num1a, num1b, mathType);
                double userNum = s.nextDouble();
                checkAnswer(userNum, num1a, num1b, mathType);
                break;

            case 2:
                int num2a = random.nextInt(99) + 1;
                int num2b = random.nextInt(99) + 1;
                askQuestion(num2a, num2b, mathType);
                double userNum2 = s.nextDouble();
                checkAnswer(userNum2, num2a, num2b, mathType);
                break;

            case 3:
                int num3a = random.nextInt(999) + 1;
                int num3b = random.nextInt(999) + 1;
                askQuestion(num3a, num3b, mathType);
                double userNum3 = s.nextInt();
                checkAnswer(userNum3, num3a, num3b, mathType);
                break;

            case 4:
                int num4a = random.nextInt(9999) + 1;
                int num4b = random.nextInt(9999) + 1;
                askQuestion(num4a, num4b, mathType);
                double userNum4 = s.nextDouble();
                checkAnswer(userNum4, num4a, num4b, mathType);
                break;
        }
    }

    public static int mathType()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("\n\nWhat kind of math problem do you want? (1-5)");
        System.out.println("1: Addition\n2: Subtraction\n3: Multiplication\n4: Division\n5: ALL of them\n\n");
        int mathType = s.nextInt();
        while (mathType < 1 || mathType > 5)
        {
            System.out.println("Uh... not an option. Try again.");
            mathType = s.nextInt();
        }
        return mathType;
    }

    public static String mathWord(int mathType)
    {
        String mathWord = "";
        switch (mathType)
        {
            case 1:
                mathWord = "+";
                break;
            case 2:
                mathWord = "-";
                break;
            case 3:
                mathWord = "*";
                break;
            case 4:
                mathWord = "/";
                break;
        }

        return mathWord;
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        char userContinue = 'Y';

        while (userContinue == 'Y' || userContinue == 'y')
        {
            cycleQuestions();
            System.out.println("\n");
            TestScore(numCorrectAnswers, numIncorrectAnswers);
            System.out.println("\n");
            System.out.println("Would you like another? Type 'Y' or 'y' to do so.");
            userContinue = s.next().charAt(0);
            System.out.println("\n");
        }
    }
}
