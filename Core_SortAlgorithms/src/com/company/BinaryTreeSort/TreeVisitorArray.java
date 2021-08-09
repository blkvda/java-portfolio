package com.company.BinaryTreeSort;

import java.util.ArrayList;

public class TreeVisitorArray implements TreeVisitor{
    @Override
    public void visit(TreeElement treeElement) {
        System.out.print(" " + treeElement.key);
    }
}