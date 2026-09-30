package edu.princeton.cs.algs4;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            else if (c == ')' || c == ']' || c == '}') {

                if (stack.isEmpty()) {
                    return "NO";
                }

                char top = stack.pop();

                if (!isMatchingPair(top, c)) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("((()))"));
        System.out.println(isBalanced("((("));
        System.out.println(isBalanced("]"));
    }
}