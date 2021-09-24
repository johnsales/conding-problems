package edu.weatherAPI.repository;

import edu.weatherAPI.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    @Query("select w from Weather w where (:city is null or lower(w.city) like lower(concat('%',:city,'%'))) and (:date is null or w.date = :date)")
    List<Weather> findByCityIgnoreCaseAndDate(@Param("city") String city, @Param("date") Date date);
}
