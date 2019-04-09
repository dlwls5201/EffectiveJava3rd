package chapter02.item02;

//빙더 패턴
public class NutritionFacts3 {
    private final int servingSize;  //필수
    private final int servings;     //필수
    private final int calories;     //선택
    private final int fat;          //선택
    private final int sodium;       //선택
    private final int carbohydrate; //선택

    public static class Builder {
        //필수 매개변수
        private final int servingSize;
        private final int servings;

        //선택 매개변수
        private int calories        = 0; //선택
        private int fat             = 0; //선택
        private int sodium          = 0; //선택
        private int carbohydrate    = 0; //선택

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts3 build() {
            return new NutritionFacts3(this);
        }

    }

    private NutritionFacts3(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {

        NutritionFacts3 cocaCola = new Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
    }
}
