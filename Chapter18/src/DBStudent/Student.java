package DBStudent;

// 학생 정보를 표현하기 위한 클래스
public class Student {
   // 학생 테이블 컬럼에 대응하는 필드 선언
   private int Number;     // 학생 관리 번호 (Primary Key)
   private String Dept;    // 학과
   private int studentID;  // 학번
   private int Grade;      // 학년
   private String Name;    // 이름
   private String Phone;   // 연락처
   
   // Getter 및 Setter 메서드 (캡슐화를 위해 사용)
   
   // 관리 번호를 반환하는 Getter
   public int getNumber() {
      return Number;
   }
   
   // 관리 번호를 설정하는 Setter
   public void setNumber(int number) {
      Number = number;
   }
   
   // 학과를 반환하는 Getter
   public String getDept() {
      return Dept;
   }
   
   // 학과를 설정하는 Setter
   public void setDept(String dept) {
      Dept = dept;
   }
   
   // 학번을 반환하는 Getter
   public int getStudentID() {
      return studentID;
   }
   
   // 학번을 설정하는 Setter
   public void setStudentID(int studentID) {
      this.studentID = studentID;
   }
   
   // 학년을 반환하는 Getter
   public int getGrade() {
      return Grade;
   }
   
   // 학년을 설정하는 Setter
   public void setGrade(int grade) {
      Grade = grade;
   }
   
   // 이름을 반환하는 Getter
   public String getName() {
      return Name;
   }
   
   // 이름을 설정하는 Setter
   public void setName(String name) {
      Name = name;
   }
   
   // 연락처를 반환하는 Getter
   public String getPhone() {
      return Phone;
   }
   
   // 연락처를 설정하는 Setter
   public void setPhone(String phone) {
      Phone = phone;
   }
}
