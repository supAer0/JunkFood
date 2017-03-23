import java.util.*;

/**
 * Заказ
 */
public class Order {


    private static List<Meal> orderList;

    public Order(){
        orderList= new ArrayList<>();
    }
    /**
     * Добавляет одно блюдо в заказ.
     *
     * todo Сначала написать тесты!
     *
     *
     * @param meal блюдо из меню
     */
    public void addMeal(Meal meal){
        // todo Блюдо должно быть из меню.
        // todo В случае, если блюдо не изменю, должно кидать IllegalArgumentException
        // todo Блюдо должно быть не null.
        // todo добавляем блюдо в заказ
        if (Menu.containsMeal(meal)){
            if (!(meal == null)) {
                orderList.add(meal);
            }
        } else throw new IllegalArgumentException();
    }


    //todo добавить возможность добавления нескольких порций  одного блюда, например, два чая.
    //todo чтобы можно было сделать, например, addMeal(teaMeal, 2)
    //todo TESTS!
    public void addMeal(Meal meal, int count){
        if (Menu.containsMeal(meal)){
            if (!(meal == null)) {
                for (int i=0;i<count;i++){
                    orderList.add(meal);}
            }
        } else throw new IllegalArgumentException();
    }


    /**
     * Возвращает сумму заказа, суммирующая цены каждого блюда,
     * умноженные на количество каждого блюда в заказе.
     *
     * @return сумму заказа в у.е., число с плавающей точкой
     */
    public Float totalSum(){
        Float sum = 0.0f;
        for(Meal e : orderList){
            sum+= e.getPrice();
        }
        return sum;
    }
}
