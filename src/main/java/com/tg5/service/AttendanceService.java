package com.tg5.service;

import java.util.Map;

public interface AttendanceService {

    Map<Long, Double> calculateAttendancePerMemberForEachAccount(Long memberId);
}
