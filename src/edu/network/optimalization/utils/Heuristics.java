package edu.network.optimalization.utils;

import java.util.Random;

public class Heuristics {

    private Random random;

    public void findOptimal(int m, int n, int[]f, int[]b, int[][]d, int T){
        random = new Random();
        int [] y = new int[m];
        for(int i = 1; i < m; i++){
            y[i] = random.nextInt(2);
        }
        int u = 5;
        int q = 5;
        int res = objUFLP_1(m, n, y, f, b, d);
        int current_res = 0;
        int optimal_res = res;
        int w = 0;
        int t = T;
        int[] optimal_y = new int[m];
            for(int j = 0; j < m; j++){
                optimal_y[j] = 0;
            }

        for(int r = 0; r < u; r++){
            int randomIndex = random.nextInt(m);
            if(y[randomIndex] == 1){
                y[randomIndex] = 0;
            }
            else{
                y[randomIndex] = 1;
            }
            System.out.println("Current warmness: " + t);
            System.out.println("Current solution:");
            for(int i = 0; i < m; i++) {
                if(y[i] > 0)
                    System.out.print((i+1) + " ");
            }
            current_res = objUFLP_1(m, n, y, f, b, d);
            System.out.println("\nCurrent money: " + current_res);
            w++;
            if(w == q){
                t /= 2;
                w = 0;
            }
            if(current_res > res){
                double p = Math.exp((res - current_res) / t);
                double h = Math.random();
                if(h > p){
                    if(y[randomIndex] == 1){
                        y[randomIndex] = 1;
                    }
                    else{
                        y[randomIndex] = 0;
                    }
                }
                else{
                    res = current_res;
                    r = 0;

                }

            }
            else{
                res = current_res;
                r = 0;
                    if(res < optimal_res){
                        for(int j = 0; j < m; j++){
                            optimal_y[j] = y[j];
                        }
                    }

            }

        }
        System.out.println("Optimal solution:");
        for(int i = 0; i < m; i++) {
            if(optimal_y[i] > 0)
            System.out.print((i+1) + " ");
        }
        System.out.println();
        System.out.println("Optimal money: " + res);
        System.out.println("////////");
    }

    public void findOptimalExchangeHeuristics(int m, int n, int[]f, int[]b, int[][]d){
        int [] y = new int[m];
        for(int i = 0; i < m/2; i++){
            y[i] = 1;
        }
        for(int i = m/2; i < m; i++){
            y[i] = 0;
        }
        int res = objUFLP_1(m, n, y, f, b, d);;
        int current_res = 0;
        for(int i = m/2; i < m; i++){
            System.out.println("Current money: " + res);
            y[i] = 1;
            y[m-i] = 0;
            current_res = objUFLP_1(m, n, y, f, b, d);
            if(current_res > res){
                y[i] = 0;
                y[m-i] = 1;
            }
            else{
                res = current_res;
            }

        }
        System.out.println("Optimal solution:");
        for(int i = 0; i < m; i++) {
            if(y[i] > 0)
                System.out.print((i+1) + " ");
        }
        System.out.println();
        System.out.println("Optimal money: " + res);
        System.out.println("////////");
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
