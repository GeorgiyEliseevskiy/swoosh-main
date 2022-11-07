package com.SWOOSH.service;

import com.SWOOSH.Promocodes;
import com.SWOOSH.dto.*;
import com.SWOOSH.model.CarWash;
import com.SWOOSH.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicService {

    private final CarWashRepository carWashRepository;
    private final ServiceRepository serviceRepository;
    private final OrderRepository orderRepository;
    private final PromoRepository promoRepository;

    public List<OrderDTO> getReviews(String location) {
        CarWash carWash = carWashRepository.getCarWashByLocation(location);

        Promocodes promocodes = new Promocodes();
        // Изменить сумму заказов
        promocodes.setPromocode(Promocodes.generatePromo(20000));
        // Изменить сумму заказов
        promocodes.setUser_id(1);
        promocodes.setStatus(true);
        promoRepository.save(promocodes);
        System.out.println("123123123");

        return orderRepository.getOrdersByCarWash(carWash)
                .stream()
                .map(e -> new OrderDTO(
                        e.getOrderId(),
                        new UserDTO(),
                        new RegistrationDTO(),
                        new CarWashDTO(),
                        new ServiceDTO(),
                        e.getDate(),
                        e.getText(),
                        e.getPrice(),
                        e.getGrade(),
                        e.getStatus()
                ))
                .filter(e -> StringUtils.isNotBlank(e.getText()))
                .collect(Collectors.toList());
    }

    public List<ServiceDTO> getAllServicesByCarWash(String location) {
        return serviceRepository.findAllByCarWashLocation(location).stream()
                .filter(e -> !e.getDeleted())
                .map(e -> new ServiceDTO(e.getServiceId(), e.getName(), e.getPrice(), location))
                .collect(Collectors.toList());
    }

    public List<ServiceDTO> getAllServices() {
        return serviceRepository.findAll().stream()
                .filter(e -> !e.getDeleted())
                .map(e -> new ServiceDTO(e.getServiceId(), e.getName(), e.getPrice(), e.getCarWash().getLocation()))
                .collect(Collectors.toList());
    }

    public List<CarWashDTO> getAllCarWashes() {
        return carWashRepository.findAll().stream()
                .map(e -> new CarWashDTO(
                        e.getCarWashId(),
                        e.getLocation(),
                        e.getName(),
                        e.getPhone(),
                        new ArrayList<>(),
                        getAllServicesByCarWash(e.getLocation())
                ))
                .collect(Collectors.toList());
    }
}
