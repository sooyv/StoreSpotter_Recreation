package com.sojoo.StoreSpotter.dto.apiToDb;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Getter @Setter
public class StoreInfo {
    // 상가 번호
    private String bizesId;
    // 상가 이름
    private String bizesNm;
    // 상가 주소
    private String rdnmAdr;
}
