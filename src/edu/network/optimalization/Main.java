package edu.network.optimalization;

import edu.network.optimalization.utils.Heuristics;

public class Main {

    public static void main(String[] args) {
        Heuristics heuristics = new Heuristics();

        heuristics.findOptimalExchangeHeuristics(3, //sklady
                5, //pocet zakaznikov
                new int[]{200, 300, 300}, //fixne naklady
                new int[]{1, 1, 1, 1, 1}, //poziadavky
                new int[][]{{500, 100, 300, 400, 100},  //vzdialenosti
                        {300, 200, 300, 400, 200},
                        {200, 200, 300, 100, 300}});

            heuristics.findOptimalExchangeHeuristics(10, //sklady
                    10, //pocet zakaznikov
                    new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, //fixne naklady
                    new int[]{1, 1, 1, 2, 1, 1, 1, 1, 1, 1}, //poziadavky
                    new int[][]{{0, 2, 8, 7, 5, 3, 1, 9, 4, 6},  //vzdialenosti
                            {2, 0, 6, 7, 3, 3, 1, 7, 2, 4},
                            {8, 6, 0, 8, 3, 9, 7, 9, 4, 6},
                            {7, 7, 8, 0, 8, 8, 6, 4, 9, 11},
                            {5, 3, 3, 8, 0, 6, 4, 6, 1, 3},
                            {3, 3, 9, 8, 6, 0, 2, 10, 5, 6},
                            {1, 1, 7, 6, 4, 2, 0, 8, 3, 5},
                            {9, 7, 9, 4, 6, 10, 8, 0, 5, 7},
                            {4, 2, 4, 9, 1, 5, 3, 5, 0, 2},
                            {6, 4, 6, 11, 3, 6, 5, 7, 2, 0}});

        int T = 100;
        while(T > 1) {
            System.out.println("Warmness: " + T);
            heuristics.findOptimal(5, //sklady
                    10, //pocet zakaznikov
                    new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, //fixne naklady
                    new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, //poziadavky
                    new int[][]{{50, 10, 30, 40, 10, 50, 20, 30, 30, 45},  //vzdialenosti
                            {30, 20, 20, 40, 20, 55, 30, 30, 15, 30},
                            {20, 20, 30, 30, 30, 40, 50, 30, 20, 20},
                            {40, 15, 35, 30, 20, 40, 40, 30, 25, 20},
                            {75, 20, 25, 50, 25, 55, 35, 30, 20, 30}},
                    T);
            T /= 2;
        }

        /*
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
        */

    }
}
