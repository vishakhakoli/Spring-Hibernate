package com.spring.orm;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;



public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
       StudentDao studentdao = context.getBean("studentDao",StudentDao.class);
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
      
       boolean exit=true;
       
       while(exit)
       {
	       System.out.println("***************Welcome**************");
	       System.out.println("Press 1 to add student record.");
	       System.out.println("Press 2 to display all students record.");
	       System.out.println("Press 3 to get student record.");
	       System.out.println("Press 4 to delete student record.");
	       System.out.println("Press 5 to update student record.");
	       System.out.println("Press 6 to exit");
	       System.out.print("Enter your choice : ");
       
	       try
	       {
	    	   int input = Integer.parseInt(br.readLine());
	    	   switch(input)
	    	   {
	    	   case 1:
	    		   //Adding student
	    		   Student student = new Student();
	    		   System.out.print("Enter Student ID : ");
	    		   int studentId = Integer.parseInt(br.readLine());
	    		   System.out.print("Enter Student Name : ");
	    		   String studentName = br.readLine();
	    		   System.out.print("Enter Student City : ");
	    		   String studentCity = br.readLine();
	    		   
	    		   student.setStudentId(studentId);
	    		   student.setStudentName(studentName);
	    		   student.setStudentCity(studentCity);
	    		   
	    		   studentdao.insert(student);
	    		   
	    		   break;
	    	   case 2:
	    		   //display all students record
	    		   List<Student> allStudents =studentdao.getAllStudent();
	    		   for(Student s : allStudents)
	    		   {
	    			   System.out.println("Id : "+s.getStudentId());
	    			   System.out.println("Name : "+s.getStudentName());
	    			   System.out.println("City : "+s.getStudentCity());
	    			   System.out.println("---------------------------------------");
	    		   }
	    		   break;
	    		   
	    	   case 3:
	    		   //get single student record
	    		   System.out.print("Enter Student ID : ");
	    		   int studId = Integer.parseInt(br.readLine());
	    		   Student st= studentdao.getStudent(studId);
	    		   System.out.println("Id : "+st.getStudentId());
    			   System.out.println("Name : "+st.getStudentName());
    			   System.out.println("City : "+st.getStudentCity());
	    		   break;
	    		   
	    	   case 4:
	    		   //delete student record
	    		   System.out.print("Enter Student ID : ");
	    		   int sId = Integer.parseInt(br.readLine());
	    		    studentdao.deleteStudent(sId);
	    		   break;
	    		   
	    	   case 5:
	    		   //update student record
	    		   break;
	    		   
	    	   case 6:
	    		   exit=false;
	    		   break;
	    	   }
	    	   
	       }
	       catch (Exception e) {
			
	    	   System.out.println("Inavlid input try another one !!!");
	    	   System.out.println(e.getMessage());
	       }
	       finally {
	    	   System.out.println("Thank you !!");
	       }
       }
       
    }
}
