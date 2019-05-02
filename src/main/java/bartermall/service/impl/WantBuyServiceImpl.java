package bartermall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bartermall.mapper.WantBuyMapper;
import bartermall.pojo.WantInfo;
import bartermall.pojo.WantInfoWithUserInfo;
import bartermall.service.WantBuyService;

@Service
public class WantBuyServiceImpl implements WantBuyService {
	@Autowired
	private WantBuyMapper wantBuyMapper;

	@Override
	public void WantBuyGoods(WantInfo wantInfo) {
		wantBuyMapper.WantBuyGoods(wantInfo);
	}

	public List<WantInfoWithUserInfo> getWantInfoWithUserInfoList(){
		// TODO Auto-generated method stub
		return wantBuyMapper.getWantInfoWithUserInfoList();
	}


}
