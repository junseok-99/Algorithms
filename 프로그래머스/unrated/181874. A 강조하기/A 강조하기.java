class Solution {
    public String solution(String myString) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<myString.length();i++){
            if(myString.charAt(i) == 'A' || myString.charAt(i) == 'a') sb.append("A");
            else sb.append(Character.toString(Character.toLowerCase(myString.charAt(i))));
        }
        
        return sb.toString();
    }
}