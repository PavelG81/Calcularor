import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {

        String cont = "";

        while (!cont.equals("q")) {
            Input expression = new Input();
            if (expression.GetCorrect()) {
                System.out.println("Out:");
                new Result(expression);
            }

            System.out.println("Для выхода нажмите 'q', для продолжения любую другую клавишу");
            Scanner inData = new Scanner(System.in);
            cont = inData.nextLine();
        }
    }
}



