/*
 * 작성일 : 2024년 10월 2일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * GUI 클래스에 이벤트 처리
 */

// GUI 클래스
					// 1) 처리할 이벤트 종류 결정.
					// 2) 이벤트에 적합한 이벤트 리스너 인터페이스를 사용.
class Event1 extends JFrame implements ActionListener{ // 1. 프레임 생성(상속)
	JLabel jl;
	
	public Event1() {
		// 2. 컨테이너 생성
		Container ct = getContentPane();
		// 3. 배치 관리자 설정.
		ct.setLayout(new FlowLayout());
		
		// 4. 버튼, 레이블 생성.
		JButton jb = new JButton("버튼");
		jl = new JLabel("버튼을 눌러주세요.");
		
		// 3) 이벤트를 받아들일 버튼에 리스너 등록
		jb.addActionListener(this);
		
		// 5. 컨테이너에 등록
		ct.add(jb);
		ct.add(jl);
		
		setTitle("Event Test1");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	// 4) 리스너 이터페이스에 선언된 메소드를 오버라이딩 하여 이벤트 처리 루틴 작성.
	@Override
	public void actionPerformed(ActionEvent e) {
			jl.setText("안녕하세요.");
	
	}

	
	
}
public class EventTest1 {

	public static void main(String[] args) {
		new Event1();

	}

}
