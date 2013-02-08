package DAO;

import java.nio.channels.Channel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import DAO.AbstractFacade;

public class ChannelsFacade extends AbstractFacade<Channel> {
	@PersistenceContext(unitName = "ru.khakensb.orem_OREM-ejb_ejb_1.0-SNAPSHOTPU_askue")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public ChannelsFacade() {
		super(Channel.class);
	}
}