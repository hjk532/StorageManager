package com.hjk532.spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjk532.spring.module.Cargo;
import com.hjk532.spring.module.CargoVo;
import com.hjk532.spring.module.Log;
import com.hjk532.spring.module.mapper.CargoMapper;
import com.hjk532.spring.module.mapper.LogMapper;
import com.hjk532.spring.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	CargoMapper cargoMapper;
	@Autowired
	LogMapper logMapper;

	@Override
	public boolean addCargo(CargoVo cargo, Integer opId) throws Exception {
		long ids = cargo.hashCode();
		int id = (int) ids;
		cargo.setOrderId(id);
		boolean result1 = cargoMapper.addCargo(cargo);
		Log log = new Log();
		log.setLogId(UUID.randomUUID() + "-log");
		log.setLogStatus(1);
		log.setOpId(opId);
		cargo = cargoMapper.findByNum(id);
		log.setCargoList(cargo.toString());
		boolean result2 = logMapper.addLog(log);
		if (result1 && result2) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean addCargos(List<CargoVo> cargos, Integer opId) throws Exception {
		boolean result1 = cargoMapper.addCargos(cargos);
		ArrayList<Log> logs = new ArrayList<>();
		Log log = new Log();
		for (int i = 0; i < cargos.size(); i++) {
			log.setLogId(UUID.randomUUID() + "-log");
			log.setLogStatus(1);
			log.setOpId(opId);
			log.setCargoList(cargos.get(i).toString());
			logs.add(log);
		}
		boolean result2 = logMapper.addLogs(logs);
		if (result1 && result2) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean outCargo(CargoVo cargo,Integer account) throws Exception {
		cargo.setCargoAmount(cargo.getCargoAmount()-account);
		boolean result1 = cargoMapper.updateCargo(cargo);
		Log log = new Log();
		log.setLogId(UUID.randomUUID() + "-log");
		log.setLogStatus(2);
		log.setOpId(cargo.getoNum());
		log.setCargoList(cargo.getCargo().toString()+"出货"+account+"件");
		boolean result2 = logMapper.addLog(log);
		if (result1 && result2) {
			return true;
		} else
			return false;
	}
	
	@Override
	public boolean deleteCargo(List<Integer> oids, Integer opId) throws Exception {
		boolean result1 = cargoMapper.deleteCargo(oids);
		if (result1) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean updateCargo(Cargo cargo,Integer opId) throws Exception {
		cargo.setoNum(opId);
		boolean result1 = cargoMapper.updateCargo(cargo);
		Log log = new Log();
		log.setLogId(UUID.randomUUID() + "-log");
		log.setLogStatus(3);
		log.setOpId(opId);
		cargo = cargoMapper.findByNum(cargo.getOrderId());
		log.setCargoList(cargo.toString());
		boolean result2 = logMapper.addLog(log);
		if (result1 && result2) {
			return true;
		} else
			return false;
	}

	@Override
	public List<CargoVo> findCargos(CargoVo cargo,Integer page) throws Exception {
		Integer start = 0;
		Integer end = 10;
		if(page==null)page=1;
		page--;
		List<CargoVo> cargos = cargoMapper.findCargos(cargo,start + page, end + page);
		return cargos;
	}

	@Override
	public List<CargoVo> findCargo(Integer page) throws Exception {
		Integer start = 0;
		Integer end = 10;
		if(page==null)page=1;
		page--;
		List<CargoVo> cargos = cargoMapper.findCargo(start + page, end + page);
		return cargos;
	}

}
