package controller;

import model.AverageCommand;
import model.GradeCommand;
import model.ScoreCommand;

public class ModelMapper {
	
	private static ModelMapper mapper = new ModelMapper();
	private ModelMapper() {}
	public static ModelMapper getInstance() {
		if(mapper == null) {
			mapper = new ModelMapper();
		}
		return mapper;
	}
	public ScoreCommand getModel(String cmd) {
		ScoreCommand command = null;
		switch(cmd) {
		case "average.do" :
			command = new AverageCommand();
			break;
		case " grade.do" :
			command = new GradeCommand();
			break;
		}
		return command;
	}
}