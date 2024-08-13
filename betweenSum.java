import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args){
        Solution my = new Solution();
        // TCs
		// String t = "3141592";		//TC #1
		// String p = "271";		//TC #1
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

		//String p = "7";		//TC #2
		//String t = "10203";		//TC #3
		//String p = "15";		//TC #3


        // Solution output
		String output = my.solution(numbers, hand);
		System.out.println(output);
    }

        public String solution(int[] numbers, String hand) {

            String answer = "";

            //정답이 담길 리스트
            List<String> answerList = new ArrayList<>();
            
            //오른손의 위치
            int[] rHand = {3,2};
            //왼손의 위치
            int[] lHand = {3,0};
            //정답길이만큼 반복
            for(int i = 0 ; i < numbers.length ; i++){

                //눌러야할 숫자키의 위치 FindIndex라는 메서드를 사용함
                int[] numLocation = FindIndex(numbers[i]);

                //각 조건문, 1,4,7의 경우 왼손, 3,6,9의 경우 오른손, 그외의 경우는 연산이 필요
                if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                    //정답리스트에 왼손을 의미하는 L을 추가하고 왼손의 위치를 변경
                    answerList.add("L");
                    lHand = numLocation;
                }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                    //정답리스트에 왼손을 의미하는 R을 추가하고 왼손의 위치를 변경
                    answerList.add("R");
                    rHand = numLocation;
                }else{
                    //현재 숫자키의 위치가 오른손,왼손으로부터 떨어진 거리를 각 변수에 저장
                    //연산은 x축 거리의 절대값 + y축 거리의 절대값
                    int rDist = Math.abs(numLocation[0] - rHand[0]) + Math.abs(numLocation[1] - rHand[1]);
                    int lDist = Math.abs(numLocation[0] - lHand[0]) + Math.abs(numLocation[1] - lHand[1]);

                    //거리가 다를경우 같을 경우처리 방식 위의 조건문과 비슷하다.
                    if(rDist > lDist){
                        answerList.add("L");
                        lHand = numLocation;
                    }else if(rDist < lDist){
                        answerList.add("R");
                        rHand = numLocation;
                    }else {
                        if(hand.equals("right")){
                            answerList.add("R");
                            rHand = numLocation;
                        }else{
                            answerList.add("L");
                            lHand = numLocation;
                        }
                    }
                }
            }
            
            //정답리스트를 String으로 변환
            answer = String.join("", answerList);

            return answer;
        }

        //매개변수로 받은 숫자의 위치를 반환하는 메서드
        public int[] FindIndex(int num){
            int[][] pad = {{1,2,3}, {4,5,6}, {7,8,9}, {10,0,11}};

            int[] index = {};

            for(int i = 0 ; i < pad.length ; i++){
                for(int j = 0 ; j < pad[0].length ; j++){
                    if(pad[i][j] == num){
                        index = new int[] {i,j};
                    }
                }
            }
            return index;
        }

}