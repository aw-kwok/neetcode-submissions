class DynamicArray {
    int[] arr;
    int size;


    public DynamicArray(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (size == arr.length) resize();
        arr[size] = n;
        size++;
    }

    public int popback() {
        size--;
        int temp = arr[size];
        arr[this.size] = 0;
        return temp;
    }

    private void resize() {
        int[] copy = arr;
        arr = new int[arr.length * 2];
        for (int i = 0; i < copy.length; i++) {
            arr[i] = copy[i];
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return arr.length;
    }
}
