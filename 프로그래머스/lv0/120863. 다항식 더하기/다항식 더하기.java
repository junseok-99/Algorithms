import java.util.*;
class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        int x = 0;
        int num = 0;
        polynomial = polynomial.replaceAll(" ", "");
        String[] arr = polynomial.split("[^0-9a-z]");
        
        for(int i=0;i<arr.length;i++) {
            if (arr[i].contains("x")) {
                String tmp = arr[i].replace("x", "");
                if (tmp.equals("")) {
                    x++;
                } else {
                    x += Integer.parseInt(tmp);
                }
            } else {
                num += Integer.parseInt(arr[i]);
            }
        }
        
        
        if (num > 0 && x > 0) {
            if (x == 1) {
                answer = "x + " + Integer.toString(num);
            } else {
                answer = Integer.toString(x) + "x + " + Integer.toString(num);
            }
        } else if (num == 0) {
            if (x == 1) {
                answer = "x";
            } else {
                answer = Integer.toString(x) + "x";
            }
        } else if (x == 0) {
            answer = Integer.toString(num);   
        }
        
        return answer;
    }
}