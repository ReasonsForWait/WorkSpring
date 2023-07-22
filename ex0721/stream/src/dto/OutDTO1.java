package dto;

import domain.Student;

public class OutDTO1 {
    private String name;
    private int score;

    public OutDTO1(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public OutDTO1(Student std) {
        this.name = std.getName();
        this.score = std.getScore();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
