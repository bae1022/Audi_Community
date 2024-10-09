package com.example.community.repository;

import com.example.community.entity.Meeting;
import com.example.community.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    List<Meeting> findByCrymAndRegisterStatus(String crym, String register_status);

    Meeting findByMeetingId(int meetingId);

    List<Meeting> findByCrymAndUnitBizCode(String crym, String unit_biz_code);

}
