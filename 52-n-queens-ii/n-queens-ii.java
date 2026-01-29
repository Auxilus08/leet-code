class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        // (1 << n) - 1 creates a bitmask of 'n' ones. 
        // Example for n=4: 0000 -> 1111
        solve(0, 0, 0, 0, (1 << n) - 1);
        return count;
    }

    private void solve(int row, int cols, int diag1, int diag2, int fullMask) {
        if (cols == fullMask) {
            count++;
            return;
        }

        // bits: all 1s represent available positions in this row
        // ~(cols | diag1 | diag2) flips bits to find free spots
        // & fullMask ensures we only look at the first 'n' bits
        int availablePositions = fullMask & (~(cols | diag1 | diag2));

        while (availablePositions != 0) {
            // Get the rightmost set bit (the first available position)
            int position = availablePositions & -availablePositions;
            
            // Mark position as taken and move to next row
            solve(row + 1, 
                  cols | position, 
                  (diag1 | position) << 1, 
                  (diag2 | position) >> 1, 
                  fullMask);
            
            // Remove the bit we just processed
            availablePositions ^= position;
        }
    }
}