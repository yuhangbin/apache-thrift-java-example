package com.yu.thrift;

import com.yu.thrift.impl.CrossPlatformService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author yuhangbin
 * @date 2022/3/10
 **/
public class CrossPlatformServiceServer {


	public static void main(String[] args) throws TTransportException{
		TServerTransport serverTransport = new TServerSocket(9000);
		TServer server = new TSimpleServer(new TSimpleServer.Args(serverTransport)
			.processor(new CrossPlatformService.Processor<>(new CrossPlatformServiceImpl())));

		System.out.println("Starting the server...");

		server.serve();
	}
}
