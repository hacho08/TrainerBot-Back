package com.smokedcorn.trainerbot.util;

import java.util.Map;

public class MappingUtil {

    // 컨디션 인덱스 -> 텍스트 변환 맵
    public static final Map<Integer, String> CONDITION_MAP = Map.of(
            0, "무릎",
            1, "허리",
            2, "어깨",
            3, "목",
            4, "손목",
            5, "발목"
    );

    // 취미 인덱스 -> 텍스트 변환 맵
    public static final Map<Integer, String> HOBBY_MAP = Map.of(
            0, "걷기",
            1, "등산",
            2, "골프",
            3, "탁구",
            4, "배드민턴",
            5, "수영"
    );

    // 목표 인덱스 -> 텍스트 변환 맵
    public static final Map<Integer, String> GOAL_MAP = Map.of(
            0, "근력 강화",
            1, "체중 감소",
            2, "기초 체력",
            3, "유연성 향상"
    );
}
