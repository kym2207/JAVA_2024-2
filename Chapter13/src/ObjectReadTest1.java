/*
 * 작성일 : 2024년 09월 25일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class ObjectReadTest1 {

   public static void main(String[] args) throws ClassNotFoundException {
      Scanner stdIn = new Scanner(System.in);
      System.out.print("불러 올 파일명을 입력 하세요 : ");
      String s = stdIn.next();
      
      // 객체를 읽어 올 수 있는 OIS 객체 생성.
      try {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream(s));
         Object s2 = ois.readObject();   // 객체 읽어 오기
      
         // readObject()메소드로 직렬화된 객체의 2진 데이터를
         // 읽어서 객체 타입으로 형변환한다.
         PersonInfo p1 = (PersonInfo)ois.readObject();
         PersonInfo p2 = (PersonInfo)ois.readObject();
         
         // 출력은 순서대로.. 이름, 도시, 나이 
         System.out.println(s2);
         
         System.out.println("이름 : " + p1.name);
         System.out.println("도시 : " + p1.city);
         System.out.println("나이 : " + p1.age);
         System.out.println("-----------------");
         System.out.println("이름 : " + p2.name);
         System.out.println("도시 : " + p2.city);
         System.out.println("나이 : " + p2.age);
         
         ois.close();
      } catch (FileNotFoundException e) {
         System.out.println(s + " 파일이 없습니다.");
      } catch (IOException e) {
         System.out.println(s + " 파일이 없습니다.");
      }
   }

}
