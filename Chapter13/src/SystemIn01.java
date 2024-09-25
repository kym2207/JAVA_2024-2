/*
 * 작성일 : 2024년 09월 25일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */

import java.io.IOException;
import java.io.InputStream;

public class SystemIn01 {

   public static void main(String[] args) {
      try {
         System.out.print("데이터 입력 : ");
         InputStream is = System.in;      // byte 차입?을 처리
         
         int data = is.read();   // 값 읽어오기
         
         System.out.println("입력한 데이터는 : " + (char)data);
         is.close();      // 입력 스트립 닫기.
      } catch (IOException e) {
         System.out.println("입력한 데이터가 없습니다.");
      }
   }

}
