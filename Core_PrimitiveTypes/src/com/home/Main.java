package com.home;

public class Main {
    public static void main(String[] args) {
        //Примитивные типы
        byte x = 8;             // 8 bit	[-128;127]
        short y = 16;           // 16 bit [-32,768;32,767]
        int z = 32;             // 32 bit [-2,147,483,648;2,147,483,647]
        long a = 64L;            // 64 bit [-9,223,372,036,854,775,808;9,223,372,036,854,775,807]
        float b = 32.32f;       // 32 bit	[3,4e−038;3,4e+038]
        double c = 64.64;       // 64 bit [1.7e−308 to 1.7e+308]
        boolean d  = true;      // true/false, фактически занимаемая память зависит от VM
        char e = 'A';           // 16 bit, хранит один символ (в т.ч. ASCII символ), безнаковое число [0;65,535]

        //Преобразование типов
        //Автоматическое преобразование при расширении типа, а также от целого числа к числу с плавающей запятой
        short s1 = 123;
        int i1 = s1;
        float f1 = i1;
        System.out.println(String.format("short = %d\tint = %d\tfloat = %f", s1, i1, f1));
        //Возможна потеря точности при автоматическом преобразовании (int -> float, long -> float, long -> double)
        long l_max = 2147483650L;
        float f2 = l_max;
        System.out.println(String.format("long = %d\tfloat = %f", l_max, f2));

        //Явное преобразование, возможна потеря части данных
        short s_max = 32767;
        byte b_lost = (byte)s_max;
        System.out.println(String.format("short = %d\tbyte = %d", s_max, b_lost));
        float f3 = 12.345f;
        int i3 = (int)f3;
        System.out.println(String.format("float = %f\tint = %d", f3, i3));

    }
}


