package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Hotel;

import java.util.List;

/**
 * Hotel service
 *
 * @author Danylo Lototskyi
 */
public interface IHotelService {

    /**
     * Find all instances of hotel
     *
     * @return list of instances
     */
    List<Hotel> getAll();

    /**
     * Makes given instance persistent
     *
     * @param hotel instance to be persisted
     */
    void add(Hotel hotel); // C

    /**
     * Find hotel by id
     *
     * @param id hotel id
     * @return found hotel
     */
    Hotel get(int id); // R

    /**
     * Update given hotel.
     *
     * @param hotel instance to be updated
     */
    void update(Hotel hotel); // U

    /**
     * Delete hotel by id
     *
     * @param id hotel id
     */
    void delete(int id); // D

    /**
     * Find all hotels in city
     * @param cityName city name for finding hotels
     * @return list of hotels in this city
     */
    List<Hotel> getAllHotelsByCityName(String cityName);

    /**
     * Count tourists in hotel for all time
     * @param hotelName hotel name for counting tourists
     * @return count of tourists in this hotel for all time
     */
    int countTourist(String hotelName);

    /**
     * Count average stay in hotel
     * @param hotelName hotel name for counting average stay here
     * @return number of average stay in this hotel
     */
    int averageStay(String hotelName);

    /**
     * Find all available hotels in city on chosen period
     * @param startDate start date of period
     * @param endDate end date of period
     * @param cityName city name for finding available hotels
     * @return list of available hotels in this city
     */
    List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName);

}
