package com.example.Socialplatform.repository;

import com.example.Socialplatform.Enums.FriendRequestStatus;
import com.example.Socialplatform.model.FriendRequest;
import com.example.Socialplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRequestRepository extends JpaRepository<FriendRequest,Long> {
    List<FriendRequest> findByReceiverAndStatus(User receiver, FriendRequestStatus status);
    boolean existsBySenderAndReceiverAndStatus(User sender,User receiver, FriendRequestStatus status);
}
