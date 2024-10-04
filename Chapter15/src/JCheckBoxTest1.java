/*
 * 작성일 :  2024년 10월 04일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

class JCheckBox1 extends JFrame implements ItemListener{
	JTextField languageTF;
	public JCheckBox1() {
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		
		languageTF = new JTextField(10);
		
		// 체크박스 객체 생성
		JCheckBox language1 = new JCheckBox("JAVA");
		JCheckBox language2 = new JCheckBox("JSP");
		JCheckBox language3 = new JCheckBox("Python");
		JCheckBox language4 = new JCheckBox("JavaScript");

		language1.addItemListener(this);
		language2.addItemListener(this);
		language3.addItemListener(this);
		language4.addItemListener(this);
		
		// 컨테이너에 체크박스 추가
		ct.add(language1);
		ct.add(language2);
		ct.add(language3);
		ct.add(language4);
		ct.add(languageTF);
		
		// 화면에 보이기
	    setTitle("JCheckBox");
	    setSize(300, 100);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		languageTF.setText(((JCheckBox)e.getItem()).getText());
		
	}
}
public class JCheckBoxTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JCheckBox1();
	}

}
