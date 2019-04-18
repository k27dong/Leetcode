public class q12 {
    public String intToRoman(int num) {
        if (num == 0) {
            return "";
        }

        String ans = "";
        if (num - 1000 >= 0) {
            ans += "M";
            num -= 1000;
        }
        else if (num - 900 >= 0) {
            ans += "CM";
            num -= 900;
        }
        else if (num - 500 >= 0) {
            ans +=  "D";
            num -= 500;
        }
        else if (num - 400 >= 0) {
            ans +=  "CD";
            num -= 400;
        }
        else if (num - 100 >= 0) {
            ans +=  "C";
            num -= 100;
        }
        else if (num - 90 >= 0) {
            ans +=  "XC";
            num -= 90;
        }
        else if (num - 50 >= 0) {
            ans +=  "L";
            num -= 50;
        }
        else if (num - 40 >= 0) {
            ans +=  "XL";
            num -= 40;
        }
        else if (num - 10 >= 0) {
            ans +=  "X";
            num -= 10;
        }
        else if (num - 9 >= 0) {
            ans +=  "IX";
            num -= 9;
        }
        else if (num - 5 >= 0) {
            ans +=  "V";
            num -= 5;
        }
        else if (num - 4 >= 0) {
            ans +=  "IV";
            num -= 4;
        }
        else if (num - 1 >= 0) {
            ans +=  "I";
            num -= 1;
        }

        return ans + intToRoman(num);
    }
}