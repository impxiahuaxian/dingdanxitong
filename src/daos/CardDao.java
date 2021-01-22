package daos;

import java.util.List;

import models.Card;

import org.springframework.stereotype.Repository;

@Repository//注册spring管理bean
@SuppressWarnings("unchecked")
public class CardDao extends BaseDao{

	//获取所有销售单信息
	public List<Card> getCards() {
		return getSession().createQuery("from Card").list();
	}

	//获取销售单信息
	public Card getCard(Card card) {
		return (Card) getSession().get(Card.class, card.getId());
	}

	//根据id获取该card的信息
	public Card getCard(int id) {
		return (Card) getSession().get(Card.class, id);
	}


}
