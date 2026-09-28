package edu.wctc.distjavazodiac.service;

import edu.wctc.distjavazodiac.entity.Birthday;
import edu.wctc.distjavazodiac.entity.Fortune;
import edu.wctc.distjavazodiac.entity.Horoscope;
import edu.wctc.distjavazodiac.entity.Month;
import edu.wctc.distjavazodiac.repo.FortuneRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Random horoscopes from https://cafeastrology.com/dailyhoroscopesall-tomorrow.html
 */
@Service
public class RandomHoroscopeService implements HoroscopeService{
    private final FortuneRepository fortuneRepository;
    private List<Fortune> allFortunes;
    private final ZodiacService zodiacService;

    @Autowired
    public RandomHoroscopeService(ZodiacService zodiacService, FortuneRepository fortuneRepository) {
        this.zodiacService = zodiacService;
        this.fortuneRepository = fortuneRepository;
    }

    @Override
    public Horoscope getHoroscope(Birthday birthday) {
        String sign;
        if (birthday.getZodiacType().toLowerCase().startsWith("w")) {
            sign = zodiacService.getWesternZodiacSign(birthday);
        } else {
            sign = zodiacService.getEasternZodiacSign(birthday);
        }

        Horoscope hscope = new Horoscope();
        hscope.setSign(sign);

        int randomIndex = (int) (Math.random() * allFortunes.size());
        hscope.setHoroscope(allFortunes.get(randomIndex).getText());
        return hscope;
    }

    @PostConstruct
    public void initHoroscopes() {
        List<Fortune> list = new ArrayList<>();
        fortuneRepository.findAll().forEach(list::add);
        allFortunes = list;
    }
}
