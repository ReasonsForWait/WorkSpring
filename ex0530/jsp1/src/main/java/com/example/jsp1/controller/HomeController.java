package com.example.jsp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Servlet을 나타내는 컨트롤러 클래스 표시
// 요청과 응답만을 받아 처리하는 개체를 가리킬 때 사용하는 어노테이션
@Controller
public class HomeController {

    // Servlet 클래스에서의 doGet, doPost 같은 역할을 하는 메서드를 지칭할 때 쓰는
    // 어노테이션, url 경로, method가 여기 들어간다.
    // - root 경로를 Get으로 호출했을 시 요청되는 메서드
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    // @Controller
    /* - 클라이언트에서 요청한 데이터를 처리하거나 사용자 쪽으로 처리한 응답을 제공할 때 사용하는 클래스 어노테이션
    *  - 이 어노테이션이 선언된 클래스는 컨트롤러 클래스로써 사용자의 요청과 응답을 처리하는 클래스로 정의하게 된다.
    *  - @Controller에는 실제 URL 경로와 사용자들이 요청과 함께 보낸 값을 처리할 수 있는 여러가지 기능을 제공하도록 메서드에 기능을 부여한다
    * */

    // @RequestMapping
    /* - 사용자의 요청 경로 및 method 설정을 할 수 있게 만들어주는 어노테이션
    *  - Servlet에서의 @WebServlet의 기능과 동일하다.
    *  - 하나 차이가 있다면 @RequestMapping은 메소드 뿐만이 아닌 클래스 에서도 사용 가능하다.
    *  - @RequestMapping에는 두가지의 값을 지정할 수 있으며 해당 element는 다음과 같다.
    *       => value : 컨텍스트 패스 외의 하위 주소 경로를 지정한다.
    *       => method : 클라이언트에서 보내는 특정 신호에만 값을 받을 수 있도록 한다.
    * */

    // @Controller method
    /* - @Controller 내에 속한 method는 return 타입을 보통 string으로 내보내며 해당 string 은 jsp 기준 prefix, suffix
         를 앞뒤로 붙여 참조하고자 하는 웹 페이지를 가리키게 된다.
       - 해당 웹 페이지를 가리켜 사용자가 후에 보고자 하는 페이지의 데이터를 보내주게 되며 이 페이지를 사용자는 pulling방식을 통해 제공받게 된다
       - 문자열은 반드시 페이지와 매핑이 되므로 페이지의 경로가 조금이라도 틀릴 경우 에러가 발생한다.
    * */

    @RequestMapping(value = "/example01", method = RequestMethod.GET)
    public String example01(){
        return "example01/index";
    }

    @RequestMapping(value = "/example02", method = RequestMethod.GET)
    public String example02(){
        return "example02/index";
    }
}
