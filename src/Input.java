import java.util.Scanner;
public class Input {

    private Operand Op1;
    private Operand Op2;
    private char Operator;
    private boolean correct;
    private boolean Quit;

    Input(){
        this.correct = true;
        System.out.println("Input:");
        Scanner inData = new Scanner(System.in);
        String expression = inData.nextLine();
        if (expression.equals("q")) this.Quit = true;
        else{
            verify(expression);
        }

        // Проверка выражения на требования условий задания

    }

    public Operand GetOp1(){
        return this.Op1;
    }
    public Operand GetOp2(){
        return this.Op2;
    }
    public char GetOperator() {
        return this.Operator;
    }
    public boolean GetCorrect() {
        return this.correct;
    }

    public boolean GetQuit() {
        return this.Quit;
    }

    void verify(String exp){
        char[] charArray = exp.toCharArray();

        // Проверяем количество операторов в выражении
        char[] operatorsArray = new char[] {'+', '-', '*', '/'}; // Список допустимых операторов
        int counter = 0; // счетчик операторов
        int position = 0; // Позиция оператора в строке (индекс)
        var stringOp1 = ""; // Текст левого операнда
        var stringOp2 = ""; // Текст правого операнда


    try {
        for (char c : charArray){
            for(char o: operatorsArray){
                    if (counter > 1) throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

                    if (c==o){
                        counter++;
                        this.Operator = c;
                        position = exp.indexOf(c);
                    }
                }
        }

        if(counter == 0) throw new Exception("Строка не является математической операцией!");



        // Определяем операнды
        stringOp1 = exp.substring(0, position);
        stringOp2 = exp.substring(position+1);

        if(stringOp1.equals("") || stringOp2.equals("")) throw new Exception("Не хватает операнда(ов)!");

            this.Op1 = new Operand(stringOp1);
            this.Op2 = new Operand(stringOp2);

        if (!Op1.GetCorrect() || !Op2.GetCorrect()) throw new Exception("Используются одновременно разные системы счисления");

    }
    catch (Exception ex){
            System.out.println(ex.getMessage());
            this.correct = false;
    }

    }

}

