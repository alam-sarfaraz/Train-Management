package com.inn.train.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inn.train.model.TrainDetail;

@Repository
public interface TrainDao extends JpaRepository<TrainDetail, Integer> {

	@Query("select td from TrainDetail td where td.trainNumber =:tn")
	public Optional<TrainDetail> getTrainDetailByTrainNumber(@Param("tn") String trainNumber);

	@Query("select td from TrainDetail td where td.trainName =:tname")
	public Optional<TrainDetail> getTrainDetailByTrainName(@Param("tname") String trainName);

	@Query("select td from TrainDetail td where td.source =:s and td.destination=:d")
	public List<TrainDetail> getTrainBySourceAndDestination(@Param("s") String source, @Param("d") String destination);

	@Query("select td from TrainDetail td where td.date =:d")
	public TrainDetail getTrainDetailByDate(@Param("d") String date);

	@Query("select td from TrainDetail td where td.date =:da and td.source =:s and td.destination=:d")
	public List<TrainDetail> getTrainDetailByDateSrcAndDest(@Param("da") String date, @Param("s") String source,
			@Param("d") String destination);

	@Query("select td from TrainDetail td where td.trainNumber =:tn and td.date =:da and td.source =:so and td.destination=:de")
	TrainDetail getTrainDetailByTrainNoDateSrcAndDest(@Param("tn") String trainNumber, @Param("da") String date, @Param("so") String source,
			@Param("de") String destination);

}
