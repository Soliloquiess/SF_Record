package Jungol;

import java.util.Scanner;

public class Jungol_1733_���� {

static int om[][] =new int[19][19];
static Scanner sc = new Scanner(System.in);

static int win, win_x, win_y;
public static void main(String[] args) {
	

//	Scanner sc = new Scanner(System.in);
//	void scan(void); //�Է� �޴� �Լ�
//	void search(void); //���и� �Ǵ��ϴ� �Լ�
//	int go(int x, int y); //���� ���� �밢�� �Ǵ�
	
	 	{
	    //�������� �̰��� ��� 1, ����� �̰��� ��� 2
	  
	    scan();
	    search();
	  
	    System.out.printf("%d\n", win);
	    if(win!=0)
	    	System.out.printf("%d %d", win_x, win_y);
		}
	}
	private static void scan()
	{
	    int i, j;
	  
	    for(i=0; i<19; i++)
	    {
	        for(j=0; j<19; j++)
//	            scanf(" %d", &om[i][j]);
	        	om[i][j] = sc.nextInt();
	    }
	}
	private static void search()
	{
	    int i, j, a;
	  
	    for(i=0; i<19; i++)
	    {
	        for(j=0; j<19; j++)
	        {
	            if(i>14 && j>14)
	                break;
	  
	            else if(om[i][j]!=0)
	            {
	                a=go(i, j);
	  
	                if(a!=0)
	                {
	                    win=a;
	                    win_x=i+1;
	                    win_y=j+1;
	                    break;
	                }
	            }
	        }
	    }
	}
	private static int go(int x, int y)
	{
	    int i, j, h, a=0;
	    h=om[x][y]; //��� Ȥ�� ������ 
	  
	    for(i=x+1; i<=(x+5) && i<19; i++) //������ �Ǵ� 
	    {
	        if(om[i][y]!=h) //���� ���� �ٵϵ��� �������� ���� ���
	            break;
	  
	        a++;
	    }
	    if(a==4) //5���� �ٵϾ��� �� ���
	    {
	        if(om[x-1][y]!=h) //�������� �ƴ� ���
	            return h;
	    }
	  
	    a=0;
	    for(j=y+1; j<=(y+5) && j<19; j++) //������ �Ǵ�
	    {
	        if(om[x][j]!=h) //���� ���� �ٵϵ��� �������� ���� ���
	            break;
	  
	        a++;
	    }
	    if(a==4) //5���� �ٵϾ��� �� ���
	    {
	        if(om[x][y-1]!=h) //�������� �ƴ� ���
	            return h;
	    }
	  
	    a=0;
	    for(i=x+1, j=y+1; i<=(x+5) && i<19 && j<19; i++, j++) //������ �Ʒ� ���� �밢�� �Ǵ� 
	    {
	        if(om[i][j]!=h) //���� ���� �ٵϵ��� �������� ���� ���
	            break;
	  
	        a++;
	    }
	    if(a==4) //5���� �ٵϾ��� �� ���
	    {
	        if(om[x-1][y-1]!=h) //�������� �ƴ� ��� 
	            return h;
	    }
	  
	    a=0;
	    for(i=x-1, j=y+1; i>=(x-5) && i>=0 && j<19; i--, j++) //������ �� ���� �밢�� �Ǵ� 
	    {
	        if(om[i][j]!=h) //���� ���� �ٵϵ��� �������� ���� ���
	            break;
	  
	        a++;
	    }
	    if(a==4) //5���� �ٵϾ��� �� ���
	    {
	        if(om[x+1][y-1]!=h) //�������� �ƴ� ��� 
	            return h;
	    }
	  
	    return 0;
	}
}
