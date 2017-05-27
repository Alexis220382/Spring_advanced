package com.ivanovskiy.spring.core.dao.statistics;

import com.ivanovskiy.spring.core.domain.statistics.CounterStatisticsEvent;

public interface ICounterAspectDao {

	public CounterStatisticsEvent getStatisticsById(Long id);
	public void updateStatistics(CounterStatisticsEvent cointerStatisticsEvent);
	public void insertStatistics(CounterStatisticsEvent cointerStatisticsEvent);
	
}
 