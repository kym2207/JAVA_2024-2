/*
 * 작성일 : 2024년 09월 11일
 * 작성자 : 2023950008 김유민
 * 설명 : 예재 11-6
 */
abstract class Shape {   // 추상 클래스
   // 추상 메소드 선언 - 그리기
   abstract void draw();
   // 추상 메소드 선언 - 넓이
   abstract void computeArea(double a, double b);
}

class Rectangle1 extends Shape { // 상속
   // 메소드 오버라이딩 - 구체적으로 구현
   void draw() {
      System.out.println("사각형을 그리는 기능");
   }
   // 메소드 오버라이딩 - 구체적으로 구현
   void computeArea(double h, double v) {
      System.out.println("사각형의 넓이 : " + (h * v));
   }
}
public class AbstractTest1 {
   public static void main(String args[]) {
      System.out.println("==추상 메소드를 이용한 다형성==");
      
      // 상위 클래스 형으로 s 객체 변수 만들어 하위 클래스(Rectangle1())
      Shape s = new Rectangle1();
      s.draw();   // 사각형을 그리는 기능 출력.
      s.computeArea(3.0, 2.5);
   }
}
