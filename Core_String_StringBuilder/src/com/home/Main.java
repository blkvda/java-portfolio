package com.home;

public class Main {
    public static void main(String[] args) {
        //String - неизменяемый объект, т.е при "изменении" создается новый объект
            //s1 и s2 - два разных объекта
        String s1 = "Immutable";
        s1.concat(" or not"); //т.к. String - неизменятеся, то изменения в s1 не вносятся
        System.out.println("String is immutable?\ts1:" + s1);
        String s2 = s1.concat(" or not");
        System.out.println("String is immutable?\ts2:" + s2);

        //JVM использует String Pool для оптимизации исп. памяти
        String s3 = "Test";
        String s4 = "Test";
        System.out.println("(s3 == s4) = " + (s3 == s4)); //т.к. s3 и s4 ссылается на один объект в пуле
        String s5 = new String("Test");
        System.out.println("(s3 == s5) = " + (s3 == s5)); //т.к. s5 - новый, отдельно созданный объект
        String s6 = "Te" + "st";
        System.out.println("(s4 == s6) = " + (s4 == s6)); //т.к. s6 - конкатенация строк будет выаолена на этапе компиляции (т.е. = "Test")
        String s7 =  new String("Test").intern();
        System.out.println("(s3 == s7) = " + (s3 == s7)); //т.к. intern() - ищет строку в пуле и возвращает оттуда, если ее в пуле нет, то добавляет туда


        //StringBuilder - Mutable (изменяемый) класс, который может содержать изменяемый набор символов
        StringBuilder sb = new StringBuilder("string");
//        StringBuffer stringBuffer = new StringBuffer("string buffer"); //в отличии от StringBuilder'а - синхронизирована
        sb.append("builder");
        sb.insert("string".length(), " test ");
        System.out.println("StringBuilder: " + sb);
        System.out.println("StringBuilder reverse: " + sb.reverse());
    }
}
