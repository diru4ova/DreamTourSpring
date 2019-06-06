package com.softserve.academy.dreamtourspring.model;

import com.softserve.academy.dreamtourspring.enums.RoomType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idRoom;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "room_description")
    private String roomDescription;

    @Column(name = "price")
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id")
    private Hotel hotel;

    public Room() {
    }

    public Room(String imageUrl, String roomDescription,
                int price, RoomType roomType, Hotel hotel) {
        this.imageUrl = imageUrl;
        this.roomDescription = roomDescription;
        this.price = price;
        this.roomType = roomType;
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return idRoom == room.idRoom
            && price == room.price
            && Objects.equals(imageUrl, room.imageUrl)
            && Objects.equals(roomDescription, room.roomDescription)
            && roomType == room.roomType
            && Objects.equals(hotel, room.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom, imageUrl, roomDescription, price, roomType, hotel);
    }

    @Override
    public String toString() {
        return "Room{"
            + "idRoom=" + idRoom
            + ", imageUrl='" + imageUrl + '\''
            + ", roomDescription='" + roomDescription + '\''
            + ", price=" + price
            + ", roomType=" + roomType
            + ", hotel=" + hotel
            + '}';
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
