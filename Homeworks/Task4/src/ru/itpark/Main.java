package ru.itpark;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)
    {
        // инзачально это массив null
        ArrayList lists[] = new ArrayList[5];
        // МЕНЮ
        // 1. Создать список (0..4) - создаете нужный список
        // 2. Показть все списки (показываются только ненулевые)
        // 3. Работа со списком - попросить ввести номер спика
        //       1. Добавить
        //       2. Удалить
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu ();
           int command = scanner.nextInt();
           switch (command) {
                case 1:
                    System.out.println("Введите номер создаваемого списка: [0..4]");
                    int listNumber = scanner.nextInt();
                    if(listNumber>=0 && listNumber<=4)
                    {
                        lists[listNumber] = new ArrayList();
                    }
                    else
                    {
                        System.out.println("Введите число в диапазоне от 0 до 4");
                    }
                    break;
               case 2:
                   for (int i=0;i<lists.length;i++)
                   {
                       if(lists[i]!=null)
                       {
                           System.out.println("Список :" + i);
                       }
                   }
                   break;
               case 3:
                   System.out.println("Работа со списком - введите номер спика");
                   listNumber = scanner.nextInt();
                   if(lists[listNumber]!=null)
                   {
                       boolean submenu=true;
                       while (submenu)
                       {
                           lists[listNumber].showMenu();
                           command = scanner.nextInt();
                           switch (command)
                           {
                               case 1://Добавить элемент в конец
                                   System.out.println("Введите число:");
                                   lists[listNumber].add(scanner.nextInt());
                                   break;
                               case 2://Добавить элемент в начало списка, со сдвигом вправо
                                   System.out.println("Введите число:");
                                   lists[listNumber].addToBegin(scanner.nextInt());
                                   break;
                               case 3://Вставить элемент в заданную позицию со сдвигом
                                   int element, index;
                                   System.out.println("Введите индекс:");
                                   index =scanner.nextInt();
                                   System.out.println("Введите значение:");
                                   element =scanner.nextInt();
                                   lists[listNumber].insert(element, index);
                                   break;
                               case 4://Получить элемент по индексу
                                   System.out.println("Введите индекс:");
                                   System.out.println(lists[listNumber].get(scanner.nextInt()));
                                   break;
                               case 5://Заменить элемент в заданной позиции новым элементом
                                   System.out.println("Введите индекс:");
                                   index =scanner.nextInt();
                                   System.out.println("Введите значение:");
                                   element =scanner.nextInt();
                                   lists[listNumber].replace(element, index);
                                   break;
                               case 6://Сортировка вставками
                                   lists[listNumber].sort(0);
                                   break;
                               case 7://Реверсия массива
                                   lists[listNumber].reverse();
                                   break;
                               case 8://Удалить элемент по индексу
                                   System.out.println("Введите индекс:");
                                   lists[listNumber].remove(scanner.nextInt());
                                   break;
                               case 9://Вернуть индекс элемента
                                   System.out.println("Введите число:");
                                   System.out.println(lists[listNumber].find(scanner.nextInt()));
                                   break;
                               case 10://Показать массив
                                   lists[listNumber].сoutArray();
                                   break;
                               case 11://Выход в главное меню
                                   submenu = false;
                                   break;
                                   default:
                                       System.out.println("Команда не определена");
                                       break;
                           }
                       }

                   }
                   else
                   {
                       System.out.println("Выбранный вами список не создан!");
                   }
                   break;
               case 4:
                   System.exit(0);
                   break;
                   default:
                       System.out.println("Команда не определена!");
                       break;
            }
      }
    }
    public static void showMenu ()
    {
        System.out.println("Меню:");
        System.out.println("1.Создать список (0..4)");
        System.out.println("2.Показть все списки");
        System.out.println("3.Работа со списком");
        System.out.println("4.Выход");
    }
}
