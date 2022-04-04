import java.util.Scanner;
public class Input {

    private Operand Op1;
    private Operand Op2;
    private char Operator;
    private boolean correct;

    Input(){
        this.correct = true;
        System.out.println("Input:");
        Scanner inData = new Scanner(System.in);
        String expression = inData.nextLine();

        // Проверка выражения на требования условий задания
       verify(expression);
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
                    if (counter > 1) throw new Exception("Калькулятор может выполнять только одно действие");

                    if (c==o){
                        counter++;
                        this.Operator = c;
                        position = exp.indexOf(c);
                    }
                }
        }

        if(counter == 0) throw new Exception("В выражении отсутствует известный калькулятору оператор!");



        // Определяем операнды
        stringOp1 = exp.substring(0, position);
        stringOp2 = exp.substring(position+1);

        if(stringOp1.equals("") || stringOp2.equals("")) throw new Exception("Не хватает операнда(ов)!");

            this.Op1 = new Operand(stringOp1);
            this.Op2 = new Operand(stringOp2);

        if (!Op1.GetCorrect() || !Op2.GetCorrect()) throw new Exception("Один или оба операнда не соответствует(ют) требованиям задания");

    }
    catch (Exception ex){
            System.out.println(ex.getMessage());
            this.correct = false;
    }

    }

}

