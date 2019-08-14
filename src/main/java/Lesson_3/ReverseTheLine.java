package Lesson_3;

public class ReverseTheLine {
    private static String input;

    public static void main(String[] args) {
        input = "this line should be reversed";

        Stack stack = new Stack(input.length());

        for(int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        StringBuilder stringBuilder = new StringBuilder();

        while(!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder.toString());
    }
}
