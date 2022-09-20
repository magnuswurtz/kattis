class Y<Key extends Comparable<Key>> {
    private Key[] A = (Key[]) new Comparable[1];
    private int lo, hi, N;
    public void insert(Key in)
    {
        A[hi] = in;
        hi = hi + 1;
        if (hi == A.length) hi = 0;
        N = N + 1;
        if (N == A.length) rebuild();
    }
    public Key remove() // assumes Y is not empty
    {
        Key out = A[lo];
        A[lo] = null;
        lo = lo + 1;
        if (lo == A.length) lo = 0;
        N = N - 1;
        return out;
    }
    private void rebuild()
    {
        // The line below is essentially:
        // Key[] tmp = new Key[2*A.length]
        // with keys being comparable.
        Key[] tmp = (Key[]) new Comparable[2 * A.length];
        for (int i = 0; i < N; i++)
            tmp[i] = A[(i + lo) % A.length];
        A = tmp;
        lo = 0;
        hi = N;
    }
    public static void main(String[] args) {
        Y<Integer> yy = new Y<>();
        yy.insert(3);
        yy.insert(8);
        yy.insert(4);
        yy.insert(1);
        System.out.println(3%4);
    }
}