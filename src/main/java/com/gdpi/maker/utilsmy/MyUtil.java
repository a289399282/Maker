package com.gdpi.maker.utilsmy;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MyUtil {
    /**
     * 排行
     * @param hashMap
     * @return
     */
    /*public static Map<String, Integer> getSortMapByValueDesc(Map<String, Integer> hashMap) {
        // -- 根据value的数量排序
        Map<String, Integer> orderByValueTreeMap = new TreeMap<String, Integer>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        if (hashMap.get(obj1) != hashMap.get(obj2)) {
                            return hashMap.get(obj2).compareTo(hashMap.get(obj1));
                        } else {
                            return hashMap.get(obj1);
                        }
                    }
                }
        );
        orderByValueTreeMap.putAll(hashMap);
        return orderByValueTreeMap;
    }*/
    public static Map<String, Integer> getSortMapByValueDesc(Map<String, Integer> hashMap) {
        // -- 根据value的数量排序
        Map<String, Integer> orderByValueTreeMap = new TreeMap<String, Integer>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        if (hashMap.get(obj1) != hashMap.get(obj2)) {
                            return hashMap.get(obj2).compareTo(hashMap.get(obj1));
                        } else {
                            return hashMap.get(obj1);
                        }
                    }
                }
        );
        orderByValueTreeMap.putAll(hashMap);
        return orderByValueTreeMap;
    }

}
