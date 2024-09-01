package springproject.basicspring.singleton;

public class StatefulService {

    // statefulService
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    // 무상태로 코드 짜는 법

//    public int order(String name, int price) {
//        System.out.println("name = " + name + ", price = " + price);
//        return price;
//
//    }



}
