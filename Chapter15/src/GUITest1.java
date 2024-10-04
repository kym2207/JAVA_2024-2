/*
 * 작성일 :  2024년 10월 04일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUI1 extends JFrame implements ActionListener {
	JTextField f_name;
	JTextArea contents;
	public GUI1() {
		// 속성으로 텍스트 에어리어와 텍스트 필드를 선언.
		// 이벤트 처리에서 사용해야 하기에 생성자 밖에 속성으로 선언.
		// 글 내용을 입력하고. 버튼을 누르면 파일로 생성되어야함.
		Container ct = getContentPane();
        ct.setLayout(new FlowLayout());
        
        f_name = new JTextField("파일 이름을 입력하세요" , 20);
        JButton jb = new JButton("파일 불러오기");
        contents = new JTextArea("파일 내용을 입력하세요",10,20);
        
        jb.addActionListener(this);
        
        ct.add(f_name);
        ct.add(jb);
        ct.add(contents);
        
     // 화면에 보이기
    setTitle("JButton Test");
    setSize(500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String s = f_name.getText();
			FileOutputStream fos = new FileOutputStream(s);
			DataOutputStream dos = new DataOutputStream(fos);
			
			// 텍스트 에어리어의 내용을 아필로 출력
			dos.writeUTF(contents.getText());
			fos.close();
			System.out.println(s + "파일을 생성하였습니다.");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch(IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
public class GUITest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI1();
	}

}
