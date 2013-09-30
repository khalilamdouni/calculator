package org.calculator.security;

import java.awt.AWTPermission;
import java.io.FilePermission;
import java.lang.reflect.ReflectPermission;
import java.net.NetPermission;
import java.net.SocketPermission;
import java.security.AccessControlException;
import java.security.Permission;
import java.security.SecurityPermission;
import java.sql.SQLPermission;
import java.util.logging.LoggingPermission;

public class CalculatorSecurityManager extends SecurityManager {
	
	@Override
	public void checkPermission(Permission perm) {

		if (perm instanceof FilePermission || perm instanceof NetPermission
				|| perm instanceof AWTPermission
				|| perm instanceof SQLPermission
				|| perm instanceof SecurityPermission
				|| perm instanceof ReflectPermission
				|| perm instanceof SocketPermission
				|| perm instanceof LoggingPermission) {
			throw new AccessControlException(
					"The access of system resources is denied");
		}
	}
	
}