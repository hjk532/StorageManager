package com.hjk532.spring.module.mapper;

import java.util.List;

import com.hjk532.spring.module.Cargo;
import com.hjk532.spring.module.CargoVo;

public interface CargoMapper {
	
	/**
	 * .添加新货单
	 * @param cargo 货单bean
	 * @return 操作是否成功
	 */
	public boolean addCargo(CargoVo cargo);
	
	/**
	 * .批量添加新货单
	 * @param cargos 货单bean
	 * @return 操作是否成功
	 */
	public boolean addCargos(List<CargoVo> cargos);
	
	/**
	 * .删除货单
	 * @param oid 货单编号
	 * @return 操作是否成功
	 */
	public boolean deleteCargo(List<Integer> oid);
	
	/**
	 * .修改货单
	 * @param cargo 货单信息
	 * @return 操作是否成功
	 */
	public boolean updateCargo(Cargo cargo);
	
	/**
	 * .按编号查询货物
	 * @param id 货单编号
	 */
	public CargoVo findByNum(Integer id);
	
	/**
	 * .分页显示所有货单
	 * @param cargo 搜索的货物信息
	 * @param start 起始行
	 * @param end 结束行(不包含)
	 * @return 查询结果集
	 */
	public List<CargoVo> findCargos(CargoVo cargo,Integer start,Integer end);
	
	/**
	 * .分页显示所有货单
	 * @param start 起始行
	 * @param end 结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<CargoVo> findCargo(Integer start,Integer end);
}
