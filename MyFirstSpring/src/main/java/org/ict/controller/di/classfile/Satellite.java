package org.ict.controller.di.classfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Satellite {
	private Broadcate broadcate;
	
	@Autowired
	public Satellite(Broadcate broadcast, Broadcate broadcate) {
		this.broadcate = broadcate;
	}
	
	public void satelliteBroadcate() {
		System.out.print("위성방식 ");
		broadcate.broadcate();
	}
	
	
}
