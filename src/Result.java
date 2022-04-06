public class Result {

    private char TypeResult;


    Result(Input expression){

        try {
            var result_arabian = Calculation(expression);

        if(result_arabian < 1 && this.TypeResult == 'r'){
            throw new Exception("В римской системе счисления нет отрицательных чисел и нуля!");
        }
            String string = Integer.toString(result_arabian);
            if (this.TypeResult == 'r') {

               Converter result = new Converter(string);
               System.out.println(result.GetResult());
            } else {
                System.out.println(result_arabian);
            }

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private int Calculation (Input expression){
        var answer = 0;
        var Op1 = expression.GetOp1();
        var Op2 = expression.GetOp2();
        var Op1_TypeValue = Op1.GetTypeValue();
        var Op2_TypeValue = Op2.GetTypeValue();
        this.TypeResult = Op1_TypeValue;
        var Operator = expression.GetOperator();


    try {

        if (!(Op1_TypeValue == Op2_TypeValue)) throw new Exception("В выражении " +
                "указаны арбские и римские цифры. Калькулятор не выполняет действия с разными видами чисел!");

            int a = Op1.GetValue();
            int b = Op2.GetValue();

            switch (Operator) {
                case '+' -> answer = a + b;
                case '-' -> answer = a - b;
                case '*' -> answer = a * b;
                case '/' -> answer = a / b;
                //default -> answer = 0;
            }
            return answer;

    }
    catch (Exception ex){
        System.out.println(ex.getMessage());
        return 0;

    }


    }


}
