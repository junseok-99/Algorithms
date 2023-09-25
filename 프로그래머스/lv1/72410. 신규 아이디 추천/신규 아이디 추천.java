class Solution {
    public String dot(String tm){
        String s = tm;
        if(s.length() > 0)
            if(s.charAt(s.length()-1) == '.') s = s.substring(0,s.length()-1);
        
        if(s.length() > 0)
            if(s.charAt(0) == '.') s = s.substring(1);
        return s;
    }
    public String solution(String new_id) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder(new_id);
        
        for(int i=0;i<new_id.length();i++){
            if(Character.isUpperCase(new_id.charAt(i)))
                sb.setCharAt(i,Character.toLowerCase(new_id.charAt(i)));
            if(Character.isDigit(sb.charAt(i)) || Character.isLetter(sb.charAt(i)) || sb.charAt(i) == '-' || sb.charAt(i) == '_' || sb.charAt(i) == '.')
                answer += Character.toString(sb.charAt(i));
        }
                

        while(answer.contains(".."))
            answer = answer.replace("..",".");
        
        answer = dot(answer);
        
        if(answer.equals("")) answer += "a";
        
        if(answer.length() >= 16) answer = answer.substring(0,15);
        
        answer = dot(answer);
        
        for(int i=answer.length();i<3;i++) answer += Character.toString(answer.charAt(answer.length()-1));
        
        return answer;
    }
}