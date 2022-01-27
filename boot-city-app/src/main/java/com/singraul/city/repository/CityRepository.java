package com.singraul.city.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.singraul.city.entity.City;

/*public interface CityRepository extends JpaRepository<City, Long> {

	@Query("select c from City c where c.name like %?1")
	List<City> findByNameEndsWith(String name);

}
*/
@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    @Query("select c from City c where c.name like %?1")
    List<City> findByNameEndsWith(String chars);
}