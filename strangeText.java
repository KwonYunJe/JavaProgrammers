import java.util.ArrayList;
import java.util.List;

class strangeText {
    public static void main(String[] args){
        strangeText my = new strangeText();
        // TCs
		String s = "  TRy HElLo  WORLD ";		//TC #1


        // Solution output
		String output = my.solution(s);
		System.out.println(output);
    }
    public String solution(String s) {

        String answer = "";

        //정답이 추가될 리스트
        List<String> answerList = new ArrayList<>();

        //아래 반복문에서 문자가 연속될 경우 증가하는 변수. 공백을 만나면 0으로 초기화 된다.
        int wordIndex = 0 ;

        for(int i = 0 ; i < s.length() ; i++){

            //정답리스트에 들어갈 다음 문자를 저장할 변수
            String add;

            //주어진 문자열을 탐색 중 공백(띄어쓰기)가 나오면
            if(s.charAt(i) == ' '){
                //단어인덱스를 0으로 초기화
                wordIndex = 0;
                //정답리스트에 공백 추가
                add = " ";

            //띄어쓰기가 아닌 문자가 나오면    
            }else{
                //그 문자의 단어인덱스가 0이거나 짝수일 때
                if(wordIndex == 0 || wordIndex % 2 == 0){
                    //문자를 대문자로 바꾸고 String으로 변환후 변수에 저장
                    if(s.charAt(i) >= 97 && s.charAt(i) <= 122){
                        add = Character.toString(s.charAt(i) - 32);
                    }else{
                        add = Character.toString(s.charAt(i));
                    }
                //문자의 단어인덱스가 홀수일 때
                }else{
                    if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                        add = Character.toString(s.charAt(i) + 32);
                    }else{
                        add = Character.toString(s.charAt(i));
                    }
                }
                //단어 인덱스 + 1;
                wordIndex++;
            }
            //변수에 저장된 String형 문자를 정답 리스트에 추가
            answerList.add(add);
        }

        answer = String.join("", answerList);

        return answer;
    }
}