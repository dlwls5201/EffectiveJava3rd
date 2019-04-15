# 생성자 매개변수가 많다면 빌더를 고려하라

## 점층적 생성자 패턴
***안정적이나 확장하기 어렵다.***
```java
NutritionFacts1 cocaCola =
                new NutritionFacts1(240, 8, 100, 10, 35, 27);
```
점층적 생성자 패턴도 쓸 수 있지만, 매개변수 개수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다.

## 자바빈즈패턴
***일관성이 깨지고, 불변으로 만들 수 없다***
```java
NutritionFacts2 cocaCola = new NutritionFacts2();
       cocaCola.setServingSize(240);
       cocaCola.setServings(8);
       cocaCola.setCalories(100);
       cocaCola.setFat(10);
       cocaCola.setSodium(35);
       cocaCola.setCarbohydrate(27);
```

자바빈즈패턴에서는 객체 하나를 만들려면 메서드를 여러 개 호출해야 하고, 객체가 완전히 생성되기 전까지는 일관성이 무너진 상태에 놓이게 된다.
일관성이 무너지는 문제 때문에 자바빈즈 패턴에서는 클래스를 불변으로 만들 수 없으며 스레드 안전성을 얻으려면 프로그래머가 추가 작업을 해줘야 한다.

## 빌더패턴
***점층적 생성자와 자바빈즈 패턴의 장점만을 취했다***
```java
NutritionFacts3 cocaCola = new Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
```
점층적 생성자 패턴의 안전성과 자바빈즈 패턴의 가독성을 겸비한 빌더 패턴.
빌더는 생성할 클래스 안에 정적 멤버 클래스로 만들어주는게 보통이다.

## 핵심정리

1. 생성자나 정적 팩터리가 처리해야 할 매개변수가 많다면(4개 이상) 빌더 패턴을 선택하는게 더 낫다.
2. 매개변수 중 다수가 필수가 아니거나 같은 타입이면 특히 더 선택하는게 좋다.
3. 빌더는 점층적 생성자보다 클라이언트 코드를 읽고 쓰기가 훨씬 간결하고, 자바빈즈보다 훨씬 안전하다.