package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.ApproverHirarchyRepository;
import com.tourcoreservice.entity.OrderApproverHirarchy;

@Service
public class ApproverHirarchyService {

	@Autowired
	private ApproverHirarchyRepository approverHirarchyRepository;

	public OrderApproverHirarchy create(OrderApproverHirarchy approverHirarchy) {
		return approverHirarchyRepository.save(approverHirarchy);
	}

	public List<OrderApproverHirarchy> listAll() {
		return approverHirarchyRepository.findAll();
	}

	public OrderApproverHirarchy getApproverHirarchyById(Long id) {
		return approverHirarchyRepository.findById(id).get();
	}

	public void deleteApproverHirarchy(long id) {
		approverHirarchyRepository.deleteById(id);
	}

	public OrderApproverHirarchy Update(OrderApproverHirarchy approverHirarchy) {
		return approverHirarchyRepository.save(approverHirarchy);
	}

}
