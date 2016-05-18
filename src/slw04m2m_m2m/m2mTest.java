package slw04m2m_m2m;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class m2mTest {
	public static void main(String[] args) {
		test01Init();
	}
	static void test01Init() {
		Configuration configuration = new Configuration().configure();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true,true);
	}
	static void test02Add() {
		
	}
}
