package com.chun.myspringboot.controller;

import com.chun.myspringboot.service.WordServiceImpl;
import com.chun.myspringboot.util.DataUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.NumberFormat;

@Controller
public class SelectWordController {
    @Autowired
    private WordServiceImpl wordService;
    @Autowired
    private DataUtils dataUtils;

    @RequestMapping("/selectword")
    public String toSelectWord(Model model){


        int Cet4Remember = wordService.queryWordCet4RememberNumber();
        model.addAttribute("Cet4Remember",Cet4Remember);
        int Cet4Number = wordService.queryWordCet4Number();
        model.addAttribute("Cet4Number",Cet4Number);

        String percent4 = dataUtils.percent(Cet4Remember, Cet4Number);
        model.addAttribute("percent4",percent4);


        int Cet6Number = wordService.queryWordCet6Number();
        model.addAttribute("Cet6Number",Cet6Number);
        int Cet6Remember = wordService.queryWordCet6RememberNumber();
        model.addAttribute("Cet6Remember",Cet6Remember);
        String percent6 = dataUtils.percent(Cet6Remember, Cet6Number);
        model.addAttribute("percent6",percent6);
        return "word/select-word";
    }

}
