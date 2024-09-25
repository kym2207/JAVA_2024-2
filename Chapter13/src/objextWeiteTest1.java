/*
 * 작성일 : 2024년 09월 25일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class PersonInfo implements Serializable{
	String name;
	String city;
	int age;
	
	public PersonInfo(String name, String city, int age) {
		this.name = name;
		this.city = city;
		this.age = age;
	}
}
public class objextWeiteTest1 {

	public static void main(String[] args) throws Exception, IOException {
	      Scanner stdIn = new Scanner(System.in);
	      System.out.print("저장할 파일명을 입력 하세요 : ");
	      String s = stdIn.next();
	      String s1 = "*** 고객정보 ***";
	      
	      // 직렬화된 객체를 2개 생성 
	      PersonInfo p1 = new PersonInfo("김지연","부산",25);
	      PersonInfo p2 = new PersonInfo("홍길동","서울",23);
	      
	      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(s));
	      
	      oos.writeObject(s1);
	      oos.writeObject(p1);
	      oos.writeObject(p2);
	      
	      oos.close();
	      
	      System.out.println(s + "파일명으로 객체 파일을 생성.");
	      
	      

	}

}
