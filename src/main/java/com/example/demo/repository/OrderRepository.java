package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Query(value = "SELECT * FROM orders WHERE deletion_flag = 0", nativeQuery = true)
	public abstract List<Order> findByAccountId(Integer accountId);
	public abstract Optional<Order> findByOrdersId(Integer oredersId);
	//public abstract List<Order> findByRoomNo(Integer RoomId);
	@Query(value = "SELECT * FROM orders WHERE deletion_flag = 0 AND room_no = ?", nativeQuery = true)
	public abstract List<Order> findOrders(Integer roomNo);
//	@Query(value = "UPDATE orders SET deletion_flag = 1 WHERE orders_id = ?", nativeQuery = true)
//	public abstract void deleteByOrdersId(Integer ordersId);
}
