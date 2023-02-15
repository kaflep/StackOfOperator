import java.util.ArrayList;

// this program is qiuite simpler becasue it ignores the order
// it is only focusing on the left to right.
public class Operator_Operand {
        ArrayList<Integer> numStack = new ArrayList<Integer>();
        ArrayList<Character> opStack = new ArrayList<Character>();
        public void stackify(String str)
        {
            for(int i=0;i<str.length();i++)
            {
                String s = "";
                if(str.charAt(i)>='0' &&str.charAt(i)<='9')
                {
                    while(i < str.length() && str.charAt(i)>='0' && str.charAt(i)<='9')
                    {
                        s= s+str.charAt(i);
                        i++;
                    }
                    i--;
                    numStack.add(Integer.parseInt(s));
                }
                if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*'||str.charAt(i)=='/')
                {
                    opStack.add(str.charAt(i));
                }

            }
        }
        public  int evaluateString(String str)
        {
            stackify(str);
            for(int i=0;i<opStack.size();i++)
            {
                int a = numStack.remove(0);
                int b = numStack.remove(0);
                int result=0;
                char oper = opStack.get(i);
                switch(oper)
                {
                    case '+':result=a+b;
                        break;
                    case '-':result=a-b;
                        break;
                    case '*':result=a*b;
                        break;
                    case '/':result=a/b;
                        break;
                }
                numStack.add(0, result);;
            }
            return numStack.get(0);
        }
        public static void main(String[] args) {
            Operator_Operand sol = new Operator_Operand();
            String str = "6*10+9-7";
            System.out.println(sol.evaluateString(str));
        }
}
