package com.dlut.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.scau.util.SSHHold;

public class testSSH {
	@Test
	public void test() {
		List<String> cmds = new ArrayList<String>();
		List<String> cmds1 = new ArrayList<String>();
		cmds.add("mysql -uroot -p123");
		cmds.add("use landbigdata;");
		cmds.add("select * from class;");
		cmds1.add("select * from class;");
		
		SSHHold sshHold = new SSHHold();
		try {
			sshHold.ssh_batchs(cmds);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sshHold.getLogs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sshHold.ssh_batchs(cmds1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sshHold.getLogs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
