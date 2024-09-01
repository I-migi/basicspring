package springproject.basicspring.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springproject.basicspring.AppConfig;
import springproject.basicspring.member.MemberService;
import springproject.basicspring.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleTonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1: " + memberService1);
        System.out.println("memberService2: " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingleTonService singleTonService1 = SingleTonService.getInstance();
        SingleTonService singleTonService2 = SingleTonService.getInstance();

        System.out.println("singleTonService1: " + singleTonService1);
        System.out.println("singleTonService2: " + singleTonService2);

        assertThat(singleTonService1).isSameAs(singleTonService2);
    }

    // 싱글톤으로 객체들을 관리하기 위해 모든 객체에 getInstance()를 추가해 싱글톤 패턴으로 만들 필요는 없다!
    // 스프링 컨테이너가 기본적으로 객체들을 싱글톤으로 만들어 관리해준다.

    // 싱글톤 패턴의 문제점
    // 1. SingletonService를 구현한 것과 같이 싱글톤 패턴을 구현하려 할 때 구현코드가 추가된다.
    // 2. 클라이언트가 구체 클래스에 의존해야 한다. -> DIP를 위반한다
    // 3. 클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높다
    // 4. 테스트하기 어렵다.
    // 5. 내부 속성을 변경하거나 초기화 하기 어렵다
    // 6. private 생성자로 자식 클래스를 만들기 어렵다
    // 7. 결론적으로 유연성이 떨어진다.
    // 8. 안티패턴으로 불리기도 한다.

    // -> 스프링 프레임워크는 위의 싱글톤 패턴의 문제점들을 해결하면서 객체들을 싱글톤으로 관리해준다.!

    // 스프링 컨테이너는 싱글톤 패턴의 문제점을 해결하면서, 객체 인스턴스를 싱글톤(1개만 생성)으로 관리한다 스프링 빈이 바로 싱글톤으로 관리되는 빈

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 같은 것을 확인
        System.out.println("memberService1: " + memberService1);
        System.out.println("memberService2: " + memberService2);

        // memberService1 == memberService2
        assertThat(memberService1).isSameAs(memberService2);
    }



    // 스프링의 기본 빈 등록 방식은 싱글톤이지만, 요청할 때 마다 새로운 객체를 생성해서 반환하는 기능도 제공한다(빈 스코프)
}


