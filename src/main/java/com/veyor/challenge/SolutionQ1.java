package com.veyor.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionQ1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Result.customSort(arr);
        bufferedReader.close();
    }
}
class Result {
    private static Logger logger = LogManager.getLogger(Result.class);
    /*
     * Complete the 'customSort' function below.
     * The function accepts INTEGER_ARRAY arr as parameter.
     * This function sorts array of integer as priority based on frequency of elements and increasing order of value if frequency matches
     * @param List of integers
     * @return void
     */
    public static void customSort(List<Integer> arr) {
         int size = arr.size();
        if(size<=0 || size > 2* Math.pow(10,5)) {
            logger.error("List size out of range, it should be within 1 to 2*10^5 inclusive.");
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            if(n <= 0 || n > Math.pow(10,6)) {
                logger.error("Integer is out of range, it should be within 1 to 10^6 inclusive.");
                return;
            }
            map.put(n, 1 + map.getOrDefault(n, 0));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? a - b : map.get(a) - map.get(b));
        pq.addAll(map.keySet());
        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int num = pq.remove();
            int freq = map.get(num);
            for (int i = 0; i < freq; i++) result.add(num);
        }
        result.stream().mapToInt(i -> i).toArray();
    }
}
