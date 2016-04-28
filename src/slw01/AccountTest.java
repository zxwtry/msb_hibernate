package slw01;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class AccountTest {
	@Test
	public void test01() {
		/*
		 * 	创建表
		 *  Configuration config = new Configuration().configure(cfg);
		 *  SchemaExport se = new SchemaExport(config);
		 *  se.create(ture,true);
		 */
		//默认去找hibernate.cfg.xml文件，并解析
		Configuration configuration = new Configuration().configure();
		SchemaExport schemaExport = new SchemaExport(configuration);
		//对生成DDL语句进行格式化
//		schemaExport.setFormat(true);
//		schemaExport.setDelimiter(" ");
//		schemaExport.setOutputFile("account.sql");
		//第一个说明导出的时候采用默认的格式
		schemaExport.create(true, true);
		
		
	}
}
