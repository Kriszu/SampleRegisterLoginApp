package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, Long> {


}
