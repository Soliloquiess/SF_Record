package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// �젙�빐吏� 移쇰줈由щ뒗 �꽆吏� �븡�쑝硫댁꽌
// 媛��옣 �꽑�샇�븯�뒗 �뻹踰꾧굅
public class sw5215_recurhambur {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private static StringTokenizer stringTokenizer;
    private static int T;
    private static int countLimit;
    private static int calorie;
    private static int[][] array;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(BUFFERED_READER.readLine().trim());

        for(int t=1; t <= T; t++){
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            countLimit = Integer.parseInt(stringTokenizer.nextToken());
            calorie = Integer.parseInt(stringTokenizer.nextToken());

            array = new int[countLimit][2];
            for(int j=0; j < countLimit; j++){
                stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
                array[j][0] = Integer.parseInt(stringTokenizer.nextToken());
                array[j][1] = Integer.parseInt(stringTokenizer.nextToken());
            }

            STRING_BUILDER.append(go(0, 0, 0));

            System.out.println(STRING_BUILDER.toString());
        }

    }

    public static int go(int index, int nujeokMot, int nujeokCal){
        if(nujeokCal >= calorie){
            return 0;
        }
        if(index >= countLimit) {
            return nujeokMot;
        }
        int answer = 0;
        answer = Math.max(answer, go(index+1, nujeokMot+array[index][0], nujeokCal+array[index][1]));
        answer = Math.max(answer, go(index+1, nujeokMot, nujeokCal));
        return answer;
    }

}