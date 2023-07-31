import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] tmp = a.toCharArray();
        
        for(int i=0;i<tmp.length;i++)
            if(Character.isLowerCase(tmp[i]))
                tmp[i] = Character.toUpperCase(tmp[i]);
            else
                tmp[i] = Character.toLowerCase(tmp[i]);
        
        System.out.println(new String(tmp));
    }
}