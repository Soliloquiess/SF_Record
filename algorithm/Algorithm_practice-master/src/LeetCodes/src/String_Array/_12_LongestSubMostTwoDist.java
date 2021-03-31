package String_Array;

import java.util.HashMap;
import java.util.Map;

public class _12_LongestSubMostTwoDist {


	public static void main(String[] args) {
		String s = "ccaabbb";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}
	    public static int lengthOfLongestSubstringTwoDistinct(String s) {
	        Map<Character,Integer> map = new HashMap<>();
	        int start = 0, end = 0, counter = 0, len = 0;
	        while(end < s.length()){
	            char endChar = s.charAt(end);
	            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
	            //c�� endchar 0�� ����Ʈ value	c�� �ѹ� ������1 �� 2���� ������ �� ���������� �װ� ������ 0�� ��.
	            //�� �� �޼���鵵 ���� �����ϱ� �˾Ƶ���.
	            //c=2,a=2,b=3
	            if(map.get(endChar) == 1) counter++;//new char
	            
	            //c�� 1�ΰŸ� ���ڰ� �ϳ� ��ϵȰ�(endchar)
	            end++;	//�׸��� ��ĭ ������Ŵ.
	            
	            //c2���� �����ϴ°�
	            while(counter > 2){
	                char cTemp = s.charAt(start);
	                map.put(cTemp, map.get(cTemp) - 1);
	                //startChar�� �ʿ��� ���� startĳ���Ϳ� -1�� ���ָ� ������(cTemp)
	                if(map.get(cTemp) == 0){	//��ŸƮĳ���ͷ� ���� �ְ� 0�̸�
	                    counter--;	//ī��Ʈ�� ���̳ʽ�.
	                }
	                start++;	//�׸��� ��ŸƮ������ ����.
	            }
	            len = Math.max(len, end-start);
	            //�� ���̸�ŭ end����Ʈ ���� ���� ��ŸƮ�����Ͱ� ����(�׸��� ����)
	        }
	        return len;
	    }
	
}