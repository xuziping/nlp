package com.xuzp.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unit {

    /**
     * 当前词语（或标点）的原型或词干，在中文中，此列与FORM相同
     */
    public String LEMMA;


}
