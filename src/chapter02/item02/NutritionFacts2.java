package chapter02.item02;

//자바빈즈 패턴
public class NutritionFacts2 {
    private int servingSize     = -1;  //필수
    private int servings        = -1;  //필수
    private int calories        = 0; //선택
    private int fat             = 0; //선택
    private int sodium          = 0; //선택
    private int carbohydrate    = 0; //선택

    public NutritionFacts2() {}

    //새터 메서드들
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }
    public void setServings(int servings) {
        this.servings = servings;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public void setFat(int fat) {
        this.fat = fat;
    }
    public void setSodium(int sodium) {
        this.sodium = sodium;
    }
    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {

        NutritionFacts2 cocaCola = new NutritionFacts2();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setFat(10);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}
