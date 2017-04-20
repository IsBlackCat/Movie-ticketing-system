package traning2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Cinema {
	
	public Cinema() {
		try {
			this.Read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Scanner sc = new Scanner(System.in);
	//保存正在上映的电影
	private List<Movie> movies = new ArrayList<Movie>();
	//读取数据
	public void Read() throws Exception{
		ReadAndWriteData.read(this.movies);
	}
	//保存数据
	public void Write() throws Exception {
		ReadAndWriteData.write(this.movies);
	}
	//添加,删除上映的电影，管理员权限
	public void addMovie() {
		Movie m = new Movie();
		m.initial();
		movies.add(m);
		System.out.println("电影添加成功！");
	}
	public void delMovie() {
		queryMovie();
		System.out.println("请输入要删除的电影的序号：");
		int option = sc.nextInt();
		Movie t = movies.remove(option);
		System.out.println(t.getName()+"删除成功！");
	}
	public void queryMovie() {
		int n = this.movies.size();
		for(int i = 0; i < n; i++) {
			System.out.println(i+", "+this.movies.get(i).getName());
		}
	}

	
	public String buyTicket() {
		Scanner sc = new Scanner(System.in);
		System.out.println("当前正在上映的电影：");
		int n = this.movies.size();
		for(int i = 0; i < n; i++) {
			System.out.println(i+", "+this.movies.get(i).getName());
		}
		System.out.println("请输入电影的序号：");
		int index = sc.nextInt();
		String movieName = this.movies.get(index).getName();
		System.out.println("--------------------");
		System.out.println("最近排片情况");
		Movie m = this.movies.get(index);
		n = m.time.size();
		for(int i = 0; i < n; i++) {
			System.out.println(i+", "+m.time.get(i).getTime());
		}
		System.out.println("请输入片场的序号：");
		index = sc.nextInt();
		Time t = m.time.get(index);
		n = t.pos.p.size();
		for(int i = 0; i < n; i++) {
			System.out.println(i+", "+t.pos.printP(i));
		}
		System.out.println("--------------------");
		System.out.println("请输入你要订购的座位序号：");
		index = sc.nextInt();
		if(t.pos.isSell(index)) {
			System.out.println("该票已经出售。");
		}else{
			t.pos.sellPos(index);
			System.out.println("购买成功。");
		}
		return movieName;
	}
	
}
