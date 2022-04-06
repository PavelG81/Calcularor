public class Calculator {
    public static void main(String[] args) {


        System.out.println("Для выхода нажмите 'q'" + "\n");


        while (true) {

            // It's for Testing:
            //var input = new Test();
            //if(input.GetQuit()){
            //    break;
            //}

            Input expression = new Input();
            if (expression.GetQuit()) {
                break;
            }
            if (expression.GetCorrect()) {
                System.out.println("Out:");
                new Result(expression);
            }

        }
    }
}




