package DBStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

// 학생 정보를 데이터베이스에서 관리하기 위한 클래스
public class StudentDAO {
   // 데이터베이스 연결 URL
   String jdbcUrl = "jdbc:mysql://localhost:3306/studentdb?"; 
   
   // 데이터베이스 연결 객체
   Connection conn;
   
   // 데이터베이스 계정 정보
   String id = "root"; // 사용자 ID
   String pw = "1234"; // 사용자 PW
   
   // SQL 실행을 위한 PreparedStatement와 ResultSet
   PreparedStatement pstmt;
   ResultSet rs;
   
   // 콤보박스 데이터를 저장할 벡터
   Vector<String> items = null;
   String sql; // SQL 문을 저장할 변수
   
   // 데이터베이스 연결 메서드
   public void connectDB() {
      try { 
         // JDBC 드라이버 로드 및 연결
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(jdbcUrl, id, pw);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   // 데이터베이스 연결 종료 메서드
   public void closeDB() {
      try {
         pstmt.close(); // PreparedStatement 닫기
         conn.close();  // Connection 닫기
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   // 콤보박스용 학생 관리 번호 목록을 반환하는 메서드
   public Vector<String> getItems() {
      return items;
   }
   
   // 전체 학생 목록을 가져오는 메서드
   public ArrayList<Student> getAll() {
      connectDB(); // 데이터베이스 연결
      sql = "select * from student"; // SQL 쿼리 작성
      
      // 전체 검색 데이터를 저장할 ArrayList 생성
      ArrayList<Student> datas = new ArrayList<Student>();
      
      // 콤보박스 데이터 저장용 벡터 초기화
      items = new Vector<String>();
      items.add("연변선택"); // 기본값 추가
      
      try {
         pstmt = conn.prepareStatement(sql); // SQL 실행 준비
         rs = pstmt.executeQuery(); // SQL 실행
         
         // 검색된 데이터 수 만큼 반복
         while(rs.next()) {
            // 학생 정보를 저장할 객체 생성
            Student s = new Student();
            s.setNumber(rs.getInt("number")); // 학생 관리 번호 설정
            s.setDept(rs.getString("Dept")); // 학과 정보 설정
            s.setStudentID(rs.getInt("StudentID")); // 학번 설정
            s.setGrade(rs.getInt("Grade")); // 학년 설정
            s.setName(rs.getString("Name")); // 이름 설정
            s.setPhone(rs.getString("Phone")); // 연락처 설정
            datas.add(s); // 데이터를 ArrayList에 추가
            items.add(String.valueOf(rs.getInt("number"))); // 콤보박스용 데이터 추가
         }
      } catch(SQLException e) {
         e.printStackTrace();
         return null; // 오류 발생 시 null 반환
      } finally {
         closeDB(); // 데이터베이스 연결 종료
      }
      return datas; // 검색된 학생 목록 반환
   }
   
   // 새로운 학생을 데이터베이스에 등록하는 메서드
   public boolean insertStudent(Student student) {
      connectDB(); // 데이터베이스 연결
      
      // 학생 정보를 삽입하는 SQL 쿼리 작성 (number 컬럼은 자동 증가)
      sql = "insert into student(dept, studentID, grade, name, phone) values(?,?,?,?,?)";
      
      try {
         pstmt = conn.prepareStatement(sql); // SQL 실행 준비
         pstmt.setString(1, student.getDept()); // 학과 설정
         pstmt.setInt(2, student.getStudentID()); // 학번 설정
         pstmt.setInt(3, student.getGrade()); // 학년 설정
         pstmt.setString(4, student.getName()); // 이름 설정
         pstmt.setString(5, student.getPhone()); // 연락처 설정
         pstmt.executeUpdate(); // SQL 실행
      } catch (SQLException e) {
         e.printStackTrace();
         return false; // 오류 발생 시 false 반환
      } finally {
         closeDB(); // 데이터베이스 연결 종료
      }
      return true; // 성공적으로 삽입되었을 경우 true 반환
   }
   
   // 관리 번호를 통해 특정 학생 정보를 가져오는 메서드
   public Student selectStudent(int number) {
      connectDB(); // 데이터베이스 연결
      sql = "select * from student where number=?"; // SQL 쿼리 작성
      Student s = null; // 결과를 저장할 Student 객체 초기화
      
      try {
         pstmt = conn.prepareStatement(sql); // SQL 실행 준비
         pstmt.setInt(1, number); // 관리 번호 설정
         rs = pstmt.executeQuery(); // SQL 실행
         rs.next(); // 결과 가져오기
         
         // 결과를 Student 객체에 설정
         s = new Student();
         s.setNumber(rs.getInt("number"));
         s.setDept(rs.getString("Dept"));
         s.setStudentID(rs.getInt("StudentID"));
         s.setGrade(rs.getInt("Grade"));
         s.setName(rs.getString("Name"));
         s.setPhone(rs.getString("Phone"));
      } catch(SQLException e) {
         e.printStackTrace();
         return null; // 오류 발생 시 null 반환
      } finally {
         closeDB(); // 데이터베이스 연결 종료
      }
      return s; // 검색된 학생 정보 반환
   }
   
   // 학생 정보를 수정하는 메서드
   public boolean updatestudent(Student student) {
      connectDB(); // 데이터베이스 연결
      sql = "update student set dept=?, studentID=?, grade=?, name=?, phone=? where number=?"; // SQL 쿼리 작성
      
      try {
         pstmt = conn.prepareStatement(sql); // SQL 실행 준비
         pstmt.setString(1, student.getDept()); // 학과 설정
         pstmt.setInt(2, student.getStudentID()); // 학번 설정
         pstmt.setInt(3, student.getGrade()); // 학년 설정
         pstmt.setString(4, student.getName()); // 이름 설정
         pstmt.setString(5, student.getPhone()); // 연락처 설정
         pstmt.setInt(6, student.getNumber()); // 관리 번호 설정
         pstmt.executeUpdate(); // SQL 실행
      } catch(SQLException e) {
         e.printStackTrace();
         return false; // 오류 발생 시 false 반환
      } finally {
         closeDB(); // 데이터베이스 연결 종료
      }
      return true; // 성공적으로 수정되었을 경우 true 반환
   }
   
   // 관리 번호를 통해 특정 학생을 삭제하는 메서드
   public boolean deletestudent(int number) {
      connectDB(); // 데이터베이스 연결
      sql = "delete from student where number=?"; // SQL 쿼리 작성
      
      try {
         pstmt = conn.prepareStatement(sql); // SQL 실행 준비
         pstmt.setInt(1, number); // 관리 번호 설정
         pstmt.executeUpdate(); // SQL 실행
      } catch (SQLException e) {
         e.printStackTrace();
         return false; // 오류 발생 시 false 반환
      } finally {
         closeDB(); // 데이터베이스 연결 종료
      }
      return true; // 성공적으로 삭제되었을 경우 true 반환
   }
}
