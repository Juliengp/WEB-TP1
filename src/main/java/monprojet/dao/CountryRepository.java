package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = " SELECT SUM(City.population) as populations "
            + " FROM City "
            + " INNER JOIN Country ON City.country_id = Country.id "
            + " WHERE Country.ID = :idPays ",
            nativeQuery = true)
    public int populationPays(int idPays);

    @Query(value = " SELECT Country.name as nom, SUM(City.population) as populations "
                + " FROM City "
                + " INNER JOIN Country ON City.country_id = Country.id "
                + " GROUP BY nom ",
                nativeQuery = true)
    public List<PaysEtPop> ListePaysPop();


}