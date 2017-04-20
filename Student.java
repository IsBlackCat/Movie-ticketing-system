package traning2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
	//保存学生已购的票
	private List<String> ticket = new ArrayList<String>();
	private Cinema cinema = new Cinema();
	//查看所购的票
	public void checkTicket() {
		int n = this.ticket.size();
		System.out.println("*************您当前所购的票*************");
		if(ticket.size() == 0) {
			System.out.println("当前所购票为0。");
		}
		for(int i = 0; i < n; i++) {
			System.out.println(i+", "+ticket.get(i));
		}
	}
	
	public void buyTicket() {
		System.out.println("*************购票中*************");
		ticket.add(cinema.buyTicket());
	}
	
	public void printMenu() {
		int flag = 1;
		while(flag == 1) {
			Scanner sc = new Scanner(System.in);
			System.out.println("*************学生操作界面*************");
			System.out.println("1, 查看所购的票");
			System.out.println("2, 购票");
			System.out.println("0, 退出系统");
			System.out.println("请输入选择操作的序号：");
			int option = sc.nextInt();
			switch(option) {
			case 1 : this.checkTicket();break;
			case 2 : this.buyTicket();break;
			case 0 : flag = 0;break;
			default: System.out.println("没有该选项。");
			}
		}
		try {
			this.cinema.Write();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("你已退出购票系统");
	}
}
