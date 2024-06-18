package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	public abstract Optional<Room> findByRoomId(Integer roomId);

	@Query(value = "SELECT room_no FROM room", nativeQuery = true)
	public abstract List<Integer> findRoom();
}
