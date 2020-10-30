//package org.example.Algo;
//
//import java.util.*;
//
///**
// * @program: nettylearn
// * @description: LRU系统设计
// * @author: 占翔昊
// * @create 2020-10-12 22:32
// **/
//public class DesignLRU {
//    public static void main(String[] args) {
//        Map<Integer,Integer> priority_map = new HashMap(
//                new Comparator<Map.Entry<Integer,Integer>>() {
//                    @Override
//                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                        return o1.getValue() - o2.getValue();
//                    }
//                }
//        );
//        priority_map.put(1,3);
//        priority_map.put(2,4);
//        priority_map.put(0,5);
//        for(Map.Entry<Integer,Integer> entry : priority_map.entrySet()) {
//            System.out.println(entry.getKey() + "  " + entry.getValue());
//        }
//    }
//    public int[] LRU (int[][] operators, int k){
//        // write code here
//        // 结果集合
//        ArrayList<Integer> res = new ArrayList<>();
//        // 缓存
//        Map<Integer,Integer> cache = new HashMap<>();
//        // 优先级
//        Map<Integer,Integer> priority_map = new TreeMap(
//                new Comparator<Map.Entry<Integer,Integer>>() {
//                    @Override
//                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                        return o1.getValue() - o2.getValue();
//                    }
//
//
//
//                }
//        );
//        priority_map.put(1,3);
//        priority_map.put(2,4);
//        priority_map.put(0,5);
//        for(Map.Entry<Integer,Integer> entry : priority_map.entrySet()) {
//            System.out.println(entry.getKey() + "  " + entry.getValue());
//        }
////        for(int i=0;i<operators[0].length;++i) {
////            if(operators[i].length == 3) {
////                //放入缓存
////                cache.put(operators[i][1],operators[i][2]);
////                if(!priority_map.containsKey(operators[i][1])){
////                    priority_map.put(operators[i][1],priority_map.size()+1);
////                }else{
////                    priority_map.put(operators[i][1],priority_map.size());
////                }
////                //判断是否超过k
////                if(priority_map.size() > k) {
////                    priority_map.remove(priority_map.keySet().);
////                }
////            }else if (operators[i].length == 2){
////                //取出
////                if(priority_map.size() > k) {
////                    //如果超过空间
////                    res.add(-1);
////                }else{
////
////                }
////            }
////            for(int j=0;j<operators.length;++j){
////
////            }
////        }
//        return null;
//    }
//}
