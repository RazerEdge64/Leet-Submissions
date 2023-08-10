class Solution {

  public boolean isValid(String s) {
    Stack<String> charStack = new Stack<String>();

    for (int i = 0; i < s.length(); i++) {

      if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
        charStack.push(s.charAt(i) + "");
        continue;
      } else if (charStack.empty()) {
        charStack.push(s.charAt(i)+"");
      }
      else{
        if (s.charAt(i) == ')' && charStack.peek().equals("(")) { //||  ||
          charStack.pop();
          continue;
        }

        if (s.charAt(i) == '}' && charStack.peek().equals("{")) {
          charStack.pop();
          continue;
        }
        if (s.charAt(i) == ']' && charStack.peek().equals("[")) {
          charStack.pop();
          continue;
        }
        charStack.push(s.charAt(i)+"");
      }

    }


    return charStack.empty();
  }

}