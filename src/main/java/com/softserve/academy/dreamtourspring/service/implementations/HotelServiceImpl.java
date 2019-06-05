package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IHotelDao;
import com.softserve.academy.dreamtourspring.model.Booking;
import com.softserve.academy.dreamtourspring.model.Hotel;
import com.softserve.academy.dreamtourspring.service.interfaces.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Hotel service implementation
 *
 * @author Danylo Lototskyi
 */
@Service
@Transactional
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private IHotelDao hotelDao;

    /**
     * Find all instances of hotel
     *
     * @return list of instances
     */
    @Override
    public List<Hotel> getAll() {
        return hotelDao.getAll();
    }

    /**
     * Makes given instance persistent
     *
     * @param hotel instance to be persisted
     */
    @Override
    public void add(Hotel hotel) {
        hotelDao.add(hotel);
    }

    /**
     * Find hotel by id
     *
     * @param id hotel id
     * @return found hotel
     */
    @Override
    public Hotel get(int id) {
        return hotelDao.get(id);
    }

    /**
     * Update given hotel.
     *
     * @param hotel instance to be updated
     */
    @Override
    public void update(Hotel hotel) {
        hotelDao.update(hotel);
    }

    /**
     * Delete hotel by id
     *
     * @param id hotel id
     */
    @Override
    public void delete(int id) {
        hotelDao.delete(id);
    }

    /**
     * Find all hotels in city
     * @param cityName city name for finding hotels
     * @return list of hotels in this city
     */
    @Override
    public List<Hotel> getAllHotelsByCityName(String cityName) {
        return hotelDao.getAllHotelsByCityName(cityName);
    }

    /**
     * Count tourists in hotel for all time
     * @param hotelName hotel name for counting tourists
     * @return count of tourists in this hotel for all time
     */
    @Override
    public int countTourist(String hotelName) {
        return hotelDao.countTourist(hotelName);
    }

    /**
     * Count average stay in hotel
     * @param hotelName hotel name for counting average stay here
     * @return number of average stay in this hotel
     */
    @Override
    public int averageStay(String hotelName) {

        List<Booking> bookingList = hotelDao.averageStay(hotelName);
        int numberOfDays = 0;
        int numberOfBooks = bookingList.size();

        for (Booking booking : bookingList) {
            numberOfDays += DAYS.between(booking.getStartDate(), booking.getEndDate());
        }

        if(numberOfBooks == 0){
            return 0;
        }
        
        return numberOfDays/numberOfBooks;

    }

    /**
     * Find all available hotels in city on chosen period
     * @param startDate start date of period
     * @param endDate end date of period
     * @param cityName city name for finding available hotels
     * @return list of available hotels in this city
     */
    @Override
    public List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName) {
        return hotelDao.getAllAvailableHotelsInCity(startDate, endDate, cityName);
    }

}
