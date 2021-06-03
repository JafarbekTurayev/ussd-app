package ecma.ai.ussdapp.service;

import ecma.ai.ussdapp.entity.SimCard;
import ecma.ai.ussdapp.payload.ApiResponse;
import ecma.ai.ussdapp.payload.SimcardDto;
import ecma.ai.ussdapp.repository.SimcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimCardService {
    @Autowired
    SimcardRepository simcardRepository;

    // bu yerda ombor to'ldiriladi sim card lar bn
    public ApiResponse AddSimCard(SimcardDto simcardDto) {
        if (!simcardDto.getCode().startsWith("+998") && simcardDto.getCode().length() != 6) {
            return new ApiResponse("xatolik. UZB nomer emas bu", false);
        }
        if (simcardDto.getNumber().length() != 7)
            return new ApiResponse("nomerda raqamlar kam !!!", false);

        if (simcardRepository.findByCodeAndNumber(simcardDto.getCode(), simcardDto.getNumber()).isPresent()) {
            return new ApiResponse("bunday nomer mavjud", false);
        }
        if (simcardRepository.findBySimCardNumber(simcardDto.getSimCardNumber()).isPresent()) {
            return new ApiResponse("bunday simcard mavjud", false);
        }


        SimCard simCard = new SimCard();
        simCard.setSimCardNumber(simcardDto.getSimCardNumber());
        simCard.setCode(simcardDto.getCode());
        simCard.setPinCode(simcardDto.getPinCode());
        simCard.setNumber(simcardDto.getNumber());
        simCard.setName(simcardDto.getName());
        simcardRepository.save(simCard);
        return new ApiResponse("simcard added", true);
    }
    //edit qilish  kk
}
