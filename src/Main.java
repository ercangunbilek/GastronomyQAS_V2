import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter the question please...");
            String questionText = sc.nextLine();
            VitualChef.askQuestion(questionText);

        }
    }
}