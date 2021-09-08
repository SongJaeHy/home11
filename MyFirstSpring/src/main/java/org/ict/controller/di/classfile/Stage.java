package org.ict.controller.di.classfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Stage {
	
	// Singer 위에 @Autowired를 붙이면, 컨테이너 내부에
	// 일치하는 자료형이 존재하면 자동으로 의존관계를 만들어줍니다.
	@Autowired
	private Singer singer;
	
	// @Autowired를 이용한 주입은 생성자에도 적용할 수 있습니다.
	public Stage(Singer singer) {
		this.singer = singer;
	}
	
	public void perform() {
		System.out.print("무대에서 ");
		singer.sing();
	}
}
