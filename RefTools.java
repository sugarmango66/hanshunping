//创建一个类, 编写一个方法，可以完成对 int 数组冒泡排序的功能 从小到大
//灵活运用 对象数组。比如对Person对象的年龄进行排序，更改参数类型，详见assignment.chap08.q01
class RefTools {
    public void bubbleSort(int[] arr) {
        int temp;
        //外循环 轮数是数组长度-1
        for (int i = 0; i < arr.length - 1; i++) {
            //内循环 比较次数是轮数-i(每一轮得到的末尾最大值不需要再次比较)
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //相邻两数比较，较大的向后放
                if (arr[j] > arr[j + 1]) {
                    //交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}