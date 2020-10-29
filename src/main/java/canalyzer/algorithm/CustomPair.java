package canalyzer.algorithm;

public class CustomPair<L,R> {
    private L left;
    private R right;

    public CustomPair() {
    }

    public CustomPair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public void setLeft(L left) {
        this.left = left;
    }

    public R getRight() {
        return right;
    }

    public void setRight(R right) {
        this.right = right;
    }

    public void setAll(L left, R right){
        this.left = left;
        this.right = right;
    }
}
