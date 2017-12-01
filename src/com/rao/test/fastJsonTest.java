package com.rao.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.rao.entity.Student;
import com.rao.entity.Teacher;

public class fastJsonTest {

	public static void main(String[] args) {
		Student stu = new Student(0,"rao",25);
		System.out.println(JSON.toJSONString(stu));
		
		List<Student> students = new ArrayList<Student>();  
        for(int i=0;i<5;i++) {  
            Student stu02 = new Student(i, "Student" + i, 18 +i);   
            students.add(stu02);  
        }  
        System.out.println(JSON.toJSONString(students));
        
        
        
        List<Teacher> teaList = new ArrayList<Teacher>();  
        long time = System.currentTimeMillis();  
        for(int i=0;i<10;i++) {  
            Teacher teacher = new Teacher(i, "Teacher " + i);  
            List<Student> stus = new ArrayList<Student>();  
            for(int j = 0 ;j<4;j++) {  
                Student s = new Student(j, "Student" + j, 18 +j);   
                stus.add(s);  
            }  
            teacher.setStudents(stus);  
            teaList.add(teacher);  
        }  
        String jsonTeach = JSON.toJSONString(teaList);  
        System.out.println("fastjson = " + jsonTeach);

	}

}
