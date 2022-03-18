/**
 * Class that benchmarks insertion sort and shell sort for three specific types of arrays.
 * Uses class Stopwatch and implements SER222_02_01_HW02_Submission
 *
 * Completion time: 3 hours
 *
 * @author Steven Kosanke, skosanke
 * @version 1/28/2022
 */
import java.util.*;

public class BaseNonUniform implements SER222_02_01_HW02_Submission {

    /***************************************************************************
     * START - SORTING UTILITIES, DO NOT MODIFY (FROM SEDGEWICK)               *
     **************************************************************************/

    public static void insertionSort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++)
        {
            // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }


    public static void shellsort(Comparable[] a) {
        int N = a.length;
        int h = 1;

        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...

        while (h >= 1) {
            // h-sort the array.
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                exch(a, j, j-h);
            }
            h = h/3;
        }
    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    /***************************************************************************
     * END - SORTING UTILITIES, DO NOT MODIFY                                  *
     **************************************************************************/

    @Override public Integer[] generateTestDataBinary(int size) {
        Integer[] array = new Integer[size];
        for (int i=0; i<size/2; i++) {
            array[i] = 0;
        }
         for (int i=(size/2); i<size; i++) {
            array[i] = 1;
        }
         return array;
    }


    @Override public Integer[] generateTestDataHalfs(int size) {
        int range = size; int min=0; int max = size-1; Integer input = 0;
        Integer[] array = new Integer[size];
        while (range > 1){
            for (int i=min; i<min+range/2; i++) {
                array[i] = input;
            }
            min = min+range/2;
            range = max - min + 1;
            input++;
        }
        array[max] = input;
        return array;
    }


    @Override public Integer[] generateTestDataHalfRandom(int size) {
        Integer[] array = new Integer[size];
        Random rando = new Random();
        for (int i=0; i<size/2; i++) {
            array[i] = 0;
        }
         for (int i=(size/2); i<size; i++) {
             Integer newvalue = rando.nextInt();
            array[i] = newvalue;
        }
         return array;

    }

    @Override public double computeDoublingFormula(double t1, double t2) {
        if (t2>=t1) {
            double x = (Math.log(t2/t1) / Math.log(2));
            if (isNaN(x)) {return 0.000;}
            else
                return x;
        }
        else {
            double x = (Math.log(t1/t2) / Math.log(2));
            if (isNaN(x)) {return 0.000;}
            else
                return x;
        }

    }
    public boolean isNaN(double x){
        return x != x;
    }

    @Override public double benchmarkInsertionSort(Integer[] small, Integer[] large) {
        Stopwatch a = new Stopwatch();
        insertionSort(small);
        double Ta = a.elapsedTime();

        Stopwatch b = new Stopwatch();
        insertionSort(large);
        double Tb = b.elapsedTime();

        return computeDoublingFormula(Ta, Tb);

    }

    @Override public double benchmarkShellsort(Integer[] small, Integer[] large) {
        Stopwatch a = new Stopwatch();
        shellsort(small);
        double Ta = a.elapsedTime();

        Stopwatch b = new Stopwatch();
        shellsort(large);
        double Tb = b.elapsedTime();

        return computeDoublingFormula(Ta, Tb);
    }


    @Override public void runBenchmarks(int size) {

    double ins = 0; double shl = 0;
    Integer[] originalsize = generateTestDataBinary(size);
    Integer[] doublesize = generateTestDataBinary(size*2);

    System.out.println("          Insertion        Shellsort");
    ins = benchmarkInsertionSort(originalsize, doublesize);
    shl = benchmarkShellsort(originalsize, doublesize);
    //System.out.println("Bin       " + ins + "        " + shl); //USE if there is a formatting error
    System.out.printf("%.3d","Bin       " + ins + "        " + shl); System.out.println();


    originalsize = generateTestDataHalfs(size);
    doublesize = generateTestDataHalfs(size*2);
    ins = benchmarkInsertionSort(originalsize, doublesize);
    shl = benchmarkShellsort(originalsize, doublesize);
    //System.out.println("Half      " + ins + "        " + shl); //USE if there is a formatting error
    System.out.printf("%.3d","Half      " + ins + "        " + shl); System.out.println();

    originalsize = generateTestDataHalfRandom(size);
    doublesize = generateTestDataHalfRandom(size*2);
    ins = benchmarkInsertionSort(originalsize, doublesize);
    shl = benchmarkShellsort(originalsize, doublesize);
    //System.out.println("RanInt    " + ins + "        " + shl); //USE if there is a formatting error
    System.out.printf("%.3d","RanInt    " + ins + "        " + shl); System.out.println();

    }
    public static void main(String args[]) {
        SER222_02_01_HW02_Submission me = new BaseNonUniform();
        //int size = 100000;
         int size = 4096;

        //NOTE: feel free to change size here. all other code must go in the
        //      methods.

        me.runBenchmarks(size);
    }
}