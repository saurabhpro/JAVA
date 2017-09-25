package com.saurabh.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Saurabh on 9/5/2015.
 * Printing list in one pass through and in reverse order
 */

public class ListReversePrinting {
    Stack<Integer> stack = new Stack<>();       //primitives not allowed in <>

    static void printReverse(List list){
        if(list.isEmpty())  return;
        else
        {
            Object temp = list.remove(0);
            printReverse(list);
            System.out.println(temp);
        }

    }
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>() ;

        list.add(5);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(1);
        list.add(7);

        //printReverse(list, list.size()-1);
        printReverse(list);
    }
}
