package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	public abstract List<Room> findByRoomNo(Integer roomNo);

	@Query(value = "SELECT room_no FROM room", nativeQuery = true)
	public abstract List<Integer> findRoom();
	
	@Query(value = "SELECT price FROM room WHERE room_no = ?", nativeQuery = true)
	public abstract Integer findPrice(Integer roomPrice);
}
