package Assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Iterator;
import java.io.*;

public class StudentList {
	private Scanner input = new Scanner(System.in) ;
	public static ArrayList<Student> arrStudents;
	public static ArrayList<Student> arrMatch;
	boolean exist = false;
	
	public StudentList(){
		arrStudents = new ArrayList<Student>();
	}
	public void add(Student std){
		arrStudents.add(new Student(std.getID(),std.getFirstName(),std.getLastName(),std.getMark()));
	}
	//Xoa sinh vien co id nhap vao
	public void remove(int id){
			for( Iterator<Student> it = arrStudents.iterator(); it.hasNext() ; )
			{
				Student std = it.next();
				if( std.getID() == id)
				{
					System.out.printf("\tBan co chac la xoa khong ?(C/K): ");
					String choice = input.nextLine();
					if(choice.equalsIgnoreCase("c")){
						it.remove();
						exist = true;
					}
				}
			}
			if(exist == false){
				System.out.printf("\tKhong tim thay sinh vien co ma %d trong danh sach !",id);
			}else{
				System.out.println("\tXoa thanh cong !");
			}
	}
	//Tim kiem theo ID
	public Student findById(int id){
		Student s = null;
		for(Student std: arrStudents){
			if(std.getID() == id){
				s = std;
			}
		}
		return s;
	}
	//Tim kiem theo ten --> tra ve mot arraylist sinh vien
	public ArrayList<Student> findByName(String name){
		arrMatch = new ArrayList<Student>();
		for(Student s:  arrStudents){
			String fullName = new String(s.getFirstName() + " " + s.getLastName()).toLowerCase();
			if(fullName.matches("(.*)" + name.toLowerCase() + "(.*)")/*fullName.trim().contains(name.trim())*/){
				arrMatch.add(s);
			}
		}
		return arrMatch;
	}
	//Sap xep sinh vien
	public void sortByMarks(){
		Collections.sort(arrStudents, new Comparator<Student>() {
			public int compare(Student std1, Student std2) {
				return new Double(std2.getMark()).compareTo(std1.getMark());
			}
		});
	}
	
	//check
	
	public boolean isEmpty(){
		if(arrStudents.isEmpty()){
			System.out.println("\n\tChua co Sinh Vien nao trong DS !");
			return true;
		}
		return false;
	}
	//Hien thi danh sach sinh vien
	public void showList(){
		if(arrStudents.isEmpty()){
			System.out.println("\tChua co Sinh Vien nao trong DS !");
		}
		for(Student std: arrStudents){
			std.printInfo();
		}
	}
	public void showList(ArrayList<Student> arrMatch){
		for(Student st: arrMatch){
			st.printInfo();
		}
	}
	public void createfile(){
		createFile create = new createFile();
		create.openFile();
		create.addRecords();
		create.closeFile();
	}
	public void readfile(){
		readFile read = new readFile();
		read.openFile();
		read.readfile();
		read.closeFile();
	}
	public class createFile{
		private Formatter x;
		public void openFile(){
			try{
				x = new Formatter("student.txt");
			}catch(Exception e){
				System.out.println("\tYou have an error");
			}
		}
		public void addRecords(){
			for(Student std: arrStudents){
				x.format("%d\t%s\t%s\t%f\n",std.getID(),std.getFirstName(),std.getLastName(),std.getMark());
			}
		}
		public void closeFile(){
			x.close();
		}
	}
	public class readFile {
		private Scanner x;
		public readFile(){}
		public void openFile(){
			try{
				x = new Scanner(new File("student.txt"));
			}catch(Exception e){
				System.out.println("\tcould not find file");
			}
		}
		public void readfile(){
			while(x.hasNext()){
				int a = x.nextInt();
				String b = x.next();
				String c = x.next();
				Double d = x.nextDouble();
				arrStudents.add(new Student(a,b,c,d));
			}
		}
		public void closeFile(){
			x.close();
		}
	}
}
