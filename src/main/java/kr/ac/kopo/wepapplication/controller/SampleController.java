package kr.ac.kopo.wepapplication.controller;

import kr.ac.kopo.wepapplication.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex1")
    public void ex(){

    }

    @GetMapping({"/ex2", "/ex2_1", "exBlock", "exLink"}) //, "/ex2_1"
    public void exModel(Model model){
        List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(i -> { //20개 객체의 list가 저장되어있다.
            SampleDTO dto = SampleDTO.builder()
                    .sno(i)
                    .first("First.." + i)
                    .last("Last.." + i)
                    .regTime(LocalDateTime.now())
                    .build();
            return dto;
        }).collect(Collectors.toList());

        model.addAttribute("list", list);
    }

    @GetMapping("/exInline")
    public String exInline(RedirectAttributes redirectAttributes){
        SampleDTO dto = SampleDTO.builder()
                .sno(100L)
                .first("First...100")
                .last("Last...100")
                .regTime(LocalDateTime.now())
                .build();

        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addFlashAttribute("dto", dto);

        return "redirect:/sample/ex3";
    }

    @GetMapping({"ex3", "exLayout1", "exLayout2", "exTemplate", "exSidebar"})
    public void ex3(){

    }
}