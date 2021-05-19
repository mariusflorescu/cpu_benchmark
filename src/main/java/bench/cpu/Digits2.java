package main.java.bench.cpu;


import main.java.bench.IBenchmark;

import java.util.Arrays;

public class Digits2 implements IBenchmark {
    int size;

    private final StringBuilder Result=new StringBuilder();


    @Override
    public void initialize(int size) {
        this.size = size;
    }


    // write the buffered digits
    void flushDigits() {
        //System.out.append(Result);
        Result.setLength(0);
    }


    // given an integer 0..9, buffer a digit '0' .. '9'
    void addDigit(int digit) {
        Result.append((char)('0' + digit));
    }

    // add one to each digit, rolling over from from 9 to 0
    void overflowDigits() {
        for (int i=0; i < Result.length(); i++) {
            char digit = Result.charAt(i);

            if (digit == '9') {
                Result.setCharAt(i, '0');
            } else {
                Result.setCharAt(i, (char)(digit + 1));
            }
        }
    }


    @Override
    public void run() {

        int array_size_needed = size *10/3+1;
        int[] digits = new int[array_size_needed];

        // fill each digit with a 2
        Arrays.fill(digits, 2);


        for (int i=0; i<size; i++) {

            // Work backwards through the array, multiplying each digit by 10,
            // carrying the excess and leaving the remainder.
            int carry=0;
            for (int j = digits.length-1; j> 0; j--) {
                int denom=j*2+1;
                int x = digits[j]*10+carry;
                digits[j] =x%denom;
                carry=x/denom * j;
            }

            // process the last digit
            int x = digits[0]*10+carry;
            digits[0] =x%10;
            int digit =x/10;

            // implement buffering and overflow
            if (digit<9) {
                flushDigits();
                // print a decimal after the leading "3"
                if (i==1) System.out.print(".");
                addDigit(digit);
            } else if (digit == 9) {
                addDigit(digit);
            } else {
                overflowDigits();
                flushDigits();
                addDigit(0);
            }
        }
        flushDigits();
    }
    @Override
    public void run(Object option) {
    }

    @Override
    public void clean() {
    }

    @Override
    public void warmUp() {
        for (int i = 1; i <= 1000; ++i) {
            for (int j = 1; j <= 1000; ++j) {
                for (int z = 1; z <= 1000; ++z){
                    Digits2 warm_up = new Digits2();
                }
            }

        }
        System.out.println("START! Warm-up done!");
    }

    @Override
    public void warmUp(Object option) {

    }

    @Override
    public String getResult() {
        return null;
    }

    @Override
    public void cancel(){

    }



}
