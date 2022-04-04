public class Converter {
    private String Result;

    public String GetResult(){
        return this.Result;
    }

    Converter(String num){
        char[] numArray = num.toCharArray();
        char[] RomanNum = new char[] {'I', 'V', 'X', 'L' };
        StringBuilder Result = new StringBuilder();
        for (char c : RomanNum) {
            String s = String.valueOf(c);

            if(num.contains(s)){
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
            break;
        }


    }

    String ArToRom(int digital, int d){
        return switch(digital) {
            case 1 -> MakeNum(d, "I", "V", "X");
            case 2 -> MakeNum(d, "X", "L", "C");
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

       return switch (string.trim()) {
            case "I" ->  "1";
            case "II" ->  "2";
            case "III" ->  "3";
            case "IV" ->  "4";
            case "V" -> "5";
            case "VI" -> "6";
            case "VII" ->  "7";
            case "VIII" ->  "8";
            case "IX" ->  "9";
            case "X" ->  "10";
            default -> "-1";
        };

    }
}

