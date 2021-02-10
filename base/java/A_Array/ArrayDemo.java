package java.A_Array;

public class ArrayDemo {

    // 元素个数
    private int count;

    // 数组长度
    private int length;

    // 数组内的数据
    private int[] data;

    public ArrayDemo(int capacity) {
        this.count = 0;
        this.length = capacity;
        this.data = new int[capacity];
    }

    /**
     * 在末尾插入元素
     * @param item
     * @return
     */
    public int add(int item) {
        if (count == length) {
            this.resize(length * 2);
        }
        this.data[count] = item;
        count++;
        return count - 1;
    }

    public int add(int item, int index) {
        this.checkIndexForAdd(index);
        if (count == length) {
            this.resize(length * 2);
        }
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        count++;
        return 0;
    }

    public int getArrayLength() {
        return this.length;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += this.data[i] + "  ";
        }
        return result;
    }

    /**
     * 数组扩容
     */
    private void resize(int capacity) {
        int[] newData = new int[capacity];
        for (int i = 0; i < length; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
        this.length = capacity;
    }

    private void checkIndexForAdd(int index) {
        if(index < 0 || index >= length) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }


    public static void main(String[] args) {
        ArrayDemo arrayDemo = new ArrayDemo(5);
        arrayDemo.add(1);
        arrayDemo.add(2);
        arrayDemo.add(3);
        arrayDemo.add(4);
        arrayDemo.add(5);
        arrayDemo.add(6);

        arrayDemo.add(8, 8);

        System.out.println(arrayDemo.toString());
        System.out.println("数组长度：" + arrayDemo.getArrayLength());
    }
}
