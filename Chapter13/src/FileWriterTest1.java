/*
 * 작성일 : 2024년 09월 25일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest1 {

   public static void main(String[] args) throws IOException {
      Scanner stdIn = new Scanner(System.in);
      
      String source = "터질 것만 같은 행복한 기분으로\n"
            + "틀에 박힌 관념 다 버리고 이제 또\n"
            + "맨 주먹 정신 다시 또 시작하면\n"
            + "나 이루리라 다 나 바라는대로";
      System.out.print("저장할 파일명을 입력 하세요 : ");
      String s = stdIn.next() + ".txt";
      
      // 저장한 파일 명으로 객체 생성.
      FileWriter fw = new FileWriter(s);   // 파일에 문자 출력
      
      fw.write(source);
      
      fw.close();   // 스트림 닫기
      
      System.out.println(s + "파일이 생성되었습니다.");
   }

}
