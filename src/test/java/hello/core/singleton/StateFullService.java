package hello.core.singleton;

public class StateFullService {
    private int price; // 상태를 유지하는 필드 (상태를 유지하면 안됨)

    public void order(String name, int price) {
        System.out.println("order name = " + name + " price = " + price);

        this.price = price; // 여기가 문제! (여기가 공유되는 필드임)
    }

    public int getPrice() {
        return price;
    }
}
