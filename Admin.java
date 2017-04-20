package traning2;

import java.util.Scanner;

public class Admin {
	Scanner sc = new Scanner(System.in);
	private String account = "admin";
	private String password = "admin";
	private Cinema cinema = new Cinema();
	
	public void setAccount() {
		System.out.println("*************修改信息中*************");
		System.out.println("请输入新的用户名");
		String account = sc.next();
		this.account = account;
		System.out.println("用户名修改成功");
	}
	public void getAccount() {
		System.out.println("*************查询信息中*************");
		System.out.println("当前用户名为"+this.account);
	}
	public void setPassword() {
		System.out.println("*************修改信息中*************");
		System.out.println("请输入新的密码");
		String password = sc.next();
		System.out.println("请再次输入密码");
		String t = sc.next();
		if(account.equals(t)) {
			this.password = password;
			System.out.println("修改密码成功");
		}else {
			System.out.println("修改密码失败，前后不一致");
		}
	}
	public void getPassword() {
		System.out.println("*************查询信息中*************");
		System.out.println("当前密码为"+this.password);
	}
	
	
	public String getAccountConfirm() {
		return this.account;
	}
	public String getPasswordConfirm() {
		return this.password;
	}
	public void addMovie() {
		System.out.println("*************添加电影中*************");
		cinema.addMovie();
	}
	
	public void delMovie() {
		System.out.println("*************删除电影中*************");
		cinema.delMovie();
	}
	
	public void queryMovie() {
		System.out.println("*************查询信息中*************");
		System.out.println("播放电影列表");
		cinema.queryMovie();
	}
	public void printMenu() {
		int flag = 1;
		while(flag == 1) {
			System.out.println("*************管理员操作界面*************");
			System.out.println("1, 修改管理员帐户名");
			System.out.println("2, 修改管理员密码");
			System.out.println("3， 查询管理员帐户名");
			System.out.println("4, 查询管理员密码");
			System.out.println("5, 添加影院电影");
			System.out.println("6, 删除影院电影");
			System.out.println("7, 查询电影列表");
			System.out.println("0, 退出系统");
			System.out.println("请输入选择操作的序号：");
			int option = sc.nextInt();
			
			switch(option) {
			case 1 : this.setAccount();break;
			case 2 : this.setPassword();break;
			case 3 : this.getAccount();break;
			case 4 : this.getPassword();break;
			case 5 : this.addMovie();break;
			case 6 : this.delMovie();break;
			case 7 : this.queryMovie();break;
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
