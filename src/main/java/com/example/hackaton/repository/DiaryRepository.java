package com.example.hackaton.repository;

import com.example.hackaton.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    // 여기에 필요한 커스텀 메소드를 추가할 수 있습니다.
}
