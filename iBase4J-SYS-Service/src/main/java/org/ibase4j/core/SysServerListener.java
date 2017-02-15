package org.ibase4j.core;

import javax.servlet.ServletContextEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ibase4j.core.listener.ServerListener;
import org.ibase4j.service.sys.SysDicService;
import org.ibase4j.service.sys.SysUserService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class SysServerListener extends ServerListener {
	protected final Logger logger = LogManager.getLogger(this.getClass());

	public void contextInitialized(ServletContextEvent contextEvent) {
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		context.getBean(SysUserService.class).init();
		SysDicService sysDicService = context.getBean(SysDicService.class);
		sysDicService.getAllDic();
		super.contextInitialized(contextEvent);
	}
}