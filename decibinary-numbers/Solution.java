import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
	static HashMap<Long, ArrayList<Long>> hm = new HashMap<>();
	static ArrayList<Long> sizeArr = new ArrayList<>();
	static long size=0;
	static long dec = 0;
	static long begin = 0;
	
    static long findMax(long dec) {
    	long max = 0;
    	while(true) {
    		if(dec<Math.pow(2,max)) {
    			break;
    		}
    		max++;
    	}
    	return (long) Math.pow(10,max);
    }
    
    static long decibinary(long n) {
        int i =0;
        long sum = 0;
        while(n!=0) {
            sum+=(n%10)*(Math.pow(2,i));
            n = n/10;
            i++;
        }
        return sum;
    }
    
    static void completeTable(long x) {
    	while(true) {
    		long max = findMax(dec);
    		while(begin<=max) {
    			long decNum = decibinary(begin);
    			if(hm.containsKey(decNum)) {
    				hm.get(decNum).add(begin);
    			}
    			else {
    				ArrayList<Long> arr = new ArrayList<>();
    				arr.add(begin);
    				hm.put(decNum, arr);
    			}
    			begin++;
    		}
    		size+=hm.get(dec).size();
    		sizeArr.add(size);
    		dec++;
    		if(x<=size) {
    			break;
    		}
    	}
    }
    
    static long decibinaryNumbers(long x) {
    	
    	if(x>size) {
    		completeTable(x);
    	}
    	
    	long d = 0;
		while(x>sizeArr.get((int) d)) {
			d++;
		}
		long s = 0;
    	if(d>0) {
    		s = sizeArr.get((int) (d-1));
    	}
    	return hm.get(d).get((int)(x-s-1));
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
