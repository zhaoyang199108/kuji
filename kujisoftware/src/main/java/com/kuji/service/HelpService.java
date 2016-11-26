package com.kuji.service;

import java.util.List;

import com.kuji.entity.Help;

public interface HelpService {
	Help findHelpByExerciseId(Long exerciseId);
	int insertIntoHelp(Help help);
	List<Help> findAll();
	Help findHelpById(Long id);
	int deleteHelpById(Long id);
	int updateHelp(Help help);
}
