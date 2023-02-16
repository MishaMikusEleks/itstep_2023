package itstep.task_3;

import java.util.*;

public class ArraysTask {

    public static void main(String[] args) {
        arrayTask();
        collectionTask();
        mapTask();
    }

    private static void mapTask() {
        //3) Given: String with big text (more than 1000 words).
        // Write a method that calculates the numbers of words for each
        // letter that starts the word.
        String input="Given: String with big text (more than 1000 words). Write a method that calculates the numbers of words for each letter that starts the word.";
        System.out.println(calculateText(input));
    }

    private static Map<Character,Integer> calculateText(String input) {
        Map<Character,Integer> resMap= new TreeMap<>();
        for(String word:input.split(" ")){
            char firstChar=word.charAt(0);
            resMap.putIfAbsent(firstChar,0);
            resMap.put(firstChar, resMap.get(firstChar)+1);
        }
        return resMap;
    }

    private static void collectionTask() {
        //#Collections
        //1) Implement an application to work with a list.
        // In the 1st half of the list replace all elements E1 with E2
        //2) Input: matrix of integers.
        //a) Print out matrix in reverse order.
        //b) Print out matrix with unique values (delete duplicates)
        List<String> inputList=new ArrayList<>(Arrays.asList("E1","E22","E1","E4","E5","E7","E1","E5","E7"));
        List<String> resList=new ArrayList<>();
        int middleIndex=inputList.size()/2;
        for(int i=0;i<inputList.size();i++){
            if(i<=middleIndex && "E1".equals(inputList.get(i))){
                resList.add("E2");
            } else {
                resList.add(inputList.get(i));
            }
        }
        System.out.println(inputList);
        System.out.println(resList);
    }

    private static void arrayTask() {
        //#Array
        //1) Find max number in array: 5, 9, 3, 2, 0, -4, -8.3, 3, -4
        //2) Given array: {1, 6, 3, 3, 4, 5, 5, 6, 0}. Print array with only unique values, which are sorted.
        //3)Given an array, e.g. "12", "23", "34", "12", "56", "67“. Replace all values “12” to “replaced”
        //4) Print any array in reverse mode (from the end)
        double[] array1= {5, 9, 3, 2, 0, -4, -8.3, 3, -4};
        double max=array1[0];
        for(int i=0;i<array1.length;i++){
            System.out.print(array1[i]+" ");
            if(max<array1[i]){
                max=array1[i];
            }
        }
        System.out.println();
        System.out.println("max "+max);
    }


    //
    //3) Given: String with big text (more than 1000 words). Write a method that calculates the numbers of words for each letter that starts the word.
    //4) Check performance for some List operations (get(i), insertAfter(i), ..) for different collection implementations.
    //
    //#Exceptions
    //1) Make your own Exception implementation. Use it in your CalcApp
}
