

import java.util.*;
import java.text.*;

class Question {
	String qstn;
	String ans;
	public Question(String qstn,String ans){
		this.qstn=qstn;
		this.ans=ans;
	}
}
class Quizz{
	public static ArrayList<String> cour = new ArrayList<String>() {
		{
		add("java");
		add("html");
		add("python");
		}
	};
	public static List<Question> qstn=new ArrayList<Question>();
	
	public static ArrayList<String> attmpts = new ArrayList<String>();

	public static void removeCourse(String cName) {
		String cn=cName.toUpperCase();
		cour.remove(cName);
	}
	public static void addCourse(String cName) {
		cour.add(cName);
		System.out.println("List of courses avilable are:"+cour);
	}
	public static void dispCourse() {
		System.out.println(cour);
	}
	public static void myAttempts() {
//		String board="Score Board";
		System.out.printf("%40s","Score Board");
		System.out.println();
		System.out.print("Course" +"\t"+"Score");
		System.out.println();
		if(attmpts.size()==0) {
			System.out.println("Ooooops...! You have not attempted any Quiz yet..Come on Start it TODAY.");
		}
		else {
		for(int i=0;i<attmpts.size();i++) {
			System.out.println(attmpts.get(i));
		}
		}
		
	}
	public static void addQuiz() {
		
		Scanner s=new Scanner(System.in);
		if((cour.get(cour.size()-1))!="java"&&cour.get(cour.size()-1)!="python"&&cour.get(cour.size()-1)!="html"){
		System.out.println("How many questions you want to add to: "+cour.get(cour.size()-1));
		int n=s.nextInt();
		s.nextLine();
		for(int i=1;i<=n;i++) {
			System.out.println("Enter Question "+i);
			String q=s.nextLine();
			System.out.println("Enter answer for question "+i);
			String a=s.nextLine();
			qstn.add(new Question(q, a));
			
		}
		}
		else {
			System.out.println("Please add a Course before adding Quiz");
		}
	}
	public static void attemptQuiz(String x) {
		if((x.equalsIgnoreCase("java")||x.equalsIgnoreCase("html")||x.equalsIgnoreCase("python"))&&cour.contains(x)) {
		if(x.equalsIgnoreCase("java")) {
			String q1="Which of the following is a reserved keyword in Java?\n"
					+ "(a)switch\t(b)if";
			String q2="Which keyword is used for accessing the features of a package?\n"
					+"(a)package\t(b)import";
					
			Question [] qstns= {
			
					new Question(q1,"ab"),
					new Question(q2,"b"),
			};
			String sk=x+"\t"+taketest(qstns);
			attmpts.add(sk);
		}
		if(x.equalsIgnoreCase("html")) {
			String q1="What is full form of HTML?\n"
					+ "(a)Hyper Text Markup Language\t(b)Hyper Test Multiply Language";
			String q2="Why Html is used?\n"
					+"(a)Build web pages\t(b)Write java code";
					
			Question [] qstns= {
			
					new Question(q1,"a"),
					new Question(q2,"a"),
			};
			String sk=x+"\t"+taketest(qstns);
			attmpts.add(sk);
		}
		if(x.equalsIgnoreCase("python")) {
			String q1="Who developed the Python language??\n"
					+ "(a)Guido von Rossum\t(b)Shanmukha Srinivas";
			String q2="Which one of the following is the correct extension of the Python file?\n"
					+"(a).python\t(b).py";
					
			Question [] qstns= {
			
					new Question(q1,"a"),
					new Question(q2,"b"),
			};
			String sk=x+"\t"+taketest(qstns);
			attmpts.add(sk);
		}
	}
		else {
			if(cour.contains(x)){
				
				String sk=x+"\t"+taketest(qstn);
				attmpts.add(sk);
			}
			else {
				System.out.println("No such test Created by your teacher");
			}
		}
	}
	
	public static int taketest(Question[] qstns) {
		int s=0;
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<qstns.length;i++) {
			System.out.println(qstns[i].qstn);
			System.out.println("Please enter your answer:"+"\t\t"+"Hint:-if a then enter a,if two or more options enter abc");
			String a=sc.nextLine();
			if(a.equals(qstns[i].ans)) {
				s=s+10;
			}
		}
		System.out.println("Your Score is:"+s+"/"+qstns.length*10);
		if(s<20) {
			System.out.println("Don\'t get discouraged TRY AGAIN");
		}
		else {
			System.out.println("Cheeeeeseee...! You got all answers..");
		}
		return s;
	}
	public static int taketest(List<Question> qstns) {
		int s=0;
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<qstns.size();i++) {
			System.out.println(qstns.get(i).qstn);
			System.out.println("Please enter your answer:"+"\t\t"+"Hint:-if a then enter a,if two or more options enter abc");
			String a=sc.nextLine();
			if(a.equals(qstns.get(i).ans)) {
				s=s+10;
			}
		}
		System.out.println(s+"/"+qstns.size()*10);
		if(s<qstns.size()*10) {
			System.out.println("Don\'t get discouraged TRY AGAIN");
		}
		else {
			System.out.println("Cheeeeeseee...! You got all answers..");
		}
		return s;
	}
}

public class mains extends Quizz {
	
