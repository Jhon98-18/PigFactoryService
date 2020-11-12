package com.zz.test.balance;

import java.util.*;

public class BalanceProcess {

    /*
     * 问题描述： 在编写代码并且编译时，难免会因为少写了一个')'和被编译器报错。也就是说，编译器会去匹配
     *括号是否匹配。当你输入了一个'('，很自然编译器回去检查你是否有另一个')'符号与之匹配。如
     *果所有的括号都能够成对出现，那么编译器是能够通过的。否则编译器会报错。例如字符序列“(a+b)”是匹配的，
     *而字符序列"(a+b]"则不是。
     *
     * 算法描述如下： 创建一个空栈，读取字符序列直到结尾。如果字符是开放符号'(''[''{'，将其入栈；如果是一个封闭
     * 符号')'']''}'，则当栈为空时报错。否则，将栈顶元素弹出。如果弹出的符号不是对应的开放符号，


     * */


    public static void main(String[] args) {

        String d = "zhngsan";

        for (int i = 0; i < d.length(); i++) {
            System.out.println(d.substring(0, i)+d.substring(i + 1));
            System.out.println();
        }
        /*Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String next2 = scanner.next();
        int count = next.length();
        if (count > 8) {
            String substring = next.substring(0, 8);
            String substring2 = next.substring(8, count);
            System.out.println(substring2 + "substring2");
            StringBuffer stringBuffer1 = addZiro(substring2);
            System.out.println(substring);
            System.out.println(stringBuffer1);
        } else {
            StringBuffer stringBuffer = addZiro(next);
            System.out.println(stringBuffer);
        }*/


        //System.out.println(next2);
    }

    static StringBuffer addZiro(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int count = str.length();
        while (count++ < 8) {
            stringBuffer.append("0");
        }
        return stringBuffer;
    }

    public static int getSize(String codes, char code) {
        char[] chars = codes.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == code) {
                count++;
            }
        }
        return count;
    }

    public static void checkCode(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    characters.push(chars[i]);
                    break;
                case '{':
                    characters.push(chars[i]);
                    break;
                case '[':
                    characters.push(chars[i]);
                    break;
                case ')':
                    if (characters.size() == 0 || characters.pop() != '(')
                        System.out.println("符号不平衡1");
                    break;
                case '}':
                    if (characters.size() == 0 || characters.pop() != '{')
                        System.out.println("符号不平衡2");
                    break;
                case ']':
                    if (characters.size() == 0 || characters.pop() != '[')
                        System.out.println("符号不平衡3");
                    break;
                default:
                    break;
            }

        }
        if (characters.size() > 0) {
            System.out.println(characters);
            System.out.println(characters.pop() + "没有闭合");
        }
    }
}


//todo：编写后缀表达式计算
class test {
    public static void main(String[] args) {

        /*public class postfix {
            //The following function evaluates a postfix expression, using+, −, ∗, /, and ^ ending in =. It requires
            //spaces between all operators and =.
            static double evalPostFix()
            {
                Stack<Double> s = new Stack<Double>();
                String token;
                Double a, b, result=0.0;//ab是计算过程的中间变量，result是入栈时的变量
                boolean isNumber;
                Scanner sc = new Scanner(System.in);
                token = sc.next();//后缀表达式一个一个输入，当输入了=时，循环结束
                while (token.charAt(0) != '=')//每次输入检测字符串的第一个字符是否为=
                {
                    try
                    {
                        isNumber = true;
                        result = Double.parseDouble(token);//若输入字符不是数字，肯定报异常，即让布尔类型为false
                    }
                    catch (Exception e)
                    {
                        isNumber = false;
                    }

                    if (isNumber)//如果是数字，那么就入栈
                        s.push(result);
                    else//如果是运算符，那么就栈顶出两个数字，计算后再入栈
                    {
                        switch (token.charAt(0))
                        {//每个case后面都应该有break
                            case '+': a = s.pop(); b = s.pop();
                                s.push(b+a); break;
                            case '-': a = s.pop(); b = s.pop();
                                s.push(b-a); break;
                            case '*': a = s.pop(); b = s.pop();
                                s.push(b*a); break;
                            case '/': a = s.pop(); b = s.pop();
                                s.push(b/a); break;
                            case '^': a = s.pop(); b = s.pop();
                                s.push(Math.exp(a*Math.log(b)));//这里就相当于b^a
                                break;
                        }
                    }
                    token = sc.next();
                }//当循环结束时，栈里只剩下一个元素
                return s.peek();//返回栈顶元素，并不删除
            }

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                System.out.println(evalPostFix());

            }

        }
    }*/
    }
}
