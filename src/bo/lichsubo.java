package bo;

import java.util.ArrayList;

import bean.lichsubean;

import dao.lichsudao;

public class lichsubo {
	lichsudao lsdao = new lichsudao();
	ArrayList<lichsubean> ds;
	public ArrayList<lichsubean> getlichsu() throws Exception{
		
	ds = lsdao.getlichsu();
	return ds;
	}

	
	
}
