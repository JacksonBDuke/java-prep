package com.company;

import java.util.Stack;

public class Main {

    /*
        Linked list, array, stack, queue questions.
        Write some function to check a Palindrome.
        Write a function to convert string to integer.
        How to check in a class how all of the curly-brackets match.
        What is a singleton pattern.
        What is a factory pattern.
     */
    public static void main(String[] args) {
	// write your code here
        String testCase1 = "100003";
        String testCase2 = "{{}()({[()])})}";
        System.out.println(reverseString(testCase1));
        System.out.println("Is " + testCase1 + " a palindrome: " + isPalindrome(testCase1));
        System.out.println("Int value is " + convertFromStringToInt(testCase1) + "");
        System.out.println("Brackets match: " + checkThatBracketsMatch(testCase2));
    }

    private static boolean checkThatBracketsMatch(String s){
        if(s.isEmpty()) return true;

        Stack<Character> bracketStack = new Stack<Character>();

        for(int i = 0; i < s.length(); ++i){
            char currentChar = s.charAt(i);
            if(currentChar == '{' || currentChar == '(' || currentChar == '['){
                bracketStack.push(currentChar);
            }
            else{
                if(bracketStack.isEmpty()) return false;

                char lastChar = bracketStack.peek();
                if(currentChar == '}' && lastChar == '{' || currentChar == ')' && lastChar == '(' || currentChar == ']' && lastChar == '['){
                    bracketStack.pop();
                }
            }
        }

        return bracketStack.isEmpty();
    }

    private static int convertFromStringToInt(String s) {
        int result = 0;
        char[] sequence = s.trim().toCharArray();

        for(char c : sequence){
            if(c >= 48 && c < 58){
                result *= 10;
                result += c - 48;
            }
            else return 0;
        }

        return result;
    }

    private static boolean isPalindrome(String s){
        if(s.length() <= 1) return true;
        else{
            String firstHalf = s.substring(0, s.length()/2);
            String secondHalf = s.length() % 2 == 0 ?
                    reverseString(s.substring(s.length() / 2)) :
                    reverseString(s.substring(s.length() / 2 + 1));
            return firstHalf.compareToIgnoreCase(secondHalf) == 0;
        }
    }

    private static String reverseString(String s){
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()){
            result.insert(0, c);
        }

        return result.toString();
    }
}
