package com.company;

import java.util.Scanner;

public class Main {
    static int a, b;
    static String c, result;
    static boolean isRoman;

    public static void main(String[] args) {
        try {


            Scanner in = new Scanner(System.in);

            if (in.hasNextInt()) {
                a = in.nextInt();
                c = in.next();
                if(in.hasNextInt())
                b = in.nextInt();
                else
                throw new IllegalStateException("Unexpected value: " + in.next());
            } else {
                a = RomConverter.RomToInt(in.next());
                c = in.next();
                if (!in.hasNextInt())
                b = RomConverter.RomToInt(in.next());
                else
                throw new IllegalStateException("Unexpected value: " + in.next());
                isRoman = true;
            }

            if (a > 10 || b > 10 || a < 0 || b < 0)
                throw new IllegalStateException("Unexpected value");

            switch (c) {
                case "+":
                    result = CheckToRom(a + b);
                    break;
                case "-":
                    result = CheckToRom(a - b);
                    break;
                case "/":
                    result = CheckToRom(a / b);
                    break;
                case "*":
                    result = CheckToRom(a * b);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + c);
            }

            System.out.println(result);
        }
        catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

    }

    static String CheckToRom(int number){
        if(isRoman)
            return RomConverter.IntToRom(number);
        return String.valueOf(number);
    }
}