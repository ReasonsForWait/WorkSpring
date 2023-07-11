package com.example.webjpa.dto.page;

import com.example.webjpa.dto.MemberOutDTO;
import com.example.webjpa.dto.spec.OutDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberOutDTOPage {

    private Integer totalElement;
    private Integer nowPage;
    private Boolean hasNext;
    private List<OutDTO> content;

}
