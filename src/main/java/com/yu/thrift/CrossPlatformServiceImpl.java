package com.yu.thrift;

import com.yu.thrift.impl.CrossPlatformResource;
import com.yu.thrift.impl.CrossPlatformService;
import com.yu.thrift.impl.InvalidOperationException;
import org.apache.thrift.TException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuhangbin
 * @date 2022/3/10
 **/
public class CrossPlatformServiceImpl implements CrossPlatformService.Iface{

	List<CrossPlatformResource> resources = new LinkedList<>();

	@Override public CrossPlatformResource get(int id) throws InvalidOperationException, TException {
		for (CrossPlatformResource resource : resources) {
			if (resource.getId() == id) {
				return resource;
			}
		}
		return new CrossPlatformResource();
	}

	@Override public void save(CrossPlatformResource resource) throws InvalidOperationException, TException {
		resources.add(resource);
	}

	@Override public List<CrossPlatformResource> getList() throws InvalidOperationException, TException {
		return resources;
	}

	@Override public boolean ping() throws InvalidOperationException, TException {
		System.out.println("reach");
		return true;
	}
}
