package kr.ac.kopo.wepapplication.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class SampleDTO {
    private Long sno; //sample number = sno
    private String first;
    private String last;
    private LocalDateTime regTime;
}
