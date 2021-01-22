package services;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import models.Card;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.CardDao;

@Service
@Transactional	//配置此方法加入事务管理
public class CardService {

	@Resource
	private CardDao cardDao;
	
	//获取所有销售单信息
	public List<Card> getCards() {
		return cardDao.getCards();
	}

	//获取销售单信息
	public Card getCard(Card card) {
		return cardDao.getCard(card);
	}
	
	//更新销售单信息
	public boolean update(Card card) {
		return cardDao.update(card);		
	}

	//删除销售单信息
	public boolean delete(Card card){
		return cardDao.delete(card);
	}

	//添加销售单信息
	public boolean add(Card card){
		card.setDate(new Date());
		return cardDao.save(card);
	}

	//根据card_id获取该card的信息
	public Card getCard(int id) {
		return cardDao.getCard(id);
	}



}
