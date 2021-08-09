package com.company.BinaryTreeSort;

public class TreeElement{
    TreeElement leftElement;
    TreeElement rightElement;
    int key;

    TreeElement(int keyValue){
        this.key = keyValue;
    }

    //построение двоичного дерева
    public void insertTreeElement(TreeElement newTreeElement){
        //если значение нового узла меньше текущего то добавляем к левому листу
        if(newTreeElement.key < key){
            //если есть левый лист, то рекурсивно назначаем новый лист к этому левому листу
            if(leftElement != null){
                leftElement.insertTreeElement(newTreeElement);
            }
            //если нет то назначаем левый лист текущему узлу
            else{
                leftElement = newTreeElement;
            }
        }
        else{
            //если есть правый лист, то рекурсивно назначаем новый лист к этому правому листу
            if(rightElement != null){
                rightElement.insertTreeElement(newTreeElement);
            }
            //если нет то назначаем правый лист текущему узлу
            else{
                rightElement = newTreeElement;
            }
        }
    }

    public void traverse(TreeVisitor treeVisitor){
        if(leftElement != null){
            leftElement.traverse(treeVisitor);
        }
        treeVisitor.visit(this);
        if(rightElement != null){
            rightElement.traverse(treeVisitor);
        }
    }
}