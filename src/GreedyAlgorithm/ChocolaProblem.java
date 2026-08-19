package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        int p = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4}; // vertical cuts
        Integer costHor[] = {4, 1, 2};       // horizontal cuts

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        // main greedy loop
        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] >= costHor[h]) {
                cost += costVer[v] * hp;  // vertical cut
                vp++;
                v++;
            } else {
                cost += costHor[h] * vp;  // horizontal cut
                hp++;
                h++;
            }
        }

        // remaining horizontal cuts
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        // remaining vertical cuts
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        System.out.println("Minimum Cost of cuts = " + cost);
    }
}
