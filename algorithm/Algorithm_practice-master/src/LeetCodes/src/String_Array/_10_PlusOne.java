package String_Array;

public class _10_PlusOne {

	
	public static void main(String[] args) {
//		int[] digits = {1,2,3};
//		int[] digits = {9,9,9};
//		int[] digits = {9,8,9};
//		int[] digits = {8,9,9};
		int[] digits = {0,0,1};
//		int[] digits = {0,0};
//		int[] digits = {9,0,0,9};
		
		int[] result = plusOne2(digits);
		for (int i : result)
			System.out.println("val: " + i);
	}
	
	  public static int[] plusOne2(int[] digits) //digit����� �ε��� �˾Ƴ���.
	    {
	        int carry = 1;	//ĳ���� �Ѿ�°�
	        int index = digits.length - 1;	//�ε��� �˾Ƴ���
	        
	        // for, while
	        while (index >= 0 && carry > 0)
	        {
	            digits[index] = (digits[index] + carry) % 10;	//�̺κ��� �ٽ�(������)
	            //10�̸� 0�� �� �׸���  carry = 1 �ǰ�
	            
	            if(digits[index]==0) {	//���� 0�̸� carry�� 1�� �����(�ö󰡴� ��)
	            	carry =1;
	            }else {
	            	carry =0;
	            }
	            index--;	//�ε����� ��ĭ ���ش�.
	        }
	        //�ٵ� ���⼭ 999�� 000�� ���´�.
	        
	        if (carry > 1)	//0,0,1 �� �־����� 1 0 0 2�� �Ǵ� ��� ����.
	       //if (carry == 1)	
	        {
	            digits = new int[digits.length + 1];	//�ʱ�ȭ�� �� ����.
//	            {0,0,0,0}
	            digits[0] = 1;
	        }
	        
	        return digits;
	    }
}