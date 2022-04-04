public class Operand {
    private final int Value;
    private char TypValue;
    private boolean correct;


    Operand(String text) {

        this.correct = true;
        this.Value = stringToNum(text);
    }




    private int stringToNum(String string) {
        int result = 0;
       try {
           if (string.matches("\\d*")) {
               this.TypValue = 'a';
               result = Integer.parseInt(string);
           } else {
               this.TypValue = 'r';
               Converter roman = new Converter(string);
               result = Integer.parseInt(roman.GetResult());
           }
       if(result < 1 || result > 10) {throw new Exception("Вводимые числы должны быть в диапозоне от 1 до 10");}
       }

       catch (Exception ex){
         System.out.println(ex.getMessage());
         this.correct = false;

       }
        return result;
    }



    public boolean GetCorrect() {
        return this.correct;
    }

    public int GetValue() {
        return this.Value;
    }

    public char GetTypeValue() {
        return this.TypValue;
    }
}
