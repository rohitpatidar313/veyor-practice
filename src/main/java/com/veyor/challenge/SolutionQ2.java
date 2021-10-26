package com.veyor.challenge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SolutionQ2 {

    private static Logger logger = LogManager.getLogger(SolutionQ2.class);
    public static void main(String[] args) throws IOException {
        String dir = SolutionQ2.class.getResource("/").getPath();
        File outPutFile = new File(dir+"out_put.txt");
        if(outPutFile.exists()){
            outPutFile.delete();
        }
        outPutFile.createNewFile();
        BufferedReader bufferedReader = new BufferedReader(new
                InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new
                FileWriter((outPutFile)));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        long k = Long.parseLong(bufferedReader.readLine().trim());
        int res = maxMoney(n, k);
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * function calculate maximum dollar amount based on given input
     * @param n - number of classmates
     * @param k - unlucky number
     * @return int - maximum dollar amount
     */
    static int maxMoney(int n, long k) {
        if(n <=0 || n>2*Math.pow(10,9) || k<=0 || k>4*Math.pow(10,15)) {
            logger.error("Number of classmates or unlucky number is out of range, number of classmates should be within 1 to 2*10^9 and unlucky number should be 1 to 4*10^15 inclusive.");
            return 0;
        }
        int i=1; int removeIndex=1;int sum=0;
        while(i<=n){
            sum += i;
            if(sum==k){
                sum -= removeIndex;
                removeIndex++;
            }
            i++;
        }
        return sum;
    }
}
