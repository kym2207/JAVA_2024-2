/*
 * 작성일 : 2024년 09월 25일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileInputStreamTest1 {

   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);
      try {
         System.out.print("파일명을 입력 하세요 : ");
         String s = stdIn.next();
         
         // 입력한 파일명으로 객체 생성.
         FileInputStream fis = new FileInputStream(s);
         
         int i;
         while((i = fis.read()) != -1) {   // 바이트 단위로 읽어 온다.
            System.out.println(i);
         }
         
         fis.close();
      } catch (FileNotFoundException e) {
         System.out.println("입력하신 파일이 없습니다.");
      } catch (IOException e) {
         System.out.println("파일이 없습니다.");
      }
   }

}
