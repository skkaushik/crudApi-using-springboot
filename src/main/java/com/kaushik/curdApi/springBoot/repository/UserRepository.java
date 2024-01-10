package com.kaushik.curdApi.springBoot.repository;

import com.kaushik.curdApi.springBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
