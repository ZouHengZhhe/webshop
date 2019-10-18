package web07_learn_something;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestQueryRunner {
	public static void main(String[] args) throws Exception {
		DataSource ds = new ComboPooledDataSource();//使用c3p0的数据源
//		QueryRunner r = new QueryRunner(ds);
		
		Connection con = ds.getConnection();
		QueryRunner r = new QueryRunner();
		r.update(con,"delete from type where id = ?",2);
		DbUtils.closeQuietly(con);
		
//		QueryRunner r = new QueryRunner(ds);
//		String sql = "select * from goods where id = ?";
//		Map<String, Object> map =  r.query(sql, new MapHandler(),3);
//		for(String key : map.keySet()) {
//			System.out.println(key+":"+map.get(key));
//		}
		
//		String sql = "delete from type where id in(?,?)";
//		int count = r.update(sql,6,7);
//		System.out.println(count);
		
//		String sql = "update type set name = '节日系列' where id = ?";
//		int count = r.update(sql,8);
//		System.out.println(count);
		
//		String sql = "insert into type (name) values(?)";
//		int count = r.update(sql,"成人系列");
//		System.out.println(count);
		
//		String sql = "select * from goods";
//		Object[] res = r.query(sql, new ArrayHandler());
//		for(Object o : res) {
//			System.out.println(o);
//		}
		
//		String sql = "select * from goods";
//		List<Object[]> list = r.query(sql, new ArrayListHandler());
//		for(Object[] objs:list) {
//			for(Object o : objs) {
//				System.out.print(o+" ");
//			}
//			System.out.println();
//		}
		
//		String sql = "select * from goods";
//		Goods goods = r.query(sql, new BeanHandler<Goods>(Goods.class));
//		System.out.println(goods);
		

//		String sql = "select * from goods";
//		List<Goods> list = r.query(sql, new BeanListHandler<Goods>(Goods.class));
//		for(Goods g:list) {
//			System.out.println(g);
//		}
		
//		String sql = "select * from goods";
//		List<String> list = r.query(sql, new ColumnListHandler<String>("name"));
//		for(String o:list) {
//			System.out.println(o);
//		}
		
//		String sql = "select count(*) from goods";
//		long count =r.query(sql, new ScalarHandler<Long>());
//		System.out.println(count);
		
//		String sql = "select * from goods";
//		Map<String,Object> map = r.query(sql, new MapHandler());
//		for(String key : map.keySet()) {
//			System.out.println(key+" "+map.get(key));
//		}
		
		String sql = "select * from goods";
		List<Map<String,Object>> list = r.query(sql, new MapListHandler());
		for(Map<String,Object> map : list) {
			for(String key:map.keySet()) {
				System.out.print(key+" "+map.get(key)+" ");
			}
			System.out.println();
		}
	}
}
