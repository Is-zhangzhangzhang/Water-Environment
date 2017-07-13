package com.scau.util;

import ch.ethz.ssh2.*;

import java.io.*;
import java.lang.Character.UnicodeBlock;
import java.net.URLDecoder;
import java.util.*;


public class SSHHold {
	
	
    private Connection connection;
    private Session session;
    private InputStream stdout;
    private InputStream stderr;
    private String hostname;
    private String username;
    private String password;
    
    
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public InputStream getStdout() {
		return stdout;
	}
	public void setStdout(InputStream stdout) {
		this.stdout = stdout;
	}
	public InputStream getStderr() {
		return stderr;
	}
	public void setStderr(InputStream stderr) {
		this.stderr = stderr;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public SSHHold() {
		Properties prop = new Properties();
        String baseDir = "";
		try {
			baseDir = URLDecoder.decode(SSHHelper.class.getResource("/").getPath(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        String propPath = baseDir + "ssh.properties";
        System.out.println("配置文件目录为 " + propPath);

        InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream(propPath));
			prop.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String hostname = prop.getProperty("hostname");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        System.out.println("准备SSH连接 " + hostname);
        connection = new Connection(hostname);
        boolean isAuthenticated = false;
        try {
			connection.connect();
			isAuthenticated = connection.authenticateWithPassword(username, password);
			if (isAuthenticated == false)
	            throw new IOException("Authentication failed.");
	        session = connection.openSession();

		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
            session.requestPTY("bash");
            session.startShell();
             ssh("mysql -uroot -p123");
             //ssh("use landbigdata;");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ssh(String cmd) throws IOException {
		PrintWriter	out= new PrintWriter(session.getStdin());
        out.println(cmd);
        out.flush();
       // out.close();
        stdout = session.getStdout();
        stderr = session.getStderr();
        
	}
	
	public void ssh_batchs(List<String> cmd) throws IOException {  
    	//session.requestPTY("bash");
        //session.startShell();
        PrintWriter out = new PrintWriter(session.getStdin());   
    	for (int i = 0; i < cmd.size(); ++i) {
    		out.println(cmd.get(i));
    		out.flush();
    	}
    	out.close();
    	stdout = session.getStdout();
        stderr = session.getStderr();
    }
	
	public String getLogs() throws IOException, InterruptedException {
		Thread.sleep(2000);
        String logs = null;
        byte[] buffer = new byte[8192];
        while (stdout.available() > 0) {
            int len = stdout.read(buffer);
            if (len > 0) {
            	logs += new String(buffer,"utf-8");
            } else {
                return null;
            }
        }

        while (stderr.available() > 0) {
            int len = stderr.read(buffer);
            if (len > 0) {
            	logs += new String(buffer,"utf-8");
            }
        }
        //s=new String(s.getBytes("utf-8"));
       // logs = new String(buffer,"utf-8");

        System.out.println("return:" + logs);
        return logs;
    }

	
	public String filter(String logs) {
		if(logs.contains("mysql>")){
            int mysql_index=logs.indexOf("mysql>");
            int len=logs.length();
            logs=logs.substring(mysql_index,len);
            /*替换部分无意义内容*/
            //logs=logs.replace("hadoop@master:~$","");
        }
		return logs;
	}
	
    public void close() {
        if (session != null) {
            session.close();
            System.out.println("[" + SSHHelper.class.getName() + "]" + "session被关闭");
        }
        if (connection != null) {
            connection.close();
            System.out.println("[" + SSHHelper.class.getName() + "]" + "connection 被关闭");
        }
        ;
        connection = null;
        session = null;
    }
}
