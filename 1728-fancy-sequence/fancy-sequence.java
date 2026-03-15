class Fancy {
    ArrayList<Integer> v = new ArrayList<>();
    int a;
    int b;
    int mod = 1000000007;

    public Fancy() {
        v = new ArrayList<Integer>();
        a = 1;
        b = 0;
    }
    
    public void append(int val) {
        long transformed = (val - b + (long)mod) % mod;
        transformed = (transformed * inv(a)) % mod;
        v.add((int) transformed);
    }

    public void multAll(int m) {
        a = (int) (((long) a * m) % mod);
        b = (int) (((long) b * m) % mod);
    }
    
    public void addAll(int inc) {
        b = (b + inc) % mod;
    }
    
    // public void multAll(int m) {
    //     a = (int) ((((long) a * m) % mod));
    //     b = (int) ((((long) b * m) % mod));
    // }
    
    public int getIndex(int idx) {
        if(idx >= v.size()) {
            return -1;
        }

        int ans = (int) (((((long) a * v.get(idx)) % mod) + b) % mod);
        return ans;
    }

    private int inv(int x) {
        return quickmul(x, mod - 2);
    }

    private int quickmul(int x, int y) {
        long ret = 1;
        long cur  = x;

        while(y != 0) {
            if((y & 1) != 0) {
                ret = (ret * cur) % mod;
            }
            cur = (cur * cur) % mod;
            y >>= 1;
        }

        return (int) ret;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */