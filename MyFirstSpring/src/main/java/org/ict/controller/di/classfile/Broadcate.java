package org.ict.controller.di.classfile;

import org.springframework.stereotype.Component;

@Component
public class Broadcate {
	
	private Stage stage;
	
	public Broadcate(Stage stage) {
		this.stage = stage;
	}
	
	public void broadcate() {
		System.out.print("방송 송출용 ");
		stage.perform();
	}
}
