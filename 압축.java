import java.util.Stack;

public class 압축 {
    public static void main(String[] args) {
        String input = "33(562(71(9)))";  // 예제 입력을 이곳에 넣습니다.
        System.out.println(getUncompressedLength(input));
    }

    public static int getUncompressedLength(String input) {
        Stack<Integer> stack = new Stack<>();
        int length = 0;

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if(Character.isDigit(c)) {
                if(i + 1 < input.length() && input.charAt(i + 1) == '(') {
                    stack.push(length);
                    stack.push(c - '0');
                    length = 0;
                    i++;
                } else {
                    length++;
                }
            } else if(c == ')') {
                int repeatCnt = stack.pop();
                int prevLength = stack.pop();
                length = prevLength + length * repeatCnt;
            } else {
                length++;
            }
        }
        return length;
    }
}