public class Converter {
    private String Result;

    public String GetResult(){
        return this.Result;
    }

    Converter(String num){
        char[] numArray = num.trim().toCharArray();
        String RomanDigital = "IVXLCDM";

        StringBuilder Result = new StringBuilder();
                if (RomanDigital.contains(String.valueOf(numArray[0]))) {
                this.Result = RomToArab(num);
            }

            else {
                int count = 0;
                for (char n : numArray) {

                    Result.append(ArToRom(numArray.length - count, Integer.parseInt(String.valueOf(n))));
                    count++;
                }
                this.Result = String.valueOf(Result);
            }

        }





    String ArToRom(int digital, int d){
        return switch(digital) {
            case 1 -> MakeNum(d, "I", "V", "X");
            case 2 -> MakeNum(d, "X", "L", "C");
            case 3 -> MakeNum(d, "C", "D", "M");
            default -> "";
        };

    }

    String MakeNum(int d, String one, String two, String three){
        return switch (d) {
            case 1, 2, 3 -> one.repeat(d);
            case 4 -> one + two;
            case 5 -> two;
            case 6, 7, 8 -> two + one.repeat(d - 5);
            case 9 -> one + three;
            default -> "";
        };

    }

    String RomToArab(String string){
        string = string.trim();
        var str = new StringBuilder(string);
        int sum = 0;
        int len = str.length() - 1;
        for (int i = 0; i < len; i++){
           var a = RomanDig.valueOf(String.valueOf(str.charAt(i))) ;
           var b = RomanDig.valueOf(String.valueOf(str.charAt(i+1))) ;
           if (b.ordinal()>a.ordinal()){
               sum = sum - a.getVal();
           }
           else {
               sum = sum + a.getVal();
           }
        }
        sum +=  RomanDig.valueOf(String.valueOf(str.charAt(str.length()-1))).getVal() ;
        return Integer.toString(sum);
    }

}
enum RomanDig {
    I(1), V(5),  X(10), L(50), C(100), D(500), M(1000);

    private int val;
    RomanDig(int val){
        this.val = val;
    }
    public int getVal(){return val;}

}

