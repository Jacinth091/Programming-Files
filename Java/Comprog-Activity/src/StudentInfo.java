

class StudentInfo {
    private String name;
    private String course;
    private int[] grades;
    private double average;


    public StudentInfo(String name, String course, double ave) {
        this.setName(name);
        this.setCourse(course);
        this.setAve(ave);
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setAve(double ave) {
        this.average = ave;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getCourse() {
        return this.course;
    }

    public double getAve() {
        return this.average;
    }

    public int[] getGrades() {
        return this.grades;
    }

}