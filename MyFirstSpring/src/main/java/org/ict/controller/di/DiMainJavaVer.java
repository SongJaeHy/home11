package org.ict.controller.di;

import org.ict.controller.di.classfile.Broadcate;
import org.ict.controller.di.classfile.Singer;
import org.ict.controller.di.classfile.Stage;

public class DiMainJavaVer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singer singer = new Singer();
		singer.sing();
		
		Stage stage = new Stage(singer);
		stage.perform();
		
		Broadcate broadcate = new Broadcate(stage);
		broadcate.broadcate();
	}

}
