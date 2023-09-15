package No_600_699;
// No.605.Can Place Flowers
// https://leetcode.com/problems/can-place-flowers/
public class No_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n){
        if (n == 0) return true;
        int l = flowerbed.length;
        for (int i = 0; i < l; i++){
            if (flowerbed[i] == 0){
                boolean left = (i == 0) || (flowerbed[i - 1] == 0);
                boolean right = (i == l - 1) || (flowerbed[i + 1] == 0);
                if (left && right){
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if (n <= 0) return true;
        }
        return false;
    }
}
