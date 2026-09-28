package edu.wctc.distjavazodiac.service;

import edu.wctc.distjavazodiac.entity.Month;
import edu.wctc.distjavazodiac.repo.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicMonthListService implements MonthListService {
    private final MonthRepository monthRepository;

    @Autowired
    public BasicMonthListService(MonthRepository monthRepository){
        this.monthRepository = monthRepository;
    }

    @Override
    public List<Month> getMonths() {
        List<Month> list = new ArrayList<>();
        monthRepository.findAll().forEach(list::add);
        return list;
    }
}