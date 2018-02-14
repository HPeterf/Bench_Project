package org.BenchProject.BenchProject.Service;

import java.util.Date;
import java.util.List;

import org.BenchProject.BenchProject.Model.Names;
import org.BenchProject.BenchProject.Repository.INames;
import org.BenchProject.BenchProject.Service.Exceptions.EmtyFieldException;
import org.BenchProject.BenchProject.Service.Exceptions.InsertFailedException;
import org.BenchProject.BenchProject.Service.Exceptions.NameAlreadyTakenException;
import org.BenchProject.BenchProject.Service.Exceptions.NamesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NamesServiceImpl implements NamesService {

	@Autowired
	INames namesRepo;

	private static final Logger logger = LoggerFactory.getLogger(NamesServiceImpl.class);

	@Override
	public String addNames(Names names) throws NamesException {
		if (names.getName().trim().length() == 0) {
			throw new EmtyFieldException();
		} else {
			names.setName(names.getName().trim());

			logger.info("Search in DB by name: " + names.getName());
			List<Names> NamesList = namesRepo.findAll();

			final String searchableName = names.getName();

			for (Names item : NamesList) {
				if (item.getName().equals(searchableName)) {
					throw new NameAlreadyTakenException();
				}
			}

			logger.info("No match, insert start");

			try {

				names.setDate(new Date());
				namesRepo.save(names);
				return "Save successful";

			} catch (Exception e) {
				logger.error("Insert failed: " + e.toString());
				throw new InsertFailedException();
			}
		}
	}

	@Override
	public List<Names> listAllNames() {
		List<Names> namesList = namesRepo.findAll();

		logger.info("START");
		logger.info("Names' number: " + namesList.size());

		for (int i = 0; i < namesList.size(); i++) {
			logger.info(namesList.get(i).getName());
		}
		return namesList;
	}
}
