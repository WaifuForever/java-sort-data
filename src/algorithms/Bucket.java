package src.algorithms;

import src.interfaces.Sorter;

public class Bucket implements Sorter {
    private class CustomArray {
        private int size = 0;
        private Integer[] arr;

        CustomArray(int size) {
            arr = new Integer[size];
            this.size = size - 1;
        }

        CustomArray() {
            arr = new Integer[0];

        }

        public void add(int n) {
            if (isFull())
                doubleSize();

            arr[size] = n;
            size++;

        }

        public int get(int n) {
            if (n > size || n < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return arr[n];
        }

        public boolean isFull() {
            return arr.length == size;
        }

        public Integer[] array() {
            return arr;
        }

        private void doubleSize() {
            Integer[] newArr = new Integer[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

    }

    private int getMax(Integer[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (k < arr[i])
                k = arr[i];
        }
        return k;
    }

    public void bucketSort(Integer[] arr) {
        int k = String.valueOf(getMax(arr)).length();
        int chunkSize = 10;

        CustomArray[] buckets = new CustomArray[chunkSize];

        for (int i = 0; i < chunkSize; i++)
            buckets[i] = new CustomArray();

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i] / (int) Math.pow(chunkSize, k - 1)) {
                case 0:
                    buckets[0].add(arr[i]);
                    break;
                case 1:
                    buckets[1].add(arr[i]);
                    break;
                case 2:
                    buckets[2].add(arr[i]);
                    break;
                case 3:
                    buckets[3].add(arr[i]);
                    break;
                case 4:
                    buckets[4].add(arr[i]);
                    break;
                case 5:
                    buckets[5].add(arr[i]);
                    break;
                case 6:
                    buckets[6].add(arr[i]);
                    break;
                case 7:
                    buckets[7].add(arr[i]);
                    break;
                case 8:
                    buckets[8].add(arr[i]);
                    break;
                case 9:
                    buckets[9].add(arr[i]);
                    break;
                default:
                    break;
            }
        }
        int marker = 0;
        for (int i = 0; i < chunkSize; i++) {
            new Insertion2().sortArray(buckets[i].array());
            for (int j = 0; j < chunkSize; j++) {
                if (buckets[i].size > j) {
                    arr[marker] = buckets[i].get(j);
                    marker++;
                }
            }

        }

    }

    public void sortArray(Integer[] arr) {
        bucketSort(arr);

    }
}
