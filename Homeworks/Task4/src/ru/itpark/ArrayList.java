package ru.itpark;

public class ArrayList {
    // первоначальный размер массива
    private int INITIAL_SIZE = 100;
    // поле - хранилище данных
    private int buff[];
    // поле - буферный
    private int elements[];
    // количество элементов массива
    private int count;

    public ArrayList() {
        elements = new int[INITIAL_SIZE];
        count = 0;
    }

    /**
     * 1.Добавить элемент в конец
     *
     * @param element
     */
    public void add(int element) {
        if (fullArray(count)) {
            elements[count] = element;
            count++;
        }
    }

    /**
     * 2.Добавить элемент в начало списка, со сдвигом вправо
     *
     * @param element
     */
    public void addToBegin(int element) {
        if (fullArray(count)) {
            for (int i = count; i > 0; i--) {
                elements[i] = elements[i - 1];
            }
            elements[0] = element;
            count++;
        }
    }

    /**
     * 3.Вставить элемент в заданную позицию со сдвигом
     *
     * @param element сам элемент
     * @param index   индекс, куда надо вставить
     */
    public void insert(int element, int index) {
        if (fullArray(count)) {
            for (int i = count; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[0] = element;
            count++;
        }

    }

    /**
     * 4.Получить элемент по индексу
     *
     * @param index
     * @return сам элемент по заданному индексу
     */
    public int get(int index) {
        if (index > count) {
            return elements[index];
        } else {
            return -1;
        }
    }

    /**
     * 5.Заменить элемент в заданной позиции новым элементом
     *
     * @param index
     * @param element
     */
    public void replace(int element, int index) {
        if (index > count) {
            elements[index] = element;
        } else {
            System.out.println("По указанному индексу нет значения, операция не выполнена");
        }
    }

    /**
     * 6.Сортировка вставками
     *
     * @param index
     * @return
     */
    public void sort(int index) {
        int min = index;
        int temp;
        if (index != count) {
            for (int i = index; i < count - 1; i++) {
                if (elements[i + 1] < elements[i])
                    min = i + 1;
            }
            temp = elements[index];
            elements[index] = elements[min];
            elements[min] = temp;
            index++;
            sort(index);
        }
    }

    /**
     * 7.Реверсия массива
     */
    public void reverse() {
        int temp;
        for (int i = 0; i < count / 2; i++) {
            temp = elements[count - 1 - i];
            elements[count - 1 - i] = elements[i];
            elements[i] = temp;
        }
    }

    /**
     * 8.Удалить элемент по индексу
     *
     * @param index
     */
    public void remove(int index) {
        for (int i = index; i < count; i++) {
            elements[i] = elements[i + 1];
        }
        count--;
    }

    /**
     * 9.Вернуть индекс элемента, если элемента нет = -1
     *
     * @param element
     * @return
     */
    public int find(int element) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 10.Показать массив
     */
    public void сoutArray() {
        System.out.println("Элементы массива:");
        for (int i = 0; i < count; i++) {
            System.out.print(elements[i]);
        }
    }

    /**
     * Вернуть false, если массив не переполнен, иначе вернуть true
     *
     * @param count
     * @return
     */
    public boolean fullArray(int count) {
        if (count == INITIAL_SIZE) {
            System.out.println("Превышено максимальное допустимое количество значений!");
            buff = new int[INITIAL_SIZE];
            buff = elements;
            INITIAL_SIZE++;
            elements = new int[INITIAL_SIZE];
            for (int i = 0; i < INITIAL_SIZE - 1; i++) {
                elements[i] = buff[i];
            }
            System.out.println("Размер массива увеличин на 1, повторите операцию по добавлению нового элемента");
            return false;
        } else
            return true;
    }

    public void showMenu() {
        System.out.println("Меню работы со списком:");
        System.out.println("1.Добавить элемент в конец");
        System.out.println("2.Добавить элемент в начало списка, со сдвигом вправо");
        System.out.println("3.Вставить элемент в заданную позицию со сдвигом");
        System.out.println("4.Получить элемент по индексу");
        System.out.println("5.Заменить элемент в заданной позиции новым элементом");
        System.out.println("6.Сортировка вставками");
        System.out.println("7.Реверсия массива");
        System.out.println("8.Удалить элемент по индексу");
        System.out.println("9.Вернуть индекс элемента");
        System.out.println("10.Показать массив");
        System.out.println("11.Выход в главное меню");
    }
}
