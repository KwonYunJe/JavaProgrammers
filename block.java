import java.util.ArrayList;
import java.util.List;

public class block {
    public static void main(String[] args) {
        String s = "z";
        int n = 1;

        String output = solution(s, n);
        System.out.println(output);
    }

    public static String solution(String s, int n) {
        String answer = "";

        List<String> answerList = new ArrayList<>();

        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == 'Z'){
                int ca = 65 + n - 1;
                String caa = Character.toString(ca);
                answerList.add(caa);
            }else if(s.charAt(i) == 'z'){
                int ca = 97 + n - 1;
                String caa = Character.toString(ca);
                answerList.add(caa);
            }else if(s.charAt(i) == ' '){
                answerList.add(" ");
            }else{
                int ca = s.charAt(i) + n;
                String caa = Character.toString(ca);
                answerList.add(caa);
            }
            
        }

        answer = String.join("", answerList);

        return answer;
    }
}
