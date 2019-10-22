# 57 : 지역변수의 범위를 최소화하라

1. 가장 처음 쓰일 때 선언하기

- 거의 모든 지역변수는 선언과 동시에 초기화해야한다.
- 반볻 변수의 값을 반복문이 종료된 뒤에도 써야 하는 상황이 아니라면 while 문보다는 for 문을 쓰는 편이 낫다.

**컬렉션이나 배열을 순회하는 권장 관용구**
```java
for (Element e : c) {
    ... // e로 무언가를 한다.
}
```

**반복자가 필요할 때의 관용구**
```java
for (Iterator<Element> i = c.iterator(); i.hasNext()) {
    Element e = i.next();
    ... // e와 i로 무언가를 한다.
}
```

**지역변수를 최소화하는 또 다른 반복문 관용구**
```java
for (int i = 0, n - expensiveComputation(); i < n; i++) {
    ... // i로 무언가를 한다.
}
```