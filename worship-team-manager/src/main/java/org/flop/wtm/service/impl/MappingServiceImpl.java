
package org.flop.wtm.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.flop.wtm.service.MappingService;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Service
public class MappingServiceImpl implements MappingService {

	private Mapper mapper;

	@PostConstruct
	public void init() {
		// retrieves the mapper singleton
		mapper = DozerBeanMapperSingletonWrapper.getInstance();
	}

	@Override
	public <T> List<T> map(List<? extends Object> sourceObjects, Class<T> destinationClass) {
		// creates the function used to perform mapping operations
		return Lists.transform(sourceObjects, new Function<Object, T>() {

			@Override
			public T apply(Object source) {
				return mapper.map(source, destinationClass);
			}

		});
	}
}
