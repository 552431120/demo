package com.study.demo.test;

import com.study.demo.bean.Person;

import java.util.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author dongzhanjun
 * @Date 2020/12/15 10:25
 * @Version 1.0
 */
public class Test {
    //查出
    public  static String monotoneIncreasingDigits(int N) {
        String nstr = String.valueOf(N);
        char[] nchar = nstr.toCharArray();
        StringBuilder maxIntStr = new StringBuilder();
        Integer maxBe=null;
        for(int i=0;i<nchar.length;i++){
            if(i==nchar.length-1){
                return String.valueOf(N);
            }
           char charBe = nchar[i];
           char  charAf= nchar[i+1];
           Integer numBe = Integer.valueOf(String.valueOf(charBe));
           Integer numAf = Integer.valueOf(String.valueOf(charAf));
           maxIntStr.append(numBe);
           if(numAf<numBe){
               for (int j = 1; j<nchar.length-i; j++) {
                   maxIntStr.append(9);
               }
               maxBe = numBe;
               break;
           }
        }
        String finalInt = "";
        if(maxBe!=null){
             finalInt = maxIntStr.toString().replaceAll(maxBe+"",(maxBe-1)+"");
        }else {
            finalInt =  maxIntStr.toString();
        }
        return finalInt;
    }

    //贪心算法
    public static void  monotoneIncreasingDigitsV2(int N){
        //转化成char[]
        char[] chars = Integer.toString(N).toCharArray();
        int flag = -1;
        for (int i = chars.length-1; i >0 ; i--) {
            System.out.println(chars[i]);
            if(chars[i]<chars[i-1]){
                flag=i;
                chars[i-1]--;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if(i>=flag){
                chars[i]='9';
            }
        }

        System.out.print(Integer.valueOf(new String(chars)));
    }

    //最长无重复字符串
    public static Integer lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }
        char[] sChars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < sChars.length ; i++) {
            if(max==sChars.length-1){
                break;
            }
            char current = sChars[i];
            for (int j = i+1; j <sChars.length; j++) {
                char finalChar = sChars[j];
                if(current==finalChar){
                    if(j-i>max){
                       max = j-i;
                    }
                    break;
                }
            }
        }
        if(max==0){
            return sChars.length;
        }
        return max;
    }


    public static void main(String[] args) {
//        monotoneIncreasingDigitsV2(10);
//        System.out.println(lengthOfLongestSubstringV2("abbcadea"));
//        String test = "hahahahehehe";
//        char[] chars = test.toCharArray();
//        byte[] bytes = test.getBytes();
        String finalIntStr = revertInteger(1);
        System.out.println("args = " + finalIntStr);
    }


//    public static int lengthOfLongestSubstringV2(String s) {
//        if (s.length()==0) return 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//        int max = 0;
//        int left = 0;
//        for(int i = 0; i < s.length(); i ++){
//            if(map.containsKey(s.charAt(i))){
//                left = Math.max(left,map.get(s.charAt(i)) + 1);
//            }
//            map.put(s.charAt(i),i);
//            max = Math.max(max,i-left+1);
//        }
//        return max;
//    }

    /**
     * 窗口算法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringV2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    //整数反转
    public static String revertInteger(Integer source){
        if(source!=null){
            String srcStr = String.valueOf(source);
            if(-9<=source && source<=9){
                return srcStr;
            }else {
                char[] chars = srcStr.toCharArray();
                StringBuilder targetStr = new StringBuilder();
                for (int i = chars.length-1; i >=0; i--) {
                    if(chars[i]=='-'){
                        continue;
                    }
                    targetStr.append(chars[i]);
                }
                if(Long.valueOf(srcStr)>Integer.MAX_VALUE){
                    return "0";
                }
                return targetStr.toString();
            }
        }
        return "0";
    }

    static class PersonComparator implements Comparator<Person>{
        public static void main(String[] args) {
           Person p1= new Person("dzj",11);
           Person p2= new Person("cly",222);
           List<Person> personList = new ArrayList<>();
           personList.add(p1);
           personList.add(p2);
           Person[] personArr = personList.toArray(new Person[personList.size()]);
           Arrays.sort(personArr, Comparator.comparing(Person::getAge));
        }

         @Override
         public int compare(Person p1, Person p2) {
             return p1.getAge().compareTo(p2.getAge());
         }
     }


     //四数相加等于target
    public void sum4Num(Integer[] intArr){

    }




}
