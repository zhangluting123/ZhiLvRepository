/**
 * 
 */
package com.zhilv.recommend.travels.dao;

import java.util.List;

/**
 * @ClassName:RecommendTravelsMapper
 * @description:TODO
 * @author :������
 * @date:2021��2��8��
 */
public interface RecommendTravelsMapper {
	
	/**
	 * 
	 * @description:�����û�ID�����û���Ȥ�б�
	 * @author :������
	 * @date:2021��2��9��
	 * @param UserId
	 * @return
	 */
	public List<String> findUserInterest(Integer UserId);

}
