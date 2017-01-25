package tw.com.pai.service;

import java.util.Collection;

import tw.com.pai.dao.ProductionDao;
import tw.com.pai.entuty.ProductionBean;

public class Service {

	public Collection<ProductionBean> select_All() {
		ProductionDao dao = new ProductionDao();
		return dao.select_All();
	}

	public ProductionBean select_by_id(int id) {
		ProductionDao dao = new ProductionDao();
		return dao.select_by_id(id);
	}

	public ProductionBean insert(ProductionBean data) {
		ProductionDao dao = new ProductionDao();
		return dao.insert(data);
	}

	public ProductionBean update(String name, double price, java.util.Date make, int expire, int id) {
		ProductionDao dao = new ProductionDao();
		return dao.update(name, price, make, expire, id);
	}

	public int delete(int id) {
		ProductionDao dao = new ProductionDao();
		return dao.delete(id);
	}
}
