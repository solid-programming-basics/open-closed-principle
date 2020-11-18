package edu.agh.wfiis.solid.ocp.example2;

public class Triplet<A, B, C> {
    A first;
    B second;
    C third;

    public Triplet(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Triplet<?,?,?>) {
            if (this.first != ((Triplet) o).first) {
                return false;
            }
            if (this.second != ((Triplet) o).second) {
                return false;
            }
            if (this.third != ((Triplet) o).third) {
                return false;
            }
            return true;
        }
        return false;
    }
}
