package Assignment;
import java.util.Scanner;
public class Student{
	public int id;
	public String firstName;
	public String lastName;
	public double mark;
	public Scanner input;
	
	public Student(){}
	public Student(int id, String firstName, String lastName, double mark){
		this.id = id; 
		this.firstName = firstName;  
		this.lastName = lastName; 
		this.mark = mark;
	}
	public Student scanInfo(){
		boolean exist = true;
		input = new Scanner(System.in);
		System.out.println("\n\t*****NHAP THONG TIN SINH VIEN*****");
		while(true){	
			while(exist){
				System.out.printf("\tID: ");
				try{
					this.id = Integer.parseInt(input.nextLine());
					exist = false;
				}catch(NumberFormatException e){
					System.out.printf("\tLoi ! ID phai la so !");
				}
			}
			System.out.printf("\tFirst Name: ");
			this.firstName = input.nextLine();
			System.out.printf("\tLast Name: ");
			this.lastName = input.nextLine();
			while(!exist){
				System.out.printf("\tMark: ");
				try{
					this.mark = Double.parseDouble(input.nextLine());
					exist = true;
				}catch(NumberFormatException e){
					System.out.printf("\tLoi ! Diem phai la so !");
				}
			}
			return new Student(id, firstName,lastName,mark);
		}
	}

	public int getID(){
		return id;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public double getMark(){
		return mark;
	}
	public void printInfo(){
		String fullName = new String(getFirstName()+ " " +getLastName());
		System.out.printf("\n\tID:\t %2d \tName: \t%s \tMark:\t\t %2.2f",getID(),fullName,getMark());
	}
}






