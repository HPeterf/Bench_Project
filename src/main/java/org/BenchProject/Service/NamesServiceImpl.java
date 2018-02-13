package org.BenchProject.Service;

import java.util.List;

import org.BenchProject.Model.Names;
import org.BenchProject.Repository.INames;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NamesServiceImpl implements NamesService {

	private INames namesRepo;

	public void setINames(INames namesRepo) {
		this.namesRepo = namesRepo;
	}

	@Override
	@Transactional
	public void addNames(Names names) {
		this.namesRepo.addNames(names);

	}

	@Override
	public List<Names> listAllNames() {
		return this.namesRepo.listAllNames();
	}

	// @Autowired
	// public void setNamesRepo(INames namesRepo) {
	// this.namesRepo = namesRepo;
	// }
	//
	// @Override
	// public Iterable<Names> listAllNames() {
	// return namesRepo.findAll();
	// }
	//
	// @Override
	// public Names addNames(Names names) {
	// return namesRepo.save(names);
	// }

}
