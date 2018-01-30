package com.kriszu.repository;

import com.kriszu.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kriszu on 30.01.2018.
 */
@Repository
public interface NewsRepository extends JpaRepository<News,Long> {
}
