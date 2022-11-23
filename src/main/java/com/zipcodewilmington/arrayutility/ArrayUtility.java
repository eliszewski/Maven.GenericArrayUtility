package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] inputArray;
    List<T> inputList;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
        this.inputList = new ArrayList<>(Arrays.asList(inputArray));
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer counter = 0;
        getNumberOfOccurrences(arrayToMerge, valueToEvaluate);
//        for (T element: arrayToMerge
//             ) {
//            if(element.equals(valueToEvaluate))counter++;
//        }

        return getNumberOfOccurrences(valueToEvaluate) + getNumberOfOccurrences(arrayToMerge, valueToEvaluate);
    }

    public T[] removeValue(T valueToRemove) {
        List<T> removedList = new ArrayList<T>(Arrays.asList(this.inputArray));
//        Class<?> class = valueToRemove.getClass();
//        Integer len = this.inputArray.length;
//        T[] removed = (T[]) Array.newInstance(class,len - getNumberOfOccurrences(valueToRemove));
        for (T element : this.inputArray
             ) {
            if(!element.equals(valueToRemove)) removedList.add(element);
        }
//        int counter = 0;
//        for (T element: this.inputArray
//             ) {
//            if(element.equals(valueToRemove)){
//                removed[counter] = element;
//                counter++;
//            }
//        }
        //return removedList.toArray(Array.newInstance [0]);
        //return removed;
        return null;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        List<T> newList = new ArrayList<T>();
        List<T> convArr = new ArrayList<>(Arrays.asList(arrayToMerge));
        newList.addAll(this.inputList);
        newList.addAll(convArr);
        System.out.println(newList);
        //Integer mostCommon = getNumberOfOccurrences(this.inputArray[0]) + getNumberOfOccurrences(arrayToMerge,arrayToMerge[0]);
        Integer mostCommon = getNumberOfOccurrences(newList, newList.get(0));
        T mostCommonType = newList.get(0);
        Integer temp;
        T tempType;
        for (T element: newList
             ) {
                temp = getNumberOfOccurrences(newList,element);
                tempType = element;
                if(temp> mostCommon){
                    mostCommonType = tempType;
                    mostCommon = temp;
            }
        }


        return mostCommonType;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer counter = 0;
        for (T element: this.inputArray
             ) {
            if(element.equals(valueToEvaluate))counter++;
        }
        return counter;
    }
    public Integer getNumberOfOccurrences(T[] arrayToCheck,T valueToEvaluate) {
        Integer counter = 0;
        for (T element: arrayToCheck
        ) {
            if(element.equals(valueToEvaluate))counter++;
        }
        return counter;
    }
    public Integer getNumberOfOccurrences(List<T> listToCheck,T valueToEvaluate) {
        Integer counter = 0;
        for (T element: listToCheck
        ) {
            if(element.equals(valueToEvaluate))counter++;
        }
        return counter;
    }


}
