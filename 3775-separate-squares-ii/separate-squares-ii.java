class Solution {
    public double separateSquares(int[][] squares) {
        Set<Integer> xCoords = new HashSet<>();
        for (int[] sq : squares) {
            xCoords.add(sq[0]);
            xCoords.add(sq[0] + sq[2]);
        }
        List<Integer> distinctX = new ArrayList<>(xCoords);
        Collections.sort(distinctX);
        Map<Integer, Integer> xMap = new HashMap<>();
        for (int i = 0; i < distinctX.size(); i++) {
            xMap.put(distinctX.get(i), i);
        }
        List<Event> events = new ArrayList<>();
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            int x1 = sq[0];
            int x2 = x1 + l;
            events.add(new Event(y, x1, x2, 1));
            events.add(new Event(y + l, x1, x2, -1));
        }
        

        events.sort((a, b) -> Integer.compare(a.y, b.y));

        SegmentTree st = new SegmentTree(distinctX);
        List<Strip> strips = new ArrayList<>();
        double totalArea = 0;
        
        for (int i = 0; i < events.size() - 1; i++) {
            Event curr = events.get(i);

            st.update(0, 0, distinctX.size() - 1, xMap.get(curr.x1), xMap.get(curr.x2), curr.type);

            while (i + 1 < events.size() && events.get(i + 1).y == curr.y) {
                i++;
                curr = events.get(i);
                st.update(0, 0, distinctX.size() - 1, xMap.get(curr.x1), xMap.get(curr.x2), curr.type);
            }
            
            if (i + 1 < events.size()) {
                double h = events.get(i + 1).y - curr.y;
                double w = st.query();
                
                if (h > 0 && w > 0) {
                    double stripArea = w * h;
                    totalArea += stripArea;
                    strips.add(new Strip(curr.y, h, w, stripArea));
                }
            }
        }
        
        double target = totalArea / 2.0;
        double currentArea = 0;
        
        for (Strip strip : strips) {
            if (currentArea + strip.area >= target) {
                double needed = target - currentArea;
                return strip.yStart + (needed / strip.width);
            }
            currentArea += strip.area;
        }
        
        return events.get(events.size() - 1).y;
    }

    
    static class Event {
        int y, x1, x2, type;
        Event(int y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }
    
    static class Strip {
        double yStart, height, width, area;
        Strip(double y, double h, double w, double a) {
            yStart = y; height = h; width = w; area = a;
        }
    }

    static class SegmentTree {
       
        int[] count; 

        double[] length;
        List<Integer> X;

        public SegmentTree(List<Integer> distinctX) {
            int n = distinctX.size();
            count = new int[4 * n];
            length = new double[4 * n];
            this.X = distinctX;
        }

        public void update(int node, int l, int r, int L, int R, int val) {
            if (L >= r || l >= R) return; 
            
            if (L <= l && r <= R) {
                count[node] += val;
            } else {
                int mid = l + (r - l) / 2;
                update(2 * node + 1, l, mid, L, R, val);
                update(2 * node + 2, mid, r, L, R, val);
            }
            pushUp(node, l, r);
        }

        private void pushUp(int node, int l, int r) {
            if (count[node] > 0) {

                length[node] = X.get(r) - X.get(l);
            } else if (r - l == 1) {
                length[node] = 0;
            } else {
                length[node] = length[2 * node + 1] + length[2 * node + 2];
            }
        }
        
        public double query() {
            return length[0];
        }
    }
}