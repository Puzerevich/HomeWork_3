package HomeWork_3;



public class Student extends Human{
    private String universityName;
    private int scoreBookId;
    private int averageScore;
    private String group;

    public Student(String name, String surname, int age, boolean sex) {
        super(name, surname, age, sex);
    }

    public Student(String name, String surname, int age, boolean sex, String universityName, int scoreBookId, int averageScore) {
        super(name, surname, age, sex);
        this.universityName = universityName;
        this.scoreBookId = scoreBookId;
        this.averageScore = averageScore;
    }

    public Student(String name, String surname, int age, boolean sex, String universityName, int scoreBookId, int averageScore, String group) {
        super(name, surname, age, sex);
        this.universityName = universityName;
        this.scoreBookId = scoreBookId;
        this.averageScore = averageScore;
        this.group = group;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getScoreBookId() {
        return scoreBookId;
    }

    public void setScoreBookId(int scoreBookId) {
        this.scoreBookId = scoreBookId;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "universityName='" + universityName + '\'' +
                ", scoreBookId=" + scoreBookId +
                ", averageScore=" + averageScore +
                ", group='" + group + '\'' +
                super.toString()+
                '}';
    }
}