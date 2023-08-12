package hooks;

public enum enumToken {

    TOKEN("ogun.erdogan@admin.wonderworldcollege.com",
            "ogun.erdogan@teacher.wonderworldcollege.com",
            "std79",
            "wonderworld123");


    private String adminEmail;
    private String teacherEmail;
    private String studentUserName;
    private String password;

    enumToken(String eMailAdmin, String eMailTeacher, String userNameStudent, String password){
        this.adminEmail = eMailAdmin;
        this.teacherEmail = eMailTeacher;
        this.studentUserName = userNameStudent;
        this.password = password;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public String getPassword() {
        return password;
    }
}
