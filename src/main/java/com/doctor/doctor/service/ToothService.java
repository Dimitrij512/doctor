package com.doctor.doctor.service;

import com.doctor.doctor.entity.Tooth;
import com.doctor.doctor.enums.ToothNumberEnum;
import com.doctor.doctor.enums.ToothPositionEnum;
import com.doctor.doctor.enums.ToothState;
import com.doctor.doctor.repository.ToothRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ToothService {
    private final ToothRepository toothRepository;

    public ToothService(ToothRepository toothRepository) {
        this.toothRepository = toothRepository;
    }

    public Tooth update(String toothId, ToothState toothState, String comment) {

        var tooth = findById(toothId);
        tooth.setToothState(toothState);
        tooth.setComment(comment);

        return toothRepository.save(tooth);
    }

    public Tooth findById(String toothId) {
        return toothRepository.findById(toothId).orElseThrow(() -> new RuntimeException(String.format("not found tooth by id= %s", toothId)));
    }

    public List<Tooth> createTeethForDentalCard(String dentalCardId) {

        List<Tooth> listTeethLeftUpper = createDefaultTeeth(dentalCardId, ToothPositionEnum.LEFT_UPPER);
        List<Tooth> listTeethLeftBottom = createDefaultTeeth(dentalCardId, ToothPositionEnum.LEFT_BOTTOM);
        List<Tooth> listTeethRightUpper = createDefaultTeeth(dentalCardId, ToothPositionEnum.RIGHT_UPPER);
        List<Tooth> listTeethRightBottom = createDefaultTeeth(dentalCardId, ToothPositionEnum.RIGHT_BOTTOM);

        List<Tooth> allTeeth = Stream.of(listTeethLeftUpper, listTeethLeftBottom, listTeethRightUpper, listTeethRightBottom)
                .flatMap(Collection::stream).collect(Collectors.toList());

        return toothRepository.saveAll(allTeeth);
    }

    private List<Tooth> createDefaultTeeth(String dentalCardId, ToothPositionEnum positionEnum) {

        List<Tooth> toothList = new ArrayList<>();

        Arrays.stream(ToothNumberEnum.values()).forEach(toothNumberEnum -> {
            Tooth tooth = new Tooth();
            tooth.setDentalCardId(dentalCardId);
            tooth.setPosition(positionEnum);
            tooth.setToothNumber(toothNumberEnum);
            tooth.setToothState(ToothState.HEALTHY);
            toothList.add(tooth);
        });

        return toothList;
    }
}
