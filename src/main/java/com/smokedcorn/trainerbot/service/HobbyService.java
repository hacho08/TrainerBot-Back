package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HobbyService {

    private final HobbyRepository hobbyRepository;

    @Autowired
    public HobbyService(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

//    // 모든 운동 취미 조회
//    public List<Hobby> getAllHobbies() {
//        return hobbyRepository.findAll();
//    }
//
//    // 운동 취미 추가
//    public Hobby addHobby(String hobbyName) {
//        Hobby hobby = new Hobby();
//        hobby.setHobbyName(hobbyName);
//        return hobbyRepository.save(hobby);  // 새로운 취미 추가
//    }
}
