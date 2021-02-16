package swea;

import java.util.Scanner;

public class SWEA_1873_��ȣ��_��Ʋ�ʵ� {
  
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();  //�׽�Ʈ���̽�
  
        for (int t = 1; t <= TC; t++) {  //�� �Է�
            int H = sc.nextInt();
            int W = sc.nextInt();
  
            char[][] map = new char[H][W];  
  
            for (int i = 0; i < H; i++) {
                map[i] = sc.next().toCharArray();   //char �Է��ϴ°ſ��� ���� ���
            }
  
            int x = 0;
            int y = 0;
  
            // map ���.
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
//                  System.out.print(map[i][j]);
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        x = i;
                        y = j;  //��ũ ó�� ��ġ(x,y)
                    }
                }
            }
            int N = sc.nextInt(); // ��ɾ� ����.
  
            char[] input =  sc.next().toCharArray(); //��ɾ� �Է��� �迭.
  
            for (int i = 0; i < N; i++) {
                if (input[i] == 'U') {
                    if (0 <= x-1 && map[x-1][y] == '.') {
                      
                        map[x][y] = '.';
                        x--;
                        map[x][y] = '^';
                    } else {
                        map[x][y] = '^';
                    }
                } else if (input[i] == 'D') {
                    if (x + 1 < H && map[x+1][y] == '.') {
                        map[x][y] = '.';
                        x++;
                        map[x][y] = 'v';
                    } else {
                        map[x][y] = 'v';
                    }
                } else if (input[i] == 'L') {
                    if (0 <= y-1 && map[x][y-1] == '.') {
                        map[x][y] = '.';
                        y--;
                        map[x][y] = '<';
                    } else {
                        map[x][y] = '<';
                    }
                } else if (input[i] == 'R') {
                    if (y+1 < W && map[x][y+1] == '.') {
                        map[x][y] = '.';
                        y++;
                        map[x][y] = '>';
                    } else {
                        map[x][y] = '>';
                    }
                } 
                    else if (input[i] == 'S') {
                      
                      
                    int tx = x;
                    int ty = y; //��ũ ��ġ ����κ� (�ؿ� �״�� x,y������ Ʋ�ȴ�)
   
                    if (map[tx][ty] == '^') {
                        while (0 <= tx-1 && map[tx][ty] != '#') {
                            tx--;
                            if (map[tx][ty] == '*') {
                                map[tx][ty] = '.';
                                break;
                            }
                        }
                    } else if (map[tx][ty] == 'v') {
                        while (tx+1 < H && map[tx][ty] != '#') {
                            tx++;
                            if (map[tx][ty] == '*') {
                                map[tx][ty] = '.';
                                break;
                            }
                        }
                    } else if (map[tx][ty] == '<') {
                        while (0 <= ty-1 && map[tx][ty] != '#') {
                            ty--;
                            if (map[tx][ty] == '*') {
                                map[tx][ty] = '.';
                                break;
                            }
                        }
                    } else if (map[tx][ty] == '>') {
                        while (ty+1 < W && map[tx][ty] != '#') {
                            ty++;
                            if (map[tx][ty] == '*') {
                                map[tx][ty] = '.';
                                break;
                            }
                        }
                    }
                }
            }
              
            System.out.printf("#%d ",t);
            // map ���.
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
  
    }
  
}