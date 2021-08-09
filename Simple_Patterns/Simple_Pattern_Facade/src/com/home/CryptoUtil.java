package com.home;

//Один из внутренних элементов системы
public class CryptoUtil {
    public byte[] encode(byte[] input){
        if(input == null) throw new IllegalArgumentException("input byte[] == null");
        byte[] output = new byte[input.length];
        for(int i = 0; i < input.length; i++){
            output[i] = (byte)(input[i] + 1);
        }
        return output;
    }

    public byte[] decode(byte[] input){
        if(input == null) throw new IllegalArgumentException("input byte[] == null");
        byte[] output = new byte[input.length];
        for(int i = 0; i < input.length; i++){
            output[i] = (byte)(input[i] - 1);
        }
        return output;
    }
}
