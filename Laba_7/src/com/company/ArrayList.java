package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<T> {

    private static final int DEFAULT_CAPACITY = 16;

    private T[] mArr; // Массив, хранящий элементы коллекции
    private int mSize; // Количество элементов коллекции

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }


        mArr = (T[]) Array.newInstance(Object.class, capacity);
        mSize = 0;
    }

    /*
     * Добавляет новый элемент в конец массива.
     */
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element is null");
        }

        mArr[mSize] = element;
        mSize++;

        grow();
    }

    /*
     * Добавляет новый элемент в позицию с заданным индексом.
     */
    public void add(int index, T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element is null");
        }

        if (index < 0 || index > mSize) {
            throw new IndexOutOfBoundsException("Incorrect size: " + index);
        }

        // Двигаем все элементы после вставляемого на 1 позицию вправо
        for (int i = size(); i > index; i--) {
            mArr[i] = mArr[i - 1];
        }

        mArr[index] = element;
        mSize++;

        grow();
    }

    /*
     * Возвращает элемент, находящийся на позиции с заданным индексом.
     */
    public T get(int index) {
        if (index < 0 || index >= mSize) {
            throw new IndexOutOfBoundsException("Incorrect index:" + index);
        }

        return mArr[index];
    }

    /*
     * Удаляет элемент, находящийся на позиции с заданным индексом.
     */
    public T remove(int index) {
        if (index < 0 || index >= mSize) {
            throw new IndexOutOfBoundsException("Incorrect index:" + index);
        }

        T elem = mArr[index];

        for (int i = index; i < size() - 1; i++) {
            mArr[i] = mArr[i + 1];
        }

        mSize--;
        shrink();

        return elem;
    }

    /*
     * Полностью очищает массив.
     */
    public void clear() {
        mSize = 0;
        mArr = ((T[]) Array.newInstance(Object.class, DEFAULT_CAPACITY));
    }

    /*
     * Возвращает количество элементов в массиве.
     */
    public int size() {
        return mSize;
    }

    /*
     * Возвращает текущую максимальную вместимость массива.
     */
    public int capacity() {
        return mArr.length;
    }

    /*
     * Возвращает true, если массив пуст.
     */
    public boolean isEmppty(){
        return mSize == 0;
    }

    /*
     * Возвращает индекс первого вхождения элемента o.
     */
    public int indexOf(Object o){
        if (o == null) {
            throw new IllegalArgumentException("o is null");
        }

        for(int i = 0; i < size(); i++){
            if(mArr[i].equals(o)){
                return i;
            }
        }

        return -1;
    }

    /*
     * Возвращает индекс последнего вхождения элемента o.
     */
    public int lastIndexOf(Object o){
        if (o == null) {
            throw new IllegalArgumentException("o is null");
        }

        for(int i = size() - 1; i >= 0; i--){
            if(mArr[i].equals(o)){
                return i;
            }
        }

        return -1;
    }

    /*
     * Увеличивает размер массива при необходимости (в тот момент,
     * когда в массиве остается 1 пустая ячейка).
     */
    private void grow() {
        if (mSize + 1 == mArr.length) {
            int newLength = mArr.length + (mArr.length >> 1); // Рассчитываем новую длину как 3/2 старой
            mArr = Arrays.copyOf(mArr, newLength);
//            System.out.printf("grow()");
        }
    }

    /*
     * Уменьшает размер массива при необходимости (в тот момент,
     * когда в массиве фактически лежит больше 16 элементов и
     * массив заполнен менее чем на 1/4).
     */
    private void shrink(){
        if (mSize > 16 && mSize < mArr.length / 4) {
            mArr = Arrays.copyOf(mArr, mArr.length / 4);
//            System.out.printf("shrink()");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        // Если ссылки указывают на один экземпляр
        if (this == obj) {
            return true;
        }

        // Если классы различны
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        ArrayList other = ((ArrayList) obj);

        // Если размеры списков различны
        if (this.size() != other.size()) {
            return false;
        }

        // Сравниваем списки поэлементно, ориентируясь на equals
        for (int i = 0; i < size(); i++) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(size() * 3);

        sb.append("[");
        for (int i = 0; i < size() - 1; i++) {
            sb.append(get(i)).append(", ");
        }
        if(size() > 0) {
            sb.append(get(size() - 1));
        }
        sb.append("]");

        return sb.toString();
    }
}