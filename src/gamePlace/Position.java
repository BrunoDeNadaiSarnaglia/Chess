package gamePlace;

/**
 * Created by Bruno on 2/12/2015.
 */
public class Position {

    private int rank;
    private int file;

    public Position(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public Position(Position position) {
        this.rank = position.getRank();
        this.file = position.getFile();
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "(" +
                 rank +
                ", " + file +
                ')';
    }
}
