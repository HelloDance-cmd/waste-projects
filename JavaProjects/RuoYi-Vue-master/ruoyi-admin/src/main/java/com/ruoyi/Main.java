package com.ruoyi;

import java.util.HashMap;

public class Main {

}

class Solution {
  public boolean isSubsequence(String s, String t) {
    if(t.contains(s)){ return true; }
    HashMap<Character, Integer> counts = new HashMap<>(26);

    // 初始化计数器
    for(char ch : t.toCharArray()) {
      if(counts.get(ch) != null)
        counts.put(ch, counts.get(ch) + 1);
      else
        counts.put(ch, 0);
    }

    counts.keySet().forEach(ch -> System.out.println(ch + " " +counts.get(ch)));


    for(char ch : s.toCharArray()) {
      int count = -1;

      if(counts.get(ch) != null && (count = counts.get(ch)) != 0)
        counts.put(ch, counts.get(ch) - 1);

      if(count == 0)
        return false;
    }

    return true;
  }
}