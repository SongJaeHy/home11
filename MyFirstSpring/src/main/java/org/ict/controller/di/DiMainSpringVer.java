package org.ict.controller.di;

import org.ict.controller.di.classfile.Broadcate;
import org.ict.controller.di.classfile.Satellite;
import org.ict.controller.di.classfile.Singer;
import org.springframework.context.support.GenericXmlApplicationContext;

import javafx.stage.Stage;

public class DiMainSpringVer {
	public static void main(String[] args) {
		// 빈 컨테이너에 호출해 완성품 객체를 받아와 실행하는 코드를 작성해보겠습니다.
				// 호출시 사용하는 연락용 객체는 GenericXmlApplicationContext 입니다.
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext(
						"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		// 웹이 root-context.xml이라는 bean-container와 연락을 하겠다고 지정을 했으니
		// 이제 그 공장에 있는 객체를 마음대로 꺼내 쓸 수 있습니다.
		// 얻어오는 방법은 위에 생성한 context 객체를 이용해
		// context.getBean("bean이름", 자료형.class);입니다.
	/*	Singer singer = context.getBean("singer", Singer.class);
		singer.sing();
		
		// 호출이 끝나면 context를 닫아줘야 합니다.
		context.close();*/
		
		
	/*	Broadcate broadcate = context.getBean("broadcate", Broadcate.class);
		broadcate.broadcate();
		
		context.close();*/
		
		Satellite satellite = context.getBean("satellite", Satellite.class);
		satellite.satelliteBroadcate();
		
		context.close();
		
		
	}
}
