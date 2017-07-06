package com.spring.bbsCommand;

import org.springframework.ui.Model;

public interface Bcmd {


	void service(Model model);
//		모델을 불러오는 이유 : 컨트롤러에서 cmd를 호출하기 때문에
//		cmd를 구현하는 객체가 있어야 한다
//		먼저 list라는 command객체를 만들것이다.
//		모델 전달은 컨트롤러에서 받는다
//		모델생성 방법은 파라미터 생성하는 것과
//		모델을 리턴타입으로 설정하는 방법 두가지가 있다.


}
