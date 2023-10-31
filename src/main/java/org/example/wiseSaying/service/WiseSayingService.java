package org.example.wiseSaying.service;

import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    public void write(long wiseSayingNum, String content, String author, String userId) {
        this.wiseSayingRepository.write(wiseSayingNum, content, author, userId);
    }

    public long getWiseSayingListSize() {
        return this.wiseSayingRepository.getWiseSayingListSize();
    }

    public void getWiseSayingList() {
        this.wiseSayingRepository.getWiseSayingList();
    }

    public WiseSaying getWiseSayingfindById(long inputNum) {
        return this.wiseSayingRepository.getWiseSayingfindById(inputNum);
    }

    public void remove(WiseSaying wiseSaying) {
        this.wiseSayingRepository.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying) {
        this.wiseSayingRepository.modify(wiseSaying);
    }
}
