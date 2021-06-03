package ecma.ai.ussdapp.payload;

import lombok.Data;

import javax.persistence.Column;

@Data
public class SimcardDto {
    private String pinCode;
    private String name;
    private String code; //90 91
    private String number; //7 xonali soni
    private String simCardNumber;
}
