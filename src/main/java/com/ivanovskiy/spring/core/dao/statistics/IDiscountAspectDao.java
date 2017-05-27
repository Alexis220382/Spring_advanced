package com.ivanovskiy.spring.core.dao.statistics;

import com.ivanovskiy.spring.core.domain.statistics.DiscountStatistics;

public interface IDiscountAspectDao {

	public DiscountStatistics getStatisticsById(Long id);
	public void updateStatistics(DiscountStatistics cointerStatisticsEvent);
	public void insertStatistics(DiscountStatistics discountStatistics);
	
}
