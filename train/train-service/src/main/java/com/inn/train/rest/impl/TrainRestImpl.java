package com.inn.train.rest.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.inn.train.model.TrainDetail;
import com.inn.train.rest.TrainRest;
import com.inn.train.service.TrainService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TrainRestImpl implements TrainRest {

	@Autowired
	TrainService trainService;

	@Override
	public TrainDetail addTrainDetail(@Valid TrainDetail trainDetail) throws Exception {
		try {
			log.info("Inside TrainRestImpl of addTrainDetail :{}", trainDetail);
			return trainService.addTrainDetail(trainDetail);
		} catch (Exception e) {
			log.info("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public TrainDetail updateTrainDetail(Integer id, @Valid TrainDetail trainDetail) throws Exception {
		try {
			log.info("Inside TrainRestImpl of updateTrainDetail id and trainDetail :{} {}", id, trainDetail);
			return trainService.updateTrainDetail(id, trainDetail);
		} catch (Exception e) {
			log.info("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public String deleteTrainById(Integer id) {
		try {
			log.info("Inside TrainRestImpl of deleteTrainById :{}", id);
			return trainService.deleteTrainById(id);
		} catch (Exception e) {
			log.info("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public List<TrainDetail> getAllTrainDetails() throws Exception {
		try {
			log.info("Inside TrainRestImpl of getAllTrainDetails :{}");
			return trainService.getAllTrainDetails();
		} catch (Exception e) {
			log.info("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public Optional<TrainDetail> getTrainDetailByTrainNumber(String trainNumber) throws Exception {
		try {
			log.info("Inside TrainRestImpl of getTrainDetailByTrainNumber :{}", trainNumber);
			return trainService.getTrainDetailByTrainNumber(trainNumber);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Optional<TrainDetail> getTrainDetailByTrainName(String trainName) throws Exception {
		try {
			log.info("Inside TrainRestImpl of getTrainDetailByTrainName :{}", trainName);
			return trainService.getTrainDetailByTrainName(trainName);
		} catch (Exception e) {
			log.info("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public List<TrainDetail> getTrainBySourceAndDestination(String source, String destination) throws Exception {
		try {
			log.info("Inside TrainRestImpl of getTrainBySourceAndDestination source and destination :{} {}", source,
					destination);
			return trainService.getTrainBySourceAndDestination(source, destination);
		} catch (Exception e) {
			log.info("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public TrainDetail getTrainDetailByDate(String date) throws Exception {
		try {
			log.info("Inside TrainRestImpl of getTrainDetailByDate date :{}", date);
			return trainService.getTrainDetailByDate(date);
		} catch (Exception e) {
			log.info("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public List<TrainDetail> getTrainDetailByDateSrcAndDest(String date, String source, String destination)
			throws Exception {
		try {
			log.info("Inside TrainRestImpl of getTrainDetailByDateSrcAndDest date source and destination :{} {} {}",
					date, source, destination);
			return trainService.getTrainDetailByDateSrcAndDest(date, source, destination);
		} catch (Exception e) {
			log.info("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public TrainDetail getTrainDetailByTrainNoDateSrcAndDest(String trainNumber, String date, String source,
			String destination) throws Exception {
		try {
			log.info(
					"Inside TrainRestImpl of getTrainDetailByTrainNoDateSrcAndDest trainNo date source and destination :{} {} {} {}",
					trainNumber, date, source, destination);
			return trainService.getTrainDetailByTrainNoDateSrcAndDest(trainNumber, date, source, destination);
		} catch (Exception e) {
			log.info("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public TrainDetail updateTrainDetailByTrainNumber(String trainNumber, TrainDetail trainDetail) throws Exception {
		try {
			log.info("Inside TrainRestImpl of updateTrainDetailByTrainNumber TrainDetail :{}", trainDetail);
			return trainService.updateTrainDetailByTrainNumber(trainNumber, trainDetail);
		} catch (Exception e) {
			log.info("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

}
