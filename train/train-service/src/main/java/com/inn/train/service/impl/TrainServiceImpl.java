package com.inn.train.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.train.constants.RegexPattern;
import com.inn.train.dao.TrainDao;
import com.inn.train.exceptions.CustomException;
import com.inn.train.model.TrainDetail;
import com.inn.train.service.TrainService;
import com.inn.train.validation.Validation;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TrainServiceImpl implements TrainService {

	@Autowired
	TrainDao trainDao;

	@Override
	public TrainDetail addTrainDetail(TrainDetail trainDetail) throws Exception {
		try {
			log.info("Inside the TrainServiceImpl of addTrainDetail :{}", trainDetail);
			Optional<TrainDetail> trainDetailByTrainNumber = trainDao
					.getTrainDetailByTrainNumber(trainDetail.getTrainNumber());
			if (!trainDetailByTrainNumber.isEmpty()) {
				throw new CustomException("Train Number already Exist enter unique train number....");
			}
			RegexPattern.trainNumberValidation(trainDetail.getTrainNumber());
			Validation.statusValidation(trainDetail);
			trainDetail.setStatus(trainDetail.getStatus().toUpperCase());
			return trainDao.save(trainDetail);
		} catch (Exception e) {
			log.error("Error occured due to :{} ", e.getMessage());
			throw e;
		}
	}

	@Override
	public TrainDetail updateTrainDetail(Integer id, @Valid TrainDetail trainDetail) throws Exception {
		try {
			log.info("Inside the TrainServiceImpl of updateTrainDetail id and trainDetail :{} {}", id, trainDetail);
			if (!id.equals(trainDetail.getId())) {
				throw new CustomException("Id of train not Matched....");
			}
			RegexPattern.trainNumberValidation(trainDetail.getTrainNumber());
			Validation.statusValidation(trainDetail);
			trainDetail.setStatus(trainDetail.getStatus().toUpperCase());
			return trainDao.save(trainDetail);
		} catch (Exception e) {
			log.error(" Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public String deleteTrainById(Integer id) {
		try {
			log.info("Inside the TrainServiceImpl of deleteTrainById :{}", id);
			trainDao.deleteById(id);
			return "Data Deleted Successfully...";
		} catch (Exception e) {
			log.error("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public List<TrainDetail> getAllTrainDetails() throws Exception {
		try {
			log.info("Inside the TrainServiceImpl of getAllTrainDetails");
			List<TrainDetail> findAll = trainDao.findAll();
			if (findAll.isEmpty())
				throw new CustomException("No Data Present in database..");
			return trainDao.findAll();
		} catch (Exception e) {
			log.error("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public Optional<TrainDetail> getTrainDetailByTrainNumber(String trainNumber) throws Exception {
		try {
			log.info("Inside the TrainServiceImpl of getTrainDetailByTrainNumber :{}", trainNumber);
			Optional<TrainDetail> detail = trainDao.getTrainDetailByTrainNumber(trainNumber);
			if (detail.isEmpty()) {
				throw new CustomException("Invalid Train Number..");
			}
			return detail;
		} catch (Exception e) {
			log.error("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public Optional<TrainDetail> getTrainDetailByTrainName(String trainName) throws Exception {
		try {
			log.info("Inside the TrainServiceImpl of getTrainDetailByTrainName :{}", trainName);
			Optional<TrainDetail> detail = trainDao.getTrainDetailByTrainName(trainName);
			if (detail.isEmpty()) {
				throw new CustomException("Invalid Train Name..");
			}
			return detail;
		} catch (Exception e) {
			log.error("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public List<TrainDetail> getTrainBySourceAndDestination(String source, String destination) throws Exception {
		try {
			log.info("Inside the TrainServiceImpl of getTrainBySourceAndDestination source and destination :{} {}",
					source, destination);
			List<TrainDetail> detail = trainDao.getTrainBySourceAndDestination(source, destination);
			if (detail.isEmpty()) {
				throw new CustomException("No train are available of this route");
			}
			return detail;
		} catch (Exception e) {
			log.error("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public TrainDetail getTrainDetailByDate(String date) throws Exception {
		try {
			log.info("Inside the TrainServiceImpl of getTrainDetailByDate:{}", date);
			TrainDetail trainDetailByDate = trainDao.getTrainDetailByDate(date);
			if (trainDetailByDate == null) {
				throw new CustomException("No train are available of this date");
			}
			return trainDetailByDate;
		} catch (Exception e) {
			log.error("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public List<TrainDetail> getTrainDetailByDateSrcAndDest(String date, String source, String destination)
			throws Exception {
		try {
			log.info(
					"Inside the TrainServiceImpl of getTrainDetailByDateSrcAndDest date source and destination :{} {} {}",
					date, source, destination);
			List<TrainDetail> detail = trainDao.getTrainDetailByDateSrcAndDest(date, source, destination);
			if (detail.isEmpty()) {
				throw new CustomException("No train are available of this Date");
			}
			return detail;
		} catch (Exception e) {
			log.error("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public TrainDetail getTrainDetailByTrainNoDateSrcAndDest(String trainNumber, String date, String source,
			String destination) throws Exception {
		try {
			log.info(
					"Inside the TrainServiceImpl of getTrainDetailByTrainNoDateSrcAndDest trainNo date source and destination : {} {} {} {}",
					trainNumber,date, source, destination);
			TrainDetail detail = trainDao.getTrainDetailByTrainNoDateSrcAndDest(trainNumber, date, source, destination);
			if (detail==null) {
				throw new CustomException("No train are available of this Date");
			}
			return detail;
		} catch (Exception e) {
			log.error("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public TrainDetail updateTrainDetailByTrainNumber(String trainNumber, TrainDetail trainDetail) throws Exception {
		try {
			log.info("Inside the TrainServiceImpl of updateTrainDetailByTrainNumber trainDetail:{}", trainDetail);
			Optional<TrainDetail> data = trainDao.getTrainDetailByTrainNumber(trainNumber);
			if (data.isEmpty()) {
				throw new CustomException("Invalid Train Number");
			}
			if (trainDetail.getArrivalTime() == null)
				trainDetail.setArrivalTime(data.get().getArrivalTime());
			if (trainDetail.getDate() == null)
				trainDetail.setDate(data.get().getDate());
			if (trainDetail.getDepartureTime() == null)
				trainDetail.setDepartureTime(data.get().getDepartureTime());
			if (trainDetail.getDestination() == null)
				trainDetail.setDestination(data.get().getDestination());
			if (trainDetail.getId() == null)
				trainDetail.setId(data.get().getId());
			if (trainDetail.getSource() == null)
				trainDetail.setSource(data.get().getSource());
			if (trainDetail.getStatus() == null)
				trainDetail.setStatus(data.get().getStatus());
			Validation.statusValidation(trainDetail);
			trainDetail.setStatus(trainDetail.getStatus().toUpperCase());
			if (trainDetail.getTotalFair() == null)
				trainDetail.setTotalFair(data.get().getTotalFair());
			if (trainDetail.getTotalSeat() == null)
				trainDetail.setTotalSeat(data.get().getTotalSeat());
			if (trainDetail.getTrainName() == null)
				trainDetail.setTrainName(data.get().getTrainName());
			if (trainDetail.getTrainNumber() == null)
				trainDetail.setTrainNumber(data.get().getTrainNumber());
			RegexPattern.trainNumberValidation(trainDetail.getTrainNumber());
			return trainDao.save(trainDetail);
		} catch (Exception e) {
			log.error("Error occured due to :{}", e.getMessage());
			throw e;
		}
	}

}
