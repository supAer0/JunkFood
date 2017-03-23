import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.Assert.*;

/**
 *
 * ТЕСТЫ!!! TestDrivenDevelopment rules!!!
 */


public class Tests {
    Order o = null;
    Menu menu = null;

    //-------------------------Ваши тесты --------------------------------

    //todo Test 1 на блюдо
    //todo Проверьте чтобы можно было создать блюдо с указанием его наименования
    //todo Указать наименование при создании можно, изменить нельзя.
    //todo Возвращаемое значение должно совпадать с тем наименованием, что было указано при создании

    //todo Test 2 на блюдо
    //todo Проверьте чтобы можно было создать блюдо с указанием его цены
    //todo Проверьте, что указать цену при создании можно, изменить нельзя.
    //todo Проверьте, что возвращаемое значение должно совпадать с тем, что было указано при создании
    @Test
    public void testNewMeal() {
        String title = "milk";
        Float price = 12.45f;
        Meal pr = new Meal(title, price);
        assertEquals(title, pr.getTitle());
        assertEquals(price, pr.getPrice());
    }
    //todo Test 3 на создание меню
    //todo Проверьте, что можно создать объект класса Menu
    //todo Проверьте, что список не пуст.
    //todo Проверьте, что список состоит не менее чем из 10 блюд.
    //todo Проверьте, что меню не изменяется: метод list() возвращает один и тот же список объектов
    @Test
    public void testMenu() {
        Menu menu = new Menu();
        assertNotNull(menu.list());
        assertTrue(menu.list().size() >= 10);
        assertEquals(menu.list(),menu.list());
    }
    //todo Test 3 на заказ
    //todo Проверьте, что в заказ можно добавить блюдо из меню
    //todo Проверьте, что добавить в заказ можно только блюдо из меню (иначе должно кидаться исключение IllegalArgumentException
    @Test(expected= IllegalArgumentException.class)
    public void testOrder1() {
        o = new Order();
        o.addMeal(new Meal("privet",12.5f));
    }
    @Test
    public void testOrder() {
        o = new Order();
        Menu menu = new Menu();
        o.addMeal(menu.list().get(0));
    }
    //todo Test 4 на цену заказа
    // todo Проверьте, что сумма пустого заказа равна 0
    // todo Проверьте, что после добавления в заказ сумма увеличилась соответственно
    // todo Проверьте, что сумма заказа считается корректно для разных тестовых наборов
    @Test
    public void testPriceOrder() {
        Order order = new Order();
        Menu menu = new Menu();
        assertEquals(new Float(0),order.totalSum());
        Float price = menu.list().get(0).getPrice();
        order.addMeal(menu.list().get(0));
        assertEquals(price,order.totalSum());
    }

    //todo Test 5 на добавление нескольких блюд одного наименования
    //todo Проверьте, что можно добавить в заказ несколько блюд одного наименования
    //todo Проверьте, что сумма заказа изменилась соответственно
    @Test
    public void testPriceOrder1() {
        Order order = new Order();
        Menu menu = new Menu();
        assertEquals(new Float(0),order.totalSum());
        Float price = menu.list().get(2).getPrice();
        int count = 5;
        Float sum = price*count;
        order.addMeal(menu.list().get(2),count);
        assertEquals(sum,order.totalSum());
    }

    @Test(expected= IllegalArgumentException.class)
    public void testMenu1() {
        List<Meal> l1 = new ArrayList<>();
        l1.add(new Meal("lol",15.0f));
        l1.add(new Meal("lol",18.0f));
        l1.add(new Meal("a",15.0f));
        l1.add(new Meal("b",19.0f));
        l1.add(new Meal("v",15.0f));
        l1.add(new Meal("d",18.0f));
        l1.add(new Meal("c",15.0f));
        l1.add(new Meal("f",18.0f));
        l1.add(new Meal("g",15.0f));
        l1.add(new Meal("y",18.0f));
        l1.add(new Meal("t",15.0f));
        l1.add(new Meal("u",18.0f));
        l1.add(new Meal("i",15.0f));
        l1.add(new Meal("re",18.0f));
        List<Meal> l2 = Collections.unmodifiableList(l1);
        Menu menu = new Menu(l2);
    }

    @Test(expected= NullPointerException.class)
    public void testMenu2() {
        List<Meal> l1 = new ArrayList<>();
        l1.add(new Meal("lol",15.0f));
        l1.add(new Meal("re",18.0f));
        l1.add(new Meal("ar",15.0f));
        l1.add(new Meal("bt",19.0f));
        l1.add(new Meal("vy",15.0f));
        l1.add(new Meal("du",18.0f));
        List<Meal> l2 = Collections.unmodifiableList(l1);
        Menu menu = new Menu(l2);
    }

}
