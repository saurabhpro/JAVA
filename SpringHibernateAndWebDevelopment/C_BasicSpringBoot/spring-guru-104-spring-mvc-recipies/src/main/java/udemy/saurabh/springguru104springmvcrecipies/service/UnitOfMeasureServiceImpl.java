package udemy.saurabh.springguru104springmvcrecipies.service;

import org.springframework.stereotype.Service;
import udemy.saurabh.springguru104springmvcrecipies.model.commands.UnitOfMeasureCommand;
import udemy.saurabh.springguru104springmvcrecipies.model.converters.UnitOfMeasureToUnitOfMeasureCommand;
import udemy.saurabh.springguru104springmvcrecipies.repositories.IUnitOfMeasureRepository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements IUnitOfMeasureService {

	private final IUnitOfMeasureRepository unitOfMeasureRepository;
	private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

	public UnitOfMeasureServiceImpl(IUnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
	}

	@Override
	public Set<UnitOfMeasureCommand> listAllUnitOfMeasures() {

		return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(), false)
				.map(unitOfMeasureToUnitOfMeasureCommand::convert)
				.collect(Collectors.toSet());
	}
}
