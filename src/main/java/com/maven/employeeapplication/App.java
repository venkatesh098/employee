package com.maven.employeeapplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Scanner;

import com.mave.employeepro.service.EmployeeServiceImpl;
import com.maven.employeepro.employeeDTO.EmployeeDTO;

/**
 * Hello world!
 *
 */
//Assignment to create,update,get all employees and get by employee id
public class App 
{
    public static void main( String[] args )
    {
    	
    	
        System.out.println( "Hello World!" );
        
        List<EmployeeDTO> c = new ArrayList<EmployeeDTO>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do{
           System.out.println("------operations-----");
           System.out.println("1.Add Employee");
           System.out.println("2.Update An Employee");
           System.out.println("3.Get By Employee Id");
           System.out.println("4.Get All Employees");
           System.out.println("5.Delete An Employee");
           System.out.print("Enter Which You Want To Perform Action : ");
           ch = s.nextInt();

           switch(ch){
              case 1:
                 System.out.print("Enter Emp Id : ");
                 int eno = s.nextInt();
                 System.out.print("Enter Emp Name : ");
                 String ename = s1.nextLine();
                 System.out.print("Enter Salary : ");
                 Double salary = s.nextDouble();

                 c.add(new EmployeeDTO(eno,ename,salary));
              break;
              case 2:
            	  Boolean exist = false;
                 System.out.print("Enter Empno to Update :");
                 Integer empid = s.nextInt();
                 
                 ListIterator<EmployeeDTO>li = c.listIterator();
                 while(li.hasNext()){
                	 EmployeeDTO e = li.next();
                    if(e.getEmpId() == empid)  {
                       System.out.print("Enter new Employee Name : ");
                       ename = s1.nextLine();

                       System.out.print("Enter new Salary : ");
                       salary = s.nextDouble();
                       li.set(new EmployeeDTO(empid,ename,salary));
                       exist = true;
                    }
                 }
                 
                 if(!exist){
                    System.out.println("Employee Not Found");
                 }else{
                    System.out.println("Successfully Updated Employee Record");
                 }
              
              break; 
              case 3:
                 exist = false;
                 System.out.print("Enter employee id to get data:");
                 empid = s.nextInt();
                 System.out.println("----------------------------");
                 Iterator<EmployeeDTO>  i = c.iterator();
                 while(i.hasNext()){
                	 EmployeeDTO e = i.next();
                    if(e.getEmpId() == empid)  {
                       System.out.println(e);
                       exist = true;
                    }
                 }
                 
                 if(!exist){
                    System.out.println("Employee id doesn't exists");
                 }
                 System.out.println("----------------------------");
              break;
              case 4:
                  System.out.println("----------------------------");
                  i = c.iterator();
                  while(i.hasNext()){
                 	 EmployeeDTO e = i.next(); 
                     System.out.println(e);
                  }
                  System.out.println("----------------------------");
               break;
     
           }
        }while(ch!=0);
   //  }
        
     
//        EmployeeServiceImpl empServiceImpl = new EmployeeServiceImpl();
//        EmployeeDTO employee = new EmployeeDTO(10,"venki",100.000);
//        
//        Optional <EmployeeDTO> addingEmployee = empServiceImpl.addEmployee(employee);
//        
//        if(addingEmployee.isPresent()) {
//        	System.out.println("Employee added successfully");
//        }
//        //get employees
//        
//        List<EmployeeDTO> employees = empServiceImpl.getEmployees();
    }
}
