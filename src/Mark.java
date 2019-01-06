public class Mark {
    public String assignmentName;
    public Double mark, weight;

    public Mark() {

    }

    public Mark(String assignmentName, Double mark, double credit) {
        this.assignmentName = assignmentName;
        this.mark = mark;
        this.weight = credit;
    }

    public String getAssignmentName() {
        return this.assignmentName;
    }

    public Double getMark() {
        return this.mark;
}

    public Double getWeight() {
        return this.weight;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
