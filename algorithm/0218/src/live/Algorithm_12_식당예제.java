package live;

import java.util.Scanner;

//public class Algorithm_12_식당예제 {

import java.util.*;

 

public class Algorithm_12_식당예제{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        char [][] arr = new char[10003][10003];

        String tem;

        char aaa;

 

        for(int i=0; i<3; i++)

        {

            for(int j=0; j<5; j++)

            {

                tem = scan.next();

                aaa = (char)tem.charAt(0);

                arr[i][j] = aaa;

            }

        }

 

        for(int i=0; i<100; i++)

        {

            for(int j=0; j<100; j++)

            {

                System.out.printf("%c ", arr[i][j]);

            }

            System.out.println();

        }

    }

}
