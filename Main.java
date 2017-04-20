package traning2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("电影院购票系统");
		System.out.println("********************************");
		System.out.println("1, 管理员    2，学生");
		System.out.println("请选择登录身份：");
		int option = sc.nextInt();
		if(option == 1) {
			Admin admin = new Admin();
			System.out.println("请输入账户名：");
			String act = sc.next();
			System.out.println("请输入密码：");
			String pwd = sc.next();
			while(!(act.equals(admin.getAccountConfirm()) && pwd.equals(admin.getPasswordConfirm()))) {
				System.out.println("账户名不存在或密码错误");
				System.out.println("请再次输入账户名：");
				act = sc.next();
				System.out.println("请输入密码：");
				pwd = sc.next();
			}
			admin.printMenu();
		}else if(option == 2) {
			Student stu = new Student();
			stu.printMenu();
		}else {
			System.out.println("没有该选项，登陆失败");
		}
	}
}
