package com.company;

public class Main {

    public static void main(String[] args) {
        // Используем ArrayList из своего пакета
        ArrayList<Integer> list = new ArrayList<>();

        // Добавляем 20 элементов
        for(int i = 0; i < 20; i++){
            list.add(i);
        }
        System.out.println(list);

        // Добавляет элемент по индексу, удаляем элементы
        list.add(20, 100);
        list.remove(0);
        list.remove(list.size() - 1);
        list.remove(9);
        list.add(1);
        System.out.println(list);

        // Используем поиск элемента
        System.out.println(String.format("1 was found at: %d and %d", list.indexOf(1), list.lastIndexOf(1)));

        // Очищаем список
        list.clear();
        System.out.println(list);

    }
}
