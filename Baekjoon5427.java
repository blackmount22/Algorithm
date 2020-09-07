package baekjoonPjt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MapLocation5427{
	int x;
	int y;
	
	public MapLocation5427(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}

public class Baekjoon5427 {

	static char[][] map;
	static int[][] visit;
	static Queue<MapLocation5427> f;
	static Queue<MapLocation5427> sg;
	static int sec;
	static ArrayList<Object> result = new ArrayList<>();
	static int w;
	static int h;
	static int tc = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		tc = sc.nextInt();
		
		for(int i=0;i<tc;i++) {
			sec = 0;
			w = sc.nextInt();
			h = sc.nextInt();

			map = new char[w][h];
			visit = new int[w][h];
			
			f = new LinkedList<>();
			sg = new LinkedList<>();
			
			for(int j=0;j<h;j++) {
				String str = sc.next();
				for(int k=0;k<w;k++) {
					map[k][j] = str.charAt(k);
					
					// ����� ��ġ ����
					if(map[k][j] == '@') {
						sg.offer(new MapLocation5427(k, j));
						visit[k][j] = 1;
					} 
					// �� ��ġ ����
					else if(map[k][j] == '*') {
						f.offer(new MapLocation5427(k, j));
					}
				}
			}
			
			getBfs();
		}
		
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
	}

	public static void getBfs() {
		
		int[] xx = {-1,0,1,0};
		int[] yy = {0,1,0,-1};
		
		while(!sg.isEmpty()) {
			sec++;
			
			// 1�� ��, ���� �̵� ���� ó��
			int fireSize = f.size();
			for(int i=0;i<fireSize;i++) {
				int x = f.peek().x;
				int y = f.poll().y;
				
				for(int j=0;j<4;j++) {
					int ax = x + xx[j];
					int ay = y + yy[j];
					
					if(ax >=0 && ay >=0 && ax < w && ay < h && (map[ax][ay] == '@' || map[ax][ay] == '.')) {
						map[ax][ay] = '*';
						f.offer(new MapLocation5427(ax, ay));
					}
				}
			}
			
			// ����� �̵�
			int sangGeunSize = sg.size();			
			for(int i=0;i<sangGeunSize;i++) {
				int sangGeunX = sg.peek().x;
				int sangGeunY = sg.poll().y;
				
				// ������� ��ġ�� ���� ���� ��� Ż��
				if(sangGeunX == 0 || sangGeunY == 0 || sangGeunX == w-1 || sangGeunY == h-1) {
					result.add(sec);
					return;
				}
				
				for(int j=0;j<4;j++) {
					int ax = sangGeunX + xx[j];
					int ay = sangGeunY + yy[j];
					
					if(ax >=0 && ay >= 0 && ax < w && ay < h && map[ax][ay] == '.' && visit[ax][ay] == 0) {
						sg.offer(new MapLocation5427(ax, ay));
						map[ax][ay] = '@';
						visit[ax][ay] = 1;
					}
				}
			}
		}
		
		// ����� Ż�� ���� 
		result.add("IMPOSSIBLE");
	}
}
