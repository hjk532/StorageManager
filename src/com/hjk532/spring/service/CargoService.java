package com.hjk532.spring.service;

import java.util.List;

import com.hjk532.spring.module.Cargo;
import com.hjk532.spring.module.CargoVo;

public interface CargoService {
	/**
	 * .添加新货单
	 * @param Cargo 货单bean
	 * @return 操作是否成功
	 */
	public boolean addCargo(CargoVo cargo,Integer opId) throws Exception;
	/**
	 * .批量添加新货单
	 * @param Cargo 货单bean
	 * @return 操作是否成功
	 */
	public boolean addCargos(List<CargoVo> cargos,Integer opId) throws Exception;
	
	/**
	 * .出货更新货单
	 * @param oid 货单编号
	 * @return 操作是否成功
	 */
	public boolean outCargo(CargoVo cargo,Integer service) throws Exception;
	
	/**
	 * .删除货单
	 * @param oid 货单编号
	 * @return 操作是否成功
	 */
	public boolean deleteCargo(List<Integer> oids,Integer opId) throws Exception;
	
	/**
	 * .修改货单
	 * @param Cargo 货单信息
	 * @return 操作是否成功
	 */
	public boolean updateCargo(Cargo cargo,Integer opId) throws Exception;
	
	/**
	 * .分页显示查询结果集
	 * @param start 起始行
	 * @param end 结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<CargoVo> findCargos(CargoVo cargo,Integer page) throws Exception;
	
	/**
	 * .分页显示所有货单
	 * @param page 页码
	 * @return 操作是否成功
	 */
	public List<CargoVo> findCargo(Integer page) throws Exception;
}
