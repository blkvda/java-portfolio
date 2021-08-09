package com.home;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

//Один из внутренних элементов системы
public class StringConverter {
    public byte[] toByteArr(String input) {
        if(input == null) throw new IllegalArgumentException("input String == null");
        byte[] output = null;
        try{
            output = input.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }
        finally {
            return output;
        }
    }

    public String toString(byte[] input){
        if(input == null) throw new IllegalArgumentException("input byte[] == null");
        return new String(input, Charset.forName("UTF-8"));
    }
}
