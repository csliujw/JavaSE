package tij.chapter22;

/**
 * enum 来表示不同类别的食物，同时还
 * 希望每个 enum 元素仍然保持 Food 类型
 */
public interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;

        enum D {
            a, ab
        }
    }

    enum Fruit implements Food {
        APPLE, BANANA, ORANGE
    }

    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        System.out.println(food);
        food = Fruit.APPLE;
        System.out.println(food);
    }
}
