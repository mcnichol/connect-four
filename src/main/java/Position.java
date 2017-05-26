public class Position {
    private int column;
    private int depth;

    public Position(int column, int depth) {
        this.column = column;
        this.depth = depth;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (column != position.column) return false;
        return depth == position.depth;
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + depth;
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "column=" + column +
                ", depth=" + depth +
                '}';
    }
}
