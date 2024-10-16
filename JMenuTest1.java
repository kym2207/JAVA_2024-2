/*
 * 작성일 : 2024년 10월 16일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

class JMenu1 extends JFrame implements ActionListener{
	JTextField jtf;
	public JMenu1() {
		// 컨테이너 생성
		Container ct = getContentPane(); // 컨테이너 생성.
		ct.setLayout(new BorderLayout()); // 컨테이너 레이아웃.
		
		// 1.JMenuBar() 객체 ㅐㅇ성
		JMenuBar jmb = new JMenuBar();
		
		JMenu menu1 = new JMenu("파일");
		JMenu menu2 = new JMenu("편집");
		
		// 3. 서브메뉴 JMenuItem객체로 생성
		JMenuItem jmi = new JMenuItem("새파일");
		jmi.addActionListener(this);	// 3.이벤트 이스너 등
		menu1.add(jmi);	//3. menu1 메뉴에 추가
		
		// 3. 서브메뉴 JMenuItem객체로 생성
		jmi = new JMenuItem("저장하기");
		jmi.addActionListener(this);	// 3.이벤트 이스너 등
		menu1.add(jmi);	//3. menu1 메뉴에 추가
		
		// 4. menu1 메뉴를 JMenuBar에 추가
		jmb.add(menu1);
		
		jmi = new JMenuItem("열기");
		jmi.addActionListener(this);
		menu2.add(jmi);
		jmi = new JMenuItem("잘라내기");
		jmi.addActionListener(this);
		menu2.add(jmi);
		jmi = new JMenuItem("복사");
		jmi.addActionListener(this);
		menu2.add(jmi);
		
		JCheckBoxMenuItem jcbmi = new JCheckBoxMenuItem("눈금자");
		jmi.addActionListener(this);
		menu2.add(jcbmi);
		JRadioButtonMenuItem jrbmi = new JRadioButtonMenuItem("수정가능상태");
		jmi.addActionListener(this);
		menu2.add(jrbmi);
		
		jmb.add(menu2);
		
		setJMenuBar(jmb);
		
		jtf = new JTextField();
		ct.add(jtf, BorderLayout.SOUTH);
		

	    setTitle("JScrollPane Test1");
	    setSize(300, 200);
	    setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		jtf.setText(e.getActionCommand());
		
	}
}
public class JMenuTest1 {

	public static void main(String[] args) {
		new JMenu1();	

	}

}
