package traning2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Movie {
	private String name;
	List<Time> time = new ArrayList<Time>();
	
	public void initial() {
		Scanner sc = new Scanner(System.in);
		System.out.println("添加的电影名：");
		String name = sc.next();
		this.name = name;
		System.out.println("该电影有多少个片场：");
		int n = sc.nextInt();
		System.out.println("请依次输入片场时间：");
		for(int i = 0; i < n; i++) {
			Time t = new Time();
			t.initial();
			this.time.add(t);
		}
	}
	
	public void setMovie(BufferedReader br) {
		try {
			this.name = br.readLine();
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++) {
				Time t = new Time();
				t.time = br.readLine();
				int n2 = Integer.parseInt(br.readLine());
				for(int j = 0; j < n2; j++) {
					t.pos.p.add(br.readLine());
				}
				this.time.add(t);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void getMovie(BufferedWriter bw) {
		try {
			bw.write(this.name);
			bw.newLine();
			bw.write(this.time.size()+"");
			bw.newLine();
			int n = this.time.size();
			for(int i = 0; i < n; i++) {
				bw.write(this.time.get(i).getTime());
				bw.newLine();
				int m = this.time.get(i).pos.p.size();
				bw.write(m+"");
				bw.newLine();
				for(int j = 0; j < m; j++) {
					bw.write(this.time.get(i).pos.p.get(j));
					bw.newLine();
				}
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void addTime() {
		time.add(new Time());
		System.out.println("添加片场成功");
	}
	
}
