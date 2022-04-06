import java.util.Scanner;

// This class don't use in calculator, it used for testing Converter.
public class Test {
    private boolean quit;


    Test() {
        Scanner inData = new Scanner(System.in);
        String answ = inData.nextLine();
        if (answ.equals("q")) {
            this.quit = true;

        }

        var Val = new Converter(answ);
        System.out.println(Val.GetResult());

    }


    public boolean GetQuit() {
        return this.quit;
    }
}
