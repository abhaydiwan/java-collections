package com.abhay.language.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Pair
{
    public int x, y;
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class printQuadruplets
{
    public static boolean getFourNumber(int[] arr, int n, int sum)
    {
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                int val= (arr[i] + arr[j]);
                if (map.containsKey(sum-val))
                {
                    for (Pair pair : map.get(sum-val))
                    {
                        int x = pair.x;
                        int y = pair.y;
                        if ((x != i && x != j) && (y != i && y != j))
                        {
                            return true;
                        }
                    }
                }
                map.putIfAbsent(arr[i] + arr[j], new ArrayList<>());
                map.get(arr[i] + arr[j]).add(new Pair(i, j));
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        int arr[] = { 2, 7, 3, 2, 9, 5, 9, 3 };
        int sum = 25;
        if (getFourNumber(arr, arr.length, sum))
        {
            System.out.println("Yes");
        }
        else
            System.out.println("No");
    }
}