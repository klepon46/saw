package com.gstudio.saw.controller;

import com.gstudio.saw.dto.NilaiDto;
import com.gstudio.saw.model.Bobot;
import com.gstudio.saw.model.Data;
import com.gstudio.saw.repository.BobotRepository;
import com.gstudio.saw.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;

@Controller
@RequestMapping("/perhitungan")
public class PerhitunganController {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private BobotRepository bobotRepository;

    @RequestMapping("/menu")
    public String menu() {
        return "perhitungan/menu";
    }

    @RequestMapping(value = "/hitung", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Data> hitung() {
        return hitungSaw();
    }

    @RequestMapping(value = "/hitungFilter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Data> hitung(int kuartal, int year) {
        return hitungSaw(kuartal, year);
    }

    @RequestMapping(value = "/peringkat", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<NilaiDto> peringkat() {

        List<Data> sawDatas = hitungSaw();
        List<NilaiDto> nilais = new ArrayList<>();

        sawDatas.forEach(item ->{
            NilaiDto nilai = new NilaiDto();
            nilai.setNama(item.getNama());
            nilai.setTotal(item.getKriteria1()+item.getKriteria2()+item.getKriteria3()+item.getKriteria4());

            nilais.add(nilai);
        });
        nilais.sort(Comparator.comparing(NilaiDto::getTotal).reversed());
        return nilais;
    }

    @RequestMapping(value = "/peringkatFilter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<NilaiDto> peringkat(int kuartal, int year) {

        List<Data> sawDatas = hitungSaw(kuartal, year);
        List<NilaiDto> nilais = new ArrayList<>();

        sawDatas.forEach(item ->{
            NilaiDto nilai = new NilaiDto();
            nilai.setNama(item.getNama());
            nilai.setTotal(item.getKriteria1()+item.getKriteria2()+item.getKriteria3()+item.getKriteria4());

            nilais.add(nilai);
        });
        nilais.sort(Comparator.comparing(NilaiDto::getTotal).reversed());

        int x = 1;
        for(NilaiDto item : nilais){
            item.setPeringkat(x++);
        }
        return nilais;
    }

    public List<Data> hitungSaw() {

        List<Data> datas = (List<Data>) dataRepository.findAll();
        List<Bobot> bobots = (List<Bobot>) bobotRepository.findAll();

        Bobot bobot = bobots.get(0);

        List<Float> list1 = new ArrayList<>();
        List<Float> list2 = new ArrayList<>();
        List<Float> list3 = new ArrayList<>();
        List<Float> list4 = new ArrayList<>();

        datas.forEach(item -> {
            list1.add(item.getKriteria1());
            list2.add(item.getKriteria2());
            list3.add(item.getKriteria3());
            list4.add(item.getKriteria4());
        });

        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        formatter.setRoundingMode(RoundingMode.HALF_UP);

        List<Data> newDatas = new ArrayList<>();
        datas.forEach(item ->{
            float val1 = (item.getKriteria1()/Collections.max(list1)*bobot.getBobot1());
            float val2 = (item.getKriteria2()/Collections.max(list2)*bobot.getBobot2());
            float val3 = (item.getKriteria3()/Collections.max(list3)*bobot.getBobot3());
            float val4 = (item.getKriteria4()/Collections.max(list4)*bobot.getBobot4());

            val1 = Float.valueOf(formatter.format(val1));
            val2 = Float.valueOf(formatter.format(val2));
            val3 = Float.valueOf(formatter.format(val3));
            val4 = Float.valueOf(formatter.format(val4));

            item.setKriteria1(val1);
            item.setKriteria2(val2);
            item.setKriteria3(val3);
            item.setKriteria4(val4);

            newDatas.add(item);

        });

        return newDatas;
    }

    public List<Data> hitungSaw(int kuartal, int year) {

        Optional<List<Data>> lists =  dataRepository.findByKuartalAndYear(kuartal, year);
        List<Bobot> bobots = (List<Bobot>) bobotRepository.findAll();

        if(lists.isEmpty())
            return new ArrayList<>();
        
        List<Data> datas = lists.get();
        Bobot bobot = bobots.get(0);

        List<Float> list1 = new ArrayList<>();
        List<Float> list2 = new ArrayList<>();
        List<Float> list3 = new ArrayList<>();
        List<Float> list4 = new ArrayList<>();

        datas.forEach(item -> {
            list1.add(item.getKriteria1());
            list2.add(item.getKriteria2());
            list3.add(item.getKriteria3());
            list4.add(item.getKriteria4());
        });

        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        formatter.setRoundingMode(RoundingMode.HALF_UP);

        List<Data> newDatas = new ArrayList<>();
        datas.forEach(item ->{
            float val1 = (item.getKriteria1()/Collections.max(list1)*bobot.getBobot1());
            float val2 = (item.getKriteria2()/Collections.max(list2)*bobot.getBobot2());
            float val3 = (item.getKriteria3()/Collections.max(list3)*bobot.getBobot3());
            float val4 = (item.getKriteria4()/Collections.max(list4)*bobot.getBobot4());

            val1 = Float.valueOf(formatter.format(val1));
            val2 = Float.valueOf(formatter.format(val2));
            val3 = Float.valueOf(formatter.format(val3));
            val4 = Float.valueOf(formatter.format(val4));

            item.setKriteria1(val1);
            item.setKriteria2(val2);
            item.setKriteria3(val3);
            item.setKriteria4(val4);

            newDatas.add(item);

        });

        return newDatas;
    }

}
