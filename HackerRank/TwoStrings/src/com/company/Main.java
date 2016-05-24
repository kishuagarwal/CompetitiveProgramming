package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String a,b;
        for (int i = 0; i < t; i++) {
            a = in.next();
            b = in.next();
            boolean exists = false;
            for (int j = 'a'; j <= 'z' ; j++) {
                if(a.indexOf(j) != -1 && b.indexOf(j) != -1)
                {
                    exists = true;
                    break;
                }
            }
            if(exists)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        in.close();;
    }
}
