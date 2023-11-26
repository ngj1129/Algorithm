class Solution {
    public int[] solution(String[] wallpaper) {
        int minx = 51;
        int maxx = 0;
        int miny = 51;
        int maxy = 0;
        for (int i=0; i<wallpaper.length; i++) {
            for (int j=0; j<wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minx = Math.min(minx, i);
                    maxx = Math.max(maxx, i);
                    miny = Math.min(miny, j);
                    maxy = Math.max(maxy, j);
                }
            }
        }
        return new int[]{minx, miny, maxx+1, maxy+1};
    }
}