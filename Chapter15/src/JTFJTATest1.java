/*
 * 작성일 : 2024년 10월 2일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class JTFJTA1 extends JFrame implements ActionListener{
	private JTextField input;
	private JTextArea output;
	
	private JLabel jl = new JLabel("입력하세요.");
	
	public JTFJTA1() {
		input = new JTextField(20);	// 20칸
		output = new JTextArea(10, 20);	// 10줄 20칸
		output.setEnabled(false);	// 수정 불가 설정.
		
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		JPanel p1 = new JPanel();
		
		// 판넬에 in, out 추가
		p1.add(input);
		p1.add(output);
		
		// 컨테이너레 판넬 라벨 추가.
		ct.add(p1);
		ct.add(jl);
		
		// 리스너 등록.
		input.addActionListener(this);
		
		setTitle("텍스트 필드와 텍스트 에어리어");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(output.getLineCount() <= output.getRows()) {
			output.append(e.getActionCommand() + "\n");
			input.setText("");
			
		}
		else {
			jl.setText("입력이 종료되었습니다.");
			input.setEditable(false);
		}
		
	}
}

public class JTFJTATest1 {

	public static void main(String[] args) {
		new JTFJTA1();

	}

}
