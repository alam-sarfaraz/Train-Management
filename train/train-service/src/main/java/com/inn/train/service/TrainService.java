package com.inn.train.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.inn.train.model.TrainDetail;

public interface TrainService {

	public TrainDetail addTrainDetail(TrainDetail trainDetail) throws Exception;

	public TrainDetail updateTrainDetail(Integer id, @Valid TrainDetail trainDetail) throws Exception;

	public String deleteTrainById(Integer id);

	public List<TrainDetail> getAllTrainDetails() throws Exception;

	public Optional<TrainDetail> getTrainDetailByTrainNumber(String trainNumber) throws Exception;

	public Optional<TrainDetail> getTrainDetailByTrainName(String trainName) throws Exception;

	public List<TrainDetail> getTrainBySourceAndDestination(String source, String destination) throws Exception;

	public TrainDetail getTrainDetailByDate(String date) throws Exception;

	public List<TrainDetail> getTrainDetailByDateSrcAndDest(String date, String source, String destination)
			throws Exception;

	public TrainDetail getTrainDetailByTrainNoDateSrcAndDest(String trainNumber, String date, String source,
			String destination) throws Exception;

	public TrainDetail updateTrainDetailByTrainNumber(String trainNumber, TrainDetail trainDetail) throws Exception;

}
