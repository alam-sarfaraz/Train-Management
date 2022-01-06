package com.inn.train.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inn.train.model.TrainDetail;

@RequestMapping("/rest/train/")
public interface TrainRest {

	@PostMapping("addTrainDetail")
	TrainDetail addTrainDetail(@Valid @RequestBody TrainDetail trainDetail) throws Exception;

	@PutMapping("updateTrainDetail/{id}")
	TrainDetail updateTrainDetail(@PathVariable("id") Integer id, @Valid @RequestBody TrainDetail trainDetail)
			throws Exception;

	@DeleteMapping("deleteTrainById/{id}")
	String deleteTrainById(@PathVariable("id") Integer id);

	@GetMapping("getAllTrainDetails")
	List<TrainDetail> getAllTrainDetails() throws Exception;

	@GetMapping("getTrainDetailByTrainNumber/{trainNumber}")
	Optional<TrainDetail> getTrainDetailByTrainNumber(@PathVariable("trainNumber") String trainNumber) throws Exception;

	@GetMapping("getTrainDetailByTrainName/{trainName}")
	Optional<TrainDetail> getTrainDetailByTrainName(@PathVariable("trainName") String trainName) throws Exception;

	@GetMapping("getTrainBySourceAndDestination")
	List<TrainDetail> getTrainBySourceAndDestination(@RequestParam(name = "source", required = true) String source,
			@RequestParam(name = "destination", required = true) String destination) throws Exception;

	@GetMapping("getTrainDetailByDate")
	TrainDetail getTrainDetailByDate(@RequestParam(name = "date") String date) throws Exception;

	@GetMapping("getTrainDetailByDateSrcAndDest")
	List<TrainDetail> getTrainDetailByDateSrcAndDest(@RequestParam(name = "date", required = true) String date,
			@RequestParam(name = "source", required = true) String source,
			@RequestParam(name = "destination", required = true) String destination) throws Exception;

	@GetMapping("getTrainDetailByTrainNoDateSrcAndDest")
	TrainDetail getTrainDetailByTrainNoDateSrcAndDest(
			@RequestParam(name = "trainNumber", required = true) String trainNumber,
			@RequestParam(name = "date", required = true) String date,
			@RequestParam(name = "source", required = true) String source,
			@RequestParam(name = "destination", required = true) String destination) throws Exception;

	@PutMapping("updateTrainDetailByTrainNumber/{trainNumber}")
	TrainDetail updateTrainDetailByTrainNumber(@PathVariable("trainNumber") String trainNumber,
			@RequestBody TrainDetail trainDetail) throws Exception;

}
