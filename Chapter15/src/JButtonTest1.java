/*
 * 작성일 :  2024년 10월 04일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class JButton1 extends JFrame {
   public JButton1() {
      // 이미지 아이콘 객체 생성
      ImageIcon korea = new ImageIcon("images//korea1.gif");
      ImageIcon usa = new ImageIcon("images//usa.gif");
      ImageIcon germany = new ImageIcon("images//germany.gif");
      
      // 버튼 객체 생성
      JButton nat = new JButton(korea);   //   기본 버튼 이미지는 태극기
      nat.setPressedIcon(usa);      // 버튼 누르면 미국 국기
      nat.setRolloverIcon(germany);   // 버튼에 마우스 올리면 독일 국기
      
      // 컨테이너 생성
      Container ct = getContentPane();
      
      // 배치 관리자는 FlowLayout
      ct.setLayout(new FlowLayout());
      
      // 컨테이너에 버튼 추가. nat
      ct.add(nat);
      
      // 화면에 보이기
      setTitle("JButton Test");
      setSize(500, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
}

public class JButtonTest1 {

   public static void main(String[] args) {
      new JButton1();
   }

}
