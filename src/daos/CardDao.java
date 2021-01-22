package daos;

import java.util.List;

import models.Card;

import org.springframework.stereotype.Repository;

@Repository//ע��spring����bean
@SuppressWarnings("unchecked")
public class CardDao extends BaseDao{

	//��ȡ�������۵���Ϣ
	public List<Card> getCards() {
		return getSession().createQuery("from Card").list();
	}

	//��ȡ���۵���Ϣ
	public Card getCard(Card card) {
		return (Card) getSession().get(Card.class, card.getId());
	}

	//����id��ȡ��card����Ϣ
	public Card getCard(int id) {
		return (Card) getSession().get(Card.class, id);
	}


}
