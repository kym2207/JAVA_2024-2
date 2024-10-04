/*
 * 작성일 :  2024년 10월 04일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class JButton2 extends JFrame implements ActionListener {
	JTextField jtf;
	public JButton2() {
		// 2. 컨테이너 생성
		Container ct = getContentPane();		

        ct.setLayout(new GridLayout(3,2));
		ImageIcon apple = new ImageIcon("images\\apple.jpg");
		ImageIcon pear = new ImageIcon("images\\pear.jpg");
		ImageIcon banana = new ImageIcon("images\\banana.jpg");
		ImageIcon persimmom = new ImageIcon("images\\persimmom.jpg");
		ImageIcon grape = new ImageIcon("images\\grape.jpg");

		JButton jb1 = new JButton("사과",apple);
		JButton jb2 = new JButton("배",pear);
		JButton jb3 = new JButton("바나나",banana);
		JButton jb4 = new JButton("감",persimmom);
		JButton jb5 = new JButton("포도",grape);
		
		jtf = new JTextField(10);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		
		ct.add(jb1);
		ct.add(jb2);
		ct.add(jb3);
		ct.add(jb4);
		ct.add(jb5);
		ct.add(jtf);
		
		setTitle("JButton Test2");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jtf.setText(e.getActionCommand());
		
	}
}
public class JNButtonTest2 {

	public static void main(String[] args) {
		new JButton2();
	}

}
