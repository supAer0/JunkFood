import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Меню. Список блюд
 *
 */
public class Menu {

    private List<Meal> list;
    //todo Создайте свое меню. Должен быть хотя бы один конструктор, который создает объект класса Menu, содержащий список не менее чем из 10 блюд.
    //todo Должно быть не менее 10 блюд.
    //todo Список должен быть не пуст
    //todo Это намеки на создание тестов. Сначала тесты, потом реализация!

    public Menu() {
        list = new ArrayList<>();
        list.add(new Meal("Soup",10f));
        list.add(new Meal("Salad",5f));
        list.add(new Meal("French fries",2.5f));
        list.add(new Meal("Porridge",3.45f));
        list.add(new Meal("Mashed potatoes", 8f));
        list.add(new Meal("Ice cream",3f));
        list.add(new Meal("Stake",20f));
        list.add(new Meal("Chicken",15f));
        list.add(new Meal("Rice",5f));
        list.add(new Meal("Coffee",5f));
        list.add(new Meal("Chicken Nuggets",10f));
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

    /**
     * Возвращает список блюд в меню.
     * Должен быть неизменяемым. @see Collections.unmodifiableList
     * Должен возвращать одну и ту же коллекцию объектов при кажом вызове.
     * @return список блюд в меню
     */
    public List<Meal> list(){
        return Collections.unmodifiableList(list);
    }

}