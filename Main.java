package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int id;
	public static String name;
	public static Student S = new Student();
	static StudentList SList = new StudentList();
	public static ArrayList<Student> arrMatch;
	private static Scanner input = new Scanner(System.in);
	static boolean exist = true;
	public static void main(String[] args) {
		do{
			System.out.println("\n\n\t********MENU*********");
			System.out.println("\t1. Them Sinh Vien");
			System.out.println("\t2. In DS Sinh Vien");
			System.out.println("\t3. Xoa sinh vien");
			System.out.println("\t4. Tim kiem Sv heo ID");
			System.out.println("\t5. Tim Kiem Sv theo Ten");
			System.out.println("\t6. Sap xep Sv theo Diem giam dan");
			System.out.println("\t7. Thoat");
			System.out.printf("\tChon:# ");
			int choice;
			choice = input.nextInt();
			if(choice<1||choice>8){
				System.out.printf("! Gia tri cua ban nhap vao phai trong khoang 1 -> 7");
				return;
			}
			switch(choice) {
				case 1: 
					addStudent();
					break;
				case 2:
					showList();
					break;
				case 3:
					removeStudent();
					break;
				case 4:
					findById();
					break;
				case 5:
					findByName();
					break;
				case 6:
					sortByMarks();
					break;
				case 7:
					exit();
					break;
				default:
					System.out.printf("\tSo nhap vao khong hop le");
					break;
			}
		}while(true);
	}
	public static boolean addStudent(){
		boolean exis = true;
		if(SList.isEmpty()){
			System.out.printf("\tBan co muon lay du lieu tu file khong? (1/2): ");
			int chon = input.nextInt();
			if(chon == 1){
					read();
					return false;
			}
		}else{
				do{
					SList.add(S.scanInfo());
					input.nextLine();
					System.out.printf("\tBan co nhap tiep khong ?(C/K): ");
					String choice = input.nextLine();
					if(choice.equalsIgnoreCase("k")){
						exis = false;
					}
				}while(exis==true);
			}
	
		return true;
	}
	public static void findById(){
			Student std = new Student();
			System.out.printf("\n\tNhap ID cua sinh vien can tim: ");
			id = input.nextInt();
			std = SList.findById(id);	
			if(std==null){
				System.out.printf("\n\tKhong tim thay sinh vien co ID: %d\n",id);
			}else{
				System.out.printf("\n\tThong tin cua sinh vien co ID: %d\n",id);
				System.out.println("");
				std.printInfo();
			}
		
	}
	public static void findByName(){
		if(!SList.isEmpty()){
			System.out.printf("\n\tNhap ten sinh vien can tim kiem: ");
			input.nextLine();
			name = input.nextLine();
			ArrayList<Student> arr = SList.findByName(name);
			if(arr.isEmpty()){
				System.out.printf("\tKhong tim thay sinh vien co ten la %s\n",name);
			}else{
				for (int i = 0; i < arr.size(); i++) {
					arr.get(i).printInfo();
				}
			}
		}
	}
	public static void removeStudent(){
		//while(exist){
			System.out.printf("\tNhap ID Sv can xoa: ");
			id = input.nextInt();
			//try{
				//id = Integer.parseInt(input.nextLine());
				//exist = false;
			//}catch(Exception e){
				//System.out.printf("\tLoi ! ID phai la so !");
			//}
		//}
		SList.remove(id);
	}
	public static void sortByMarks(){
		SList.sortByMarks();
		System.out.println("\n\tSap xep thanh cong !");
	}
	public static boolean showList(){
		System.out.println("\n\tDanh sach Sinh Vien: ");
		SList.showList();
		return false;
	}
	public static void file(){
		SList.createfile();
		System.out.println("\tGhi file thanh cong !");
	}
	public static void read(){
		SList.readfile();
		System.out.println("\tDoc file thanh cong !");
	}
	public static void exit(){
		System.out.printf("\tBan co muon luu ra file khong ?(1/2): ");
		int choice = input.nextInt();
		if(choice==1){
			file();
			System.exit(1);
		}else{
			System.exit(1);
		}
	}
}
