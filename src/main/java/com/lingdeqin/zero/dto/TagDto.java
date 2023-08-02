package com.lingdeqin.zero.dto;

import com.lingdeqin.zero.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lingdq
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDto extends Tag {

    Integer articleNumbers;

}
