package springproject.basicspring.singleton;

// 싱글톤 패턴을 구현하는 방법은 여러가지가 있고, 이 코드에서 사용한 방법은 객체를 미리 생성해두는 가장 단순하고 안전한 방법이다.
public class SingleTonService {

    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingleTonService instance = new SingleTonService();

    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingleTonService getInstance() {
        return instance;
    }

    //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 만든다.
    private SingleTonService() {
    }

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
