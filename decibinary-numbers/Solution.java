import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static long twoToPowerOf(long n) {
        long result = 1;
        for(long i=0; i<n; i++) {
            result*=2;
        }
        return result;
    }
    
    static long tenToPowerOf(long n) {
        long result = 1;
        for(long i=0; i<n; i++) {
            result*=10;
        }
        return result;
    }

    static long[] findDigitNum(long x) {
        long[] result = new long[2];
        result[0] = 0;
        result[1] = 0;
        long num = 1;
        while(true) {
            if(x<=num) {
                break;
            }
            result[1]=num;
            num+=twoToPowerOf(2*result[0]);
            result[0]++;
        }
        return result;
    }
    
    static long findMax(long dec) {
    	long max = 0;
    	while(true) {
    		if(dec<twoToPowerOf(max)) {
    			break;
    		}
    		max++;
    	}
    	return tenToPowerOf(max);
    }
    
    static long decibinary(long n) {
        int i =0;
        long sum = 0;
        while(n!=0) {
            sum+=(n%10)*(twoToPowerOf(i));
            n = n/10;
            i++;
        }
        return sum;
    }
    
    static long decibinaryNumbers(long x) {
    	long dec = 0;
    	long size = 0;
    	long begin = -1;
    	long max = findMax(dec);
    	while(x>size) {
    		begin++;
    		if(decibinary(begin)==dec) {
    			size++;
    		}
    		if(begin==max) {
    			begin=-1;
    			dec++;
    			max = findMax(dec);
    		}
    	}
    	return begin;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long result = decibinaryNumbers(x);
            System.out.println(result);
        }
        in.close();
    }
}
