package com.company.BinaryTreeSort;

//https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D1%81_%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D1%8C%D1%8E_%D0%B4%D0%B2%D0%BE%D0%B8%D1%87%D0%BD%D0%BE%D0%B3%D0%BE_%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D0%B0
//https://ru.wikipedia.org/wiki/%D0%94%D0%B2%D0%BE%D0%B8%D1%87%D0%BD%D0%BE%D0%B5_%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D0%BE_%D0%BF%D0%BE%D0%B8%D1%81%D0%BA%D0%B0
public class BinaryTreeSort {
    public static void sort(int[] inputArray){
        TreeElement tree = null;
        for(int i = 0; i < inputArray.length; i++){
            if(i == 0){
                tree = new TreeElement(inputArray[0]);
            }
            else{
                tree.insertTreeElement(new TreeElement(inputArray[i]));
            }
        }
        tree.traverse(new TreeVisitorArray());
    }
}
