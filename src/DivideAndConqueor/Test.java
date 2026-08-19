package DivideAndConqueor;

public class Test {
    public static void main(String[] args) {

    }


    ///  This is a practice file, remember to read it once and remove the code.
    /// Perform the sorting algorithms here by writing it down.























    public static void mergeSort(int [] arr,int si,int ei){

        if(si >= ei){
            return;
        }

        // for the given array get mid
        int mid = si + (ei - si)/2;


        // get left part of array and divide it more
        mergeSort(arr,si,mid);
        // get right part of array and divide it more
        mergeSort(arr,mid+1,ei);

        merge(arr,si,mid,ei);
    }

    public static void merge(int [] arr,int start,int mid,int end){

        // a temporary array
        int [] temp = new int[end - start + 1 ];

        // iterator of left array
        int i = start;

        // iterator of right array
        int j = mid+1;


        // iterator for temp
        int k = 0;
        while (i <= mid && j <=end){
            if(arr[i]<=arr[j]){
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }

            k++;
        }


        // remaining
        while (i <=mid){
            temp[k++] = arr[i++];
        }
        // remaining
        while (j <= end){
            temp[k++] = arr[j++];
        }

        for (k=0,i=start; k < temp.length;k++,i++){
            arr[i] = temp[k];
        }
    }


//    !!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // end = arr.length - 1
//    !!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static void QuickSort(int [] arr,int start, int end){

        if(start >= end){
            return;
        }

        int idx = partition(arr,start,end);

        // idx will be the index of the last chosen pivot which will be at its correct position

        QuickSort(arr,start,idx-1);
        QuickSort(arr,idx+1,end);


    }

    public static int partition(int []arr, int start, int end){

        int i = start-1;
        int pivot = arr[end];

        /*So basically this behaves Like a two pointer method where for a given target element all smaller elements
         should be at left, and greater elements at right. order to elements doesnt matter

         */
        for (int j = start; j < end; j++) {
            if(arr[j] <= pivot){

                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }
}
