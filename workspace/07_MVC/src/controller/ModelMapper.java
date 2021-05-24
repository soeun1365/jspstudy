package controller;

import model.CircleCommand;
import model.RectangleCommand;
import model.ShapeCommand;
import model.TriangleCommand;

public class ModelMapper {
	
	//한번에 하나의 모델만 반환할 수 있도록 Singleton처리
	private static ModelMapper mapper = new ModelMapper();
	private ModelMapper() {}
	public static ModelMapper getInstance() {
		if(mapper == null) {
			mapper = new ModelMapper();
		}
		return mapper;
	}
	
	// Model을 반환시켜주는 getModel()메소드
	
	public ShapeCommand getModel(String cmd) {
		ShapeCommand command = null;
		switch(cmd) {
		case "rectangle.do" :
			command = new RectangleCommand();
			break;
		case "triangle.do" :
			command = new TriangleCommand();
			break;
		case "circle.do" :
			command = new CircleCommand();
			break;
		}return command;
	}
}
