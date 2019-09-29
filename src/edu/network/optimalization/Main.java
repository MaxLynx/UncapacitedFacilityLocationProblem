package edu.network.optimalization;

import edu.network.optimalization.utils.Heuristics;

public class Main {

    public static void main(String[] args) {
        Heuristics heuristics = new Heuristics();
        long time1 = System.nanoTime();
        int result1 =
                heuristics.objUFLP_1(3, 5,
                new int[]{1, 0, 1},
                new int[]{200, 300, 300},
                new int[]{1, 1, 1, 1, 1},
                new int[][]{{500, 100, 300, 400, 100},
                        {300, 200, 300, 400, 200},
                        {200, 200, 300, 100, 300}});
        long time2 = System.nanoTime();
        int result2 =
                heuristics.objUFLP_2(5, 2,
                        new int[]{1, 3},
                        new int[]{200, 300, 300},
                        new int[]{1, 1, 1, 1, 1},
                        new int[][]{{500, 100, 300, 400, 100},
                                {300, 200, 300, 400, 200},
                                {200, 200, 300, 100, 300}});
        long time3 = System.nanoTime();
        System.out.println("First method:");
        System.out.println(result1);
        System.out.println(time2 - time1 + " ns");
        System.out.println("Second method:");
        System.out.println(result2);
        System.out.println(time3 - time2 + " ns");
    }
}
