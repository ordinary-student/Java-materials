public class commonAlgorithm
{ 

    /**
     * 判断一个数是否为素数
     *
     * @param num
     * @return
     */
    private static boolean isPrime(int num) 
    {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int x = 3; x * x <= num; x += 2)
            if (num % x == 0)
                return false;

        return true;
    }

    // 计算arr[l...n)这个区间内所有数字的和
    private static int sum(int[] arr, int l) 
    {
        if (l == arr.length)
            return 0;
        return arr[l] + sum(arr, l + 1);
    }

    /**
     * 交换数组元素
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(Object[] arr, int i, int j)
    {

        if (i < 0 || i >= arr.length)
            throw new IllegalArgumentException("i is out of bound.");

        if (j < 0 || j >= arr.length)
            throw new IllegalArgumentException("j is out of bound.");

        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 求n的和
     *
     * @param n
     * @return
     */
    private static int sum(int n) 
    {

        if (n < 0)
            throw new IllegalArgumentException("n should be greater or equal to zero.");

        int ret = 0;
        for (int i = 0; i <= n; i++)
            ret += i;
        return ret;
    }

    /**
     * 翻转数组
     *
     * @param arr
     */
    private static void reverse(Object[] arr) {

        int n = arr.length;
        for (int i = 0; i < n / 2; i++)
            swap(arr, i, n - 1 - i);
    }

    /**
     * 选择排序
     *
     * @param arr
     * @param n
     */
    private static void selectionSort(Comparable[] arr, int n)
    {

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;

            swap(arr, i, minIndex);
        }
    }

    /**
     * 二分查找
     *
     * @param arr
     * @param n
     * @param target
     * @return
     */
    public static int binarySearch(Comparable[] arr, int n, Comparable target) 
    {

        int l = 0, r = n; // 在[l...r)的范围里寻找target
        while (l < r) {    // 当 l == r 时, 区间[l...r)是一个无效区间
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) return mid;
            if (target.compareTo(arr[mid]) > 0)
                l = mid + 1;  // target在[mid+1...r)中; [l...mid]一定没有target
            else    // target < arr[mid]
                r = mid;  // target在[l...mid)中; [mid...r)一定没有target
        }
        return -1;
    }

}
