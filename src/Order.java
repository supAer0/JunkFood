import java.util.HashMap;
import java.util.Map;

/**
 * Заказ
 */
public class Order {

    private Map<Meal, Integer> mc = new HashMap<>();

    /**
     * Добавляет одно блюдо в заказ.
     *
     * todo Сначала написать тесты!
     *
     *
     * @param meal блюдо из меню
     */
    public void addMeal(Meal meal){
        addMeal(meal, 1);
    }

    public void addMeal(Meal meal, int count){
        if (!(new Menu()).list().contains(meal)) {
            throw new IllegalArgumentException("Блюдо не из меню");
        }

        int n = mc.containsKey(meal) ? mc.get(meal) : 0;
        mc.put(meal, count + n);
    }

    //todo добавить возможность добавления нескольких порций  одного блюда, например, два чая.
    //todo чтобы можно было сделать, например, addMeal(teaMeal, 2)
    //todo TESTS!


    /**
     * Возвращает сумму заказа, суммирующая цены каждого блюда,
     * умноженные на количество каждого блюда в заказе.
     *
     * @return сумму заказа в у.е., число с плавающей точкой
     */
    public Float totalSum(){
        Float sum = 0.0f;
        for(Meal meal : mc.keySet()){
            sum += meal.getPrice() * mc.get(meal);
        }
        return sum;
    }
}