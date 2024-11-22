package DBStudent;

// 필요한 클래스 임포트
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 메인 클래스 정의, JFrame을 상속받아 UI 구성
public class MainStudent extends JFrame implements ActionListener {
   // 컨테이너 생성 (UI 요소를 담는 컨테이너)
   Container ct = getContentPane();
   
   // 각 패널 생성 (UI 요소 그룹화)
   JPanel p1 = new JPanel();   // 메시지 출력 패널
   JPanel p2 = new JPanel();   // 라벨 패널
   JPanel p3 = new JPanel();   // 텍스트 필드 패널
   JPanel p4 = new JPanel();   // 버튼 패널
   JPanel p5 = new JPanel();   // 데이터 출력 패널
   
   // 메시지 출력을 위한 라벨 생성
   JLabel msg1 = new JLabel();
   
   // 입력 필드에 대한 라벨 생성
   JLabel l1 = new JLabel("   연   번   ");
   JLabel l2 = new JLabel("   학   과   ");
   JLabel l3 = new JLabel("   학   번   ");
   JLabel l4 = new JLabel("   학   년   ");
   JLabel l5 = new JLabel("   이   름   ");
   JLabel l6 = new JLabel("   연락처   ");
   
   // 입력 필드 생성
   JTextField t1 = new JTextField(10); // 학과 입력 필드
   JTextField t2 = new JTextField(10); // 학번 입력 필드
   JTextField t3 = new JTextField(10); // 학년 입력 필드
   JTextField t4 = new JTextField(10); // 이름 입력 필드
   JTextField t5 = new JTextField(10); // 연락처 입력 필드
   
   // 메뉴 버튼 생성
   JButton b1 = new JButton("   등  록    "); // 등록 버튼
   JButton b2 = new JButton("   조  회    "); // 조회 버튼
   JButton b3 = new JButton("   수  정    "); // 수정 버튼
   JButton b4 = new JButton("   삭  제    "); // 삭제 버튼
   
   // 학생 선택을 위한 콤보박스 생성
   JComboBox cb;
   
   // 데이터 출력용 텍스트 영역 생성
   JTextArea ta;
   
   // 프로그램 메시지
   String msg = "";
   
   // 학생 데이터를 관리하기 위한 ArrayList 생성
   ArrayList<Student> datas = new ArrayList<Student>();
   
   // 데이터베이스 연동 클래스 인스턴스 생성
   StudentDAO Sdao = new StudentDAO();
   
   // 특정 학생 정보를 담기 위한 Student 객체 생성
   Student student;
   
