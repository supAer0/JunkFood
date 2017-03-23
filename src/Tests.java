import org.junit.Before;
import org.junit.Test;

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

    /**
     * Этот метод подготовительный. Он всегда вызывается перед запуском любого теста или пачки тестов.
     * В нем удобно подготавливать (prepare) объекты, которые будут подвергаться множеству тестов. Например, подключить тестовую базу данных.
     *
     * В нашем случае показан пример создания заказа, состоящего из первого блюда списка блюд нашего меню.
     */
    @Before
    public void preparation() {
        o = new Order();
        Menu menu = new Menu();
        List<Meal> menuList = new Menu().list();
        if (!menuList.isEmpty()) {
            o.addMeal(menuList.get(0));
        }
    }

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
        assertNotNull(menu.list());
        assertTrue(menu.list().size() >= 10);
        assertEquals(menu.list(),menu.list());
    }
    //todo Test 3 на заказ
    //todo Проверьте, что в заказ можно добавить блюдо из меню
    //todo Проверьте, что добавить в заказ можно только блюдо из меню (иначе должно кидаться исключение IllegalArgumentException
    @Test(expected= IllegalArgumentException.class)
    public void testOrder1() {
        o.addMeal(new Meal("privet",12.5f));
    }
    @Test
    public void testOrder() {
        o.addMeal(menu.list().get(0));
    }
    //todo Test 4 на цену заказа
    // todo Проверьте, что сумма пустого заказа равна 0
    // todo Проверьте, что после добавления в заказ сумма увеличилась соответственно
    // todo Проверьте, что сумма заказа считается корректно для разных тестовых наборов
    @Test
    public void testPriceOrder() {
        Order order = new Order();
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
        assertEquals(new Float(0),order.totalSum());
        Float price = 15.5f;
        Meal meal = new Meal("kok",price);
        Float count = 1.5f;
        Float sum = price*count;
        order.addMeal(meal,count);
        assertEquals(sum,order.totalSum());
    }

}
