package com.yu.thrift;

import com.yu.thrift.impl.CrossPlatformResource;
import com.yu.thrift.impl.CrossPlatformService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author yuhangbin
 * @date 2022/3/10
 **/
public class CrossPlatformServiceClient {


	public static void main(String[] args) {
		TTransport transport = new TSocket("localhost", 9000);
		try {
			TProtocol protocol = new TBinaryProtocol(transport);
			CrossPlatformService.Client client = new CrossPlatformService.Client(protocol);
			transport.open();
			CrossPlatformResource resource = new CrossPlatformResource();
			resource.setId(1);
			resource.setName("first");
			resource.setSalutation("boy");
			client.save(resource);
			CrossPlatformResource firstResource = client.get(1);
			System.out.println(firstResource.getId());
			System.out.println(firstResource.getName());
			System.out.println(firstResource.getSalutation());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			transport.close();
		}

	}
}
