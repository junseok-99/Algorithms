import java.util.*;

class Solution {
    
    public String findNumber(String s) {
        for(String str: s.split("[^0-9]")) {
            if (!str.equals("")) {
                return str;
            }
        }
        return null;
    }
    
    public String[] solution(String[] files) {
        
        Arrays.sort(files, (s1, s2) -> {
            String num1 = findNumber(s1);
            String num2 = findNumber(s2);
            int numIdx1 = s1.indexOf(num1);
            int numIdx2 = s2.indexOf(num2);
            String head1 = s1.substring(0, numIdx1).toUpperCase();
            String head2 = s2.substring(0, numIdx2).toUpperCase();
            String tail1 = s1.substring(numIdx1+num1.length(), s1.length());
            String tail2 = s2.substring(numIdx2+num2.length(), s2.length());
            
            if (head1.equals(head2)) {
                int parseNum1 = Integer.parseInt(num1);
                int parseNum2 = Integer.parseInt(num2);
                if (parseNum1 == parseNum2) {
                    return 0;
                }
                return parseNum1 - parseNum2;
            }
            
            return head1.compareTo(head2);
        });
        
        return files;
    }
}