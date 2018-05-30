package io.goorm.edu.Chapter06;

public class MyHeap<T extends Comparable<T>> {
    private static final int CAPACITY = 4096;
    private T[] arr;
    private int size;

    public MyHeap() {
        this.arr = (T[]) new Object[CAPACITY];
        this.size = 0;
    }

    public void push(T x) {
        this.size += 1; //원소가 증가한다
        arr[this.size] = x; // 가장 마지막에 새 원소 삽입

        int child = this.size;
        int parent = this.size / 2; //부모 노드 번호
        while ( parent >= 1 ) { // 최대 조상의 수 만큼만 반복
            if( arr[child].compareTo(arr[parent]) > 0) { //힙 성질을 위반하는 부모/자식
                // 두 값을 교환
                T temp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = temp;
            } else {
                break;
            }

            child /= 2;
            parent /= 2;
        }
    }


    public T poll() { //pop
        T ret = this.arr[1];
        arr[1] = arr[size]; // 마지막 원소를 루트로
        arr[size] = null;   // 빈칸은 비우고
        this.size -= 1;     // 원소줄은거 반영

       int parent = 1;
       while (parent <= this.size) {
           int lchild = parent * 2;
           int rchild = parent * 2 + 1;
           int next = parent;   // 교환후에 어디로 가야하는지
           if (lchild <= this.size && arr[lchild].compareTo(arr[next]) > 0) {
               // 왼쪽 자식이 존재하고 부모보다 더 큰 값을 가질때
              next = lchild;
           }

           if (rchild <= this.size && arr[rchild].compareTo(arr[next]) > 0) {
               // 오른쪽 자식이
               // 부모노드와 왼쪽자식보다 더 클때
               next = rchild;
           }

           if (next == parent) break;   // heap조건 만족

           // heap 조건 불만족후에 자리변경 이러안ㅁ
           parent = next;
       }

       return ret;
    }

    public T peek() { // top
        return this.arr[1];
    }

}