	public static String greeting() {
		Calendar now = Calendar.getInstance();
	    int time=now.get(Calendar.HOUR_OF_DAY);
	    if(time>3 && time<12) {
	    	return "Good Morning!";
	    }
	    else if(time>=12 && time<17) {
	    	return "Good Afternoon!";
	    }
	    else if(time>=17 && time<22) {
	    	return "Good Evening!";
	    }
	    else {
	    	return "Good Night!";
	    }
	}
	

	
	public static void main(String[] args) {

		ArrayList<String> Teachers = new ArrayList<String>();
		ArrayList<String> Students = new ArrayList<String>();
		String lo;
		int tm=0;
		Teachers.add("Navigus");
		
		Students.add("Shanmukh");
		Students.add("Ginny");
try {
		Scanner sc = new Scanner(System.in);
		do {
		System.out.printf("%40s","NAVIGUS\n");
		System.out.println("Who you are: Teacher or Student..?");
		System.out.println("1 : Teacher \n2 : Student");
		System.out.println("Enter \"1\"  or \"2\"");
		
		int ck=sc.nextInt();
		sc.nextLine();
		Tch:
		if(ck==1) {
			
			do {
			System.out.println(" Welcome to NAVIGUS teacher Portal...!");
			System.out.println("Enter your name:");
			
				
			String Tchrsname = sc.nextLine();
			if(Teachers.contains(Tchrsname)) {
				do {
					
				System.out.println(greeting()+"  "+Tchrsname);
				System.out.println("Functions Available for teacher are:\n"
						+ "1 : Add a Course\n"
						+ "2 : Remove a course\n"
						+ "3 : Add Quiz to Added course\n"
						+ "4 : Display courses\n"
						+ "5 : Exit");
				System.out.println("------\"Enter your Choice\"------");
				int choice=sc.nextInt();
				sc.nextLine();
				Quizz q= new Quizz();
				if(choice==1) {
					System.out.println("Enter the name of the course you want to add:");
					String cname=sc.nextLine();
					addCourse(cname);
				}
				else if(choice==2) {
					System.out.println("Enter the name of the course you want to \"Remove\":");
					String cname=sc.nextLine();
					if(cour.contains(cname)) {
						removeCourse(cname);
						System.out.println("Updtaed course list is "+ cour);
					}
					else {
						System.out.println("Their is no such course to remove...!");
					}
				}
				else if(choice==3) {
					addQuiz();
				}
				else if(choice==4) {
//					dispCourse();
					System.out.println("List of avilable courses are");
					for(int i=0;i<cour.size();i++) {
						System.out.print(cour.get(i)+"\t");
					}
					System.out.println();
				}
				else if(choice==5) {
					break Tch;
				}
				System.out.println("Enter \"Yes\" to go to Teacher home page ");
				lo=sc.nextLine();
				
			}while(lo.charAt(0)=='Y'||lo.charAt(0)=='y');}
			else {
				tm++;
				if(tm>2) {
					System.out.println("Limit exceeded");
					break Tch;
				}
				System.out.println("Sorry...! We can't find you.");
				System.out.println("Enter \"Yes\" to try again \nOnly 3 attempts allowed");
			}
			
			lo=sc.nextLine();

		}while(lo.charAt(0)=='y'||lo.charAt(0)=='Y');}
		
		else if(ck==2) {
			System.out.println(greeting()+ " Welcome to NAVIGUS Student Portal...!");
			do {
			System.out.println("Enter your name:");
			 String Stdntsname = sc.nextLine();
			if(Students.contains(Stdntsname)) {
			
					
				System.out.println(greeting()+"  "+Stdntsname);
				do {
				System.out.println("Functions Available for Students are:\n"
						+ "1 : Display courses\n"
						+ "2 : Take Quiz\n"
						+ "3 : My Attempts\n"
						+ "4 : Exit");
				System.out.println("------\"Enter your Choice\"------");
				int choice=sc.nextInt();
				sc.nextLine();
				if(choice==1) {
//					dispCourse();
					System.out.println("List of avilable courses are");
					for(int i=0;i<cour.size();i++) {
						System.out.print(cour.get(i)+"\t");
					}
					System.out.println();
				}
				else if(choice==2) {
					System.out.println("List of avilable courses are");
					for(int i=0;i<cour.size();i++) {
						System.out.print(cour.get(i)+"\t");
					}
					System.out.println();
					
					System.out.println("Enter Course name to attempt");
					
					String vb=sc.nextLine();
//					sc.nextLine();
					attemptQuiz(vb);
				}
				else if(choice==3) {
					myAttempts();
				}
				else if(choice==4) {
					break Tch;
				}
				System.out.println("Enter \"Yes\" to go to Student home page ");
				lo=sc.nextLine();
				
			}while(lo.charAt(0)=='Y'||lo.charAt(0)=='y');}
			else{
				System.out.println("Sorry we cant find you..!");
				System.out.println("Enter \"Yes\" to try again \n");
			}
			
			lo=sc.nextLine();

		}while(lo.charAt(0)=='y'||lo.charAt(0)=='Y');}
			

		System.out.println("Enter \"Main\" to go to main page or \"Exit\" to exit application");
		lo=sc.nextLine();
		}while(lo.charAt(0)=='m'||lo.charAt(0)=='M');
		
		System.out.println("\tQuiz application Created by \"Shanmukha Srinivas\"\n\t\t\tThank You.");
}
catch(InputMismatchException e) {
	System.out.println("Enter a valid input..!");
}
catch(Exception e) {
	System.out.println("Error..!");
}
		
	}	

	}
	

		


