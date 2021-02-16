package swea;

import java.util.Scanner;

public class SWEA_1873_상호의_배틀필드 {
  
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();  //테스트케이스
  
        for (int t = 1; t <= TC; t++) {  //맵 입력
            int H = sc.nextInt();
            int W = sc.nextInt();
  
            char[][] map = new char[H][W];  
  
            for (int i = 0; i < H; i++) {
                map[i] = sc.next().toCharArray();   //char 입력하는거에서 많이 헤멤
            }
  
            int x = 0;
            int y = 0;
  
            // map 출력.
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
//                  System.out.print(map[i][j]);
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        x = i;
                        y = j;  //탱크 처음 위치(x,y)
                    }
                }
            }
            int N = sc.nextInt(); // 명령어 갯수.
  
            char[] input =  sc.next().toCharArray(); //명령어 입력할 배열.
  
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
                    int ty = y; //탱크 위치 저장부분 (밑에 그대로 x,y넣으면 틀렸다)
   
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
            // map 출력.
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
  
    }
  
}