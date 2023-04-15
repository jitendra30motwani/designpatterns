/**
 * 
 */
package designpattern.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 91978
 *
 *Builder is a creational design pattern that lets you create complex objects step by step.
 *
 *https://refactoring.guru/design-patterns/builder
 *
 *
 */
public class BuilderDesignPatternExample {

	/**
	 * 
	 */
	public BuilderDesignPatternExample() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client(new Director(new EngineerStudentBuilder()));
		Student s1 = client.director.createStudent();
		
		System.out.println(s1);
		
		client = new Client(new Director(new MBAStudentBuilder()));
		Student s2 = client.director.createStudent();
		
		System.out.println(s2);
	}

}

class Student{
	
	int rollno;
	
	int age;
	
	String name;
	
	List<String> subjects;
	
	public Student(StudentBuilder builder) {
		this.rollno = builder.rollno;
		this.age = builder.age;
		this.name = builder.name;
		this.subjects = builder.subjects;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", age=" + age + ", name=" + name + ", subjects=" + subjects + "]";
	}
	
	
	
}

abstract class StudentBuilder{
	
	
	int rollno;
	
	int age;
	
	String name;
	
	List<String> subjects;
	
	StudentBuilder setRollNo(int rollNo) {
		this.rollno=rollNo;
		return this;
	}
	
	StudentBuilder setAge(int age) {
		this.age=age;
		return this;
	}
	
	StudentBuilder setName(String name) {
		this.name=name;
		return this;
	}
	
	abstract StudentBuilder setSubjects();
	
	public Student build() {
		return new Student(this);
	}

	@Override
	public String toString() {
		return "StudentBuilder [rollno=" + rollno + ", age=" + age + ", name=" + name + ", subjects=" + subjects + "]";
	}
	
	
}

class EngineerStudentBuilder extends StudentBuilder{

	@Override
	StudentBuilder setSubjects() {
		// TODO Auto-generated method stub
		List<String> subs = new ArrayList<String>();
		subs.add("Maths");
		
		this.subjects = subs;
		
		return this;
	}
	
	
}


class MBAStudentBuilder extends StudentBuilder{

	@Override
	StudentBuilder setSubjects() {
		// TODO Auto-generated method stub
		List<String> subs = new ArrayList<String>();
		subs.add("Eco");
		
		this.subjects = subs;
		
		return this;
	}
	
	
}

class Director{
	
	StudentBuilder builder;
	
	public Director(StudentBuilder builder) {
		this.builder = builder;
	}
	
	public Student createStudent() {
		
		if(builder instanceof EngineerStudentBuilder) {
			return createEngineerStudent();
		}else {
			return MBAEngineerStudent();
		}
		
	}

	private Student MBAEngineerStudent() {
		// TODO Auto-generated method stub
		return builder.setRollNo(1).setName("A").setAge(22).setSubjects().build();
	}

	private Student createEngineerStudent() {
		// TODO Auto-generated method stub
		return builder.setRollNo(1).setName("B").setSubjects().build();
	}
	
}

class Client{
	
	Director director;
	
	public Client(Director director) {
		this.director=director;
	}
	
}