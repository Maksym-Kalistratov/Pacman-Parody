package Other;
import java.io.*;
public class Record implements Serializable, Comparable<Record> {
    private static final long serialVersionUID = 1L;
    private int score;
    private double time;
    private String name;
public Record(int score, double time, String name){
    this.score = score;
    this.time = time;
    this.name = name;
}

    public int getScore() {return score;}

    public double getTime() {return time;}

    public String getName() {return name;}

    @Override
    public int compareTo(Record o) {
        return o.score - this.score;
    }
    @Override
    public String toString() {
        return ". Player " + name + " Score: " + score + String.format(" Time: %.3f seconds", time);
    }
}
