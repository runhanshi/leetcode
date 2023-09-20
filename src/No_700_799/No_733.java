package No_700_799;
// NO.733.Flood Fill
// https://leetcode.com/problems/flood-fill
public class No_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int origColor, int color){
        if (!inArea(image, sr, sc)) return;
        if (image[sr][sc] == -1) return;
        fill(image, sr + 1, sc, origColor, color);
        fill(image, sr - 1, sc, origColor, color);
        fill(image, sr, sc + 1, origColor, color);
        fill(image, sr, sc - 1, origColor, color);
        image[sr][sc] = color;
    }

    private boolean inArea(int[][] image, int sr, int sc){
        return sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length;
    }
}
