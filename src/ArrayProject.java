import java.util.Random;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

public class ArrayProject {
    static Random rand=new Random();
    public static void main(String[] args) {
        float[] list={5, 10, 15};
        System.out.println(avg(list, 0));
    }

    public static float avg(float[] list, int ind) {
        return list[ind]/list.length+((list.length==ind+1)?0:avg(list, ind+1));
    }

    public static int linearSearch(int[] list, int target) {
        for(int i=0; i<list.length; i++) {
            if(list[i]==target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] list, int target) {
        int min=0;
        int max=list.length-1;
        while(max>=min) {
            int mid=(min+max)/2;
            if(list[mid]>target) {
                max=mid-1;
            }
            else if(list[mid]<target) {
                min=mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public static int[] bubbleSort(int[] list) {
        for(int i=0; i<list.length-1; i++) {
            for(int j=0; j<list.length-i-1; j++) {
                if (list[j]>list[j+1]) {
                    list[i]=list[i]+list[j];
                    list[j]=list[i]-list[j];
                    list[i]=list[i]-list[j];
                }
            }
        }
        return list;
    }

    public static int[] selectionSort(int[] list) {
        for(int i=0; i<list.length; i++) {
            int min=i;
            for(int j=i; j<list.length; j++) {
                if(list[j]<list[min]) min=j;
            }
            int temp=list[i];
            list[i]=list[min];
            list[min]=temp;
        }
        return list;
    }



    public static int[] mergeSort(int[] list) {
        int list1[]=new int[(int)floor(list.length/2f)];
        int list2[]=new int[(int)ceil(list.length/2f)];
        for(int i=0; i<(int)floor(list.length/2f); i++) {
            list1[i]=list[i];
        }
        for(int i=0; i<(int)ceil(list.length/2f); i++) {
            list2[i]=list[i+(int)floor(list.length/2f)];
        }
        if(list.length>2) {
            list1=mergeSort(list1);
            list2=mergeSort(list2);
        }
        int count1=0, count2=0;
        for(int i=0; i<list.length; i++) {
            if(count1==list1.length) {
                list[i]=list2[count2];
                count2++;
            } else if(count2==list2.length) {
                list[i]=list1[count1];
                count1++;
            } else if(list1[count1]<list2[count2]) {
                list[i]=list1[count1];
                count1++;
            } else {
                list[i]=list2[count2];
                count2++;
            }
        }
        return list;
    }

    public static void printList(int[] list) {
        for(int i=0; i<list.length; i++) {
            System.out.print(list[i]+", ");
        }
        System.out.println();
    }
}