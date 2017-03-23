import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Меню. Список блюд
 *
 */
public class Menu {
    private static List<Meal> list;


    public Menu(){
        list=list();
    }
    public Menu(List<Meal> list1){
        List<Meal> l1 = new ArrayList<>();
        if (list1.size() >= 10) {
            for (int i = 0; i < list1.size();i++){
                if (!l1.contains(list1.get(i))){
                    l1.add(list1.get(i));
                } else throw new IllegalArgumentException();
            }
            list=l1;
        } else throw new NullPointerException();
    }
    //todo Создайте свое меню. Должен быть хотя бы один конструктор, который создает объект класса Menu, содержащий список не менее чем из 10 блюд.
    //todo Должно быть не менее 10 блюд.
    //todo Список должен быть не пуст
    //todo Это намеки на создание тестов. Сначала тесты, потом реализация!

    /**
     * Возвращает список блюд в меню.
     * Должен быть неизменяемым. @see Collections.unmodifiableList
     * Должен возвращать одну и ту же коллекцию объектов при кажом вызове.
     * @return список блюд в меню
     */
    public List<Meal> list(){
        List<Meal> list = new ArrayList<>();
        list.add(new Meal("Salmon with grilled vegetables", 140.5f));
        list.add(new Meal("Salmon in caviar sauce", 140f));
        list.add(new Meal("Grilles zander", 95f));
        list.add(new Meal("Kiev chicken", 55f));
        list.add(new Meal("Meat in a pot", 70f));
        list.add(new Meal("Mashed potatoes", 20f));
        list.add(new Meal("French fries", 30f));
        list.add(new Meal("Kompot", 20f));
        list.add(new Meal("Ice cream", 15f));
        list.add(new Meal("Broccoli in a cream", 45f));
        list.add(new Meal("Meat cutlets", 75f));
        return Collections.unmodifiableList(list);
    }

    public static boolean containsMeal(Meal meal){
        return list.contains(meal);
    }

}