   // 메인 UI를 실행하는 메서드
   public void startUI() {
      // 컨테이너 레이아웃 설정
      ct.setLayout(new BorderLayout());
      
      // 패널 레이아웃 설정
      p1.setLayout(new GridLayout(1, 1, 20, 2)); // 메시지 패널
      p2.setLayout(new GridLayout(6, 1, 20, 2)); // 라벨 패널
      p3.setLayout(new GridLayout(6, 1, 20, 2)); // 텍스트 필드 패널
      p4.setLayout(new GridLayout(4, 1, 20, 2)); // 버튼 패널
      p5.setLayout(new GridLayout(1, 1, 20, 2)); // 출력 패널
      
      // 메시지 초기화
      msg1.setText(msg + " 프로그램이 시작 되었습니다.!!");
      msg1.setEnabled(false);
      
      // 콤보박스 초기화
      cb = new JComboBox();
      
      // 결과 출력용 스크롤 추가
      ta = new JTextArea(20, 40);
      JScrollPane scroll = new JScrollPane (ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      
      // 패널에 컴포넌트 추가
      p1.add(msg1); // 메시지 추가
      p2.add(l1); // 라벨 추가
      p2.add(l2);
      p2.add(l3);
      p2.add(l4);
      p2.add(l5);
      p2.add(l6);
      p3.add(cb); // 콤보박스 추가
      p3.add(t1); // 텍스트 필드 추가
      p3.add(t2);
      p3.add(t3);
      p3.add(t4);
      p3.add(t5);
      p4.add(b1); // 버튼 추가
      p4.add(b2);
      p4.add(b3);
      p4.add(b4);
      p5.add(scroll); // 출력 영역 추가
      
      // 이벤트 리스너 등록
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      b4.addActionListener(this);
      
      // 프레임에 패널 배치
      ct.add(p1, BorderLayout.NORTH);
      ct.add(p2, BorderLayout.WEST);
      ct.add(p3, BorderLayout.CENTER);
      ct.add(p4, BorderLayout.EAST);
      ct.add(p5, BorderLayout.SOUTH);
      
      // 데이터 새로고침
      refreshData();
      
      // UI 크기 조정 불가능 설정
      setResizable(false);
      setVisible(true);
   }
   
   // 생성자, 기본 프레임 설정
   public MainStudent() {
      super("Student Information");
      setLayout(new BorderLayout(20, 20));
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(700, 700);
   }
   
   // 필드 초기화 (등록, 삭제 등 이후)
   public void clearField() {
      t1.setText("");
      t2.setText("");
      t3.setText("");
      t4.setText("");
      t5.setText("");
   }
   
   // 데이터 갱신 메서드
   public void refreshData() {
      ta.setText("\n\n");
      clearField();
      ta.append("     연 번\t학 과\t\t학 번\t학 년\t이 름\t연락처\n");
      datas = Sdao.getAll(); // 전체 학생 데이터 가져오기
      cb.setModel(new DefaultComboBoxModel(Sdao.getItems())); // 콤보박스 데이터 갱신
      
      if(datas != null) {
         for(Student p : datas) {
            StringBuffer sb = new StringBuffer();
            sb.append("     " + p.getNumber()+"\t");
            sb.append(p.getDept()+"\t\t");
            sb.append(p.getStudentID()+"\t");
            sb.append(p.getGrade()+"\t");
            sb.append(p.getName()+"\t");
            sb.append(p.getPhone()+"\n");
            ta.append(sb.toString());
         }
      }
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      
      // 등록 버튼 클릭 시
      if(obj == b1) {
         student = new Student();
         student.setDept(t1.getText());
         student.setStudentID(Integer.parseInt(t2.getText()));
         student.setGrade(Integer.parseInt(t3.getText()));
         student.setName(t4.getText());
         student.setPhone(t5.getText());
         
         if(Sdao.insertStudent(student)) {
            msg1.setText(msg + "학생을 등록했습니다.!!");
         } else {
            msg1.setText(msg + "학생 등록이 실패 했습니다.!!");
         }
         refreshData();
      }
      // 조회 버튼 클릭 시
      else if(obj == b2) {
         String s = (String)cb.getSelectedItem();
         if(!s.equals("연번선택")) {
            student = Sdao.selectStudent(Integer.parseInt(s));
            if(student != null) {
               msg1.setText(msg+"학생 정보를 가져왔습니다.!!");
               t1.setText(student.getDept());
               t2.setText(String.valueOf(student.getStudentID()));
               t3.setText(String.valueOf(student.getGrade()));
               t4.setText(student.getName());
               t5.setText(student.getPhone());
            } else {
               msg1.setText(msg + "학생이 검색되지 않았습니다.!!");
            }
         } else {
            refreshData();
         }
      }
      // 수정 버튼 클릭 시
      else if(obj == b3) {
         student = new Student();
         student.setDept(t1.getText());
         student.setStudentID(Integer.parseInt(t2.getText()));
         student.setGrade(Integer.parseInt(t3.getText()));
         student.setName(t4.getText());
         student.setPhone(t5.getText());
         student.setNumber(Integer.parseInt((String)cb.getSelectedItem()));
         if(Sdao.updatestudent(student)) {
            msg1.setText(msg+"학생 정보를 수정했습니다.!!");
         } else {
            msg1.setText(msg+"학생 정보 수정에 실패 했습니다.!!");
         }
         refreshData();
      }
      // 삭제 버튼 클릭 시
      else if(obj == b4) {
         String s = (String)cb.getSelectedItem();
         if(s.equals("전체")) {
            msg1
