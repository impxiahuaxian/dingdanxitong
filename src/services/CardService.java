package services;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import models.Card;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.CardDao;

@Service
@Transactional	//���ô˷��������������
public class CardService {

	@Resource
	private CardDao cardDao;
	
	//��ȡ�������۵���Ϣ
	public List<Card> getCards() {
		return cardDao.getCards();
	}

	//��ȡ���۵���Ϣ
	public Card getCard(Card card) {
		return cardDao.getCard(card);
	}
	
	//�������۵���Ϣ
	public boolean update(Card card) {
		return cardDao.update(card);		
	}

	//ɾ�����۵���Ϣ
	public boolean delete(Card card){
		return cardDao.delete(card);
	}

	//������۵���Ϣ
	public boolean add(Card card){
		card.setDate(new Date());
		return cardDao.save(card);
	}

	//����card_id��ȡ��card����Ϣ
	public Card getCard(int id) {
		return cardDao.getCard(id);
	}



}
