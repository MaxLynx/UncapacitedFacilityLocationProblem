package edu.network.optimalization.utils;

public class Heuristics {

    public void findOptimal(int m, int n, int[]f, int[]b, int[][]d){
        int [] y = new int[m];
        for(int i = 1; i < m; i++){
            y[i] = 0;
        }
        y[0] = 1;
        int res = objUFLP_1(m, n, y, f, b, d);;
        int current_res = 0;
        for(int i = 1; i < m; i++){
            y[i] = 1;
            current_res = objUFLP_1(m, n, y, f, b, d);
            if(current_res > res){
                y[i] = 0;
            }
        }
        System.out.println("Optimal solution:");
        for(int i = 0; i < m; i++) {
            if(y[i] > 0)
            System.out.print((i+1) + " ");
        }
        System.out.println();
    }

    public int objUFLP_1(int m, int n, int[]y, int[]f, int[]b, int[][]d){
        int i, j, sum, mind, cand;
        sum = 0;
        for(j = 0; j < n; j++){
            if(n > 0) {
                mind = Integer.MAX_VALUE;
                for (i = 0; i < m; i++) {
                    if (y[i] > 0) {
                        mind = Math.min(mind, d[i][j]);
                    }
                }
                sum += b[j] * mind;
            }
        }
        for (i = 0; i < m; i++) {
            if (y[i] > 0) {
                sum += f[i];
            }
        }
        return sum;
    }

    public int objUFLP_2(int n, int noy, int[]zy, int[]f, int[]b, int[][]d){
        int i, j, sum, mind, cand;
        sum=0;
        for(j = 0; j < n; j++){
                mind = Integer.MAX_VALUE;
                for (i = 0; i < noy; i++) {
                        mind = Math.min(mind, d[zy[i]-1][j]);

                }
                sum += b[j] * mind;

        }
        for (i = 0; i < noy; i++) {
                sum += f[zy[i]-1];

        }
        return sum;
    }
}
