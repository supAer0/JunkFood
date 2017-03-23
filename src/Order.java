
/**
 * Заказ
 */
public class Order {
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
        throw new UnsupportedOperationException();
    }


    //todo добавить возможность добавления нескольких порций  одного блюда, например, два чая.
    //todo чтобы можно было сделать, например, addMeal(teaMeal, 2)
    //todo TESTS!
    public void addMeal(Meal meal, Float count){
        throw new UnsupportedOperationException();
    }


    /**
     * Возвращает сумму заказа, суммирующая цены каждого блюда,
     * умноженные на количество каждого блюда в заказе.
     *
     * @return сумму заказа в у.е., число с плавающей точкой
     */
    public Float totalSum(){
        //todo
        throw new UnsupportedOperationException();
    }
}
