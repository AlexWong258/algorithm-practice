public class ArraySwap {
    public void swap(int[] num, int index) {
        int len = num.length;
        int temp = num[index];

        if (len > 1) {
            if (index == len-1 ){
                for (int i = len-2; i >= 0; i--){
                    num[i+1] = num[i];
                }
                num[0] = temp;
            } else if (index == 0) {
                for (int i=0; i<=len-2;i++) {
                    num[i] = num[i+1];
                }
                num[len-1] = temp;
            } else {
                int k = 0;
                for (int i =index;i>=0;i--) {
                    for (int j = i+1;j<len-index+i-2;j++) {
                        num[j-1] = num[j];
                    }
                    if (i-1>=0)
                        num[len-1-k] = num[i-1];
                    k++;
                }
                num[len-1-index] = temp;
            }
        }
        



    }

    public static void main(String[] args) {
        ArraySwap arraySwap = new ArraySwap();
        int[] num = {5,3,4,6,2,10,12,1};
        int index = 2;

        arraySwap.swap(num, index);

        for (int i :
                num) {
            System.out.print(i + ",");
        }
    }
}
