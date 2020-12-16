package movies.service;

import movies.bean.Party;
import movies.dao.PartyDAO;

import java.util.List;

/**
 * TODO
 *
 * @author KaYo
 * @date 2019/12/3 - 1:51
 */
public class PartyService {
    private PartyDAO partyDAO;

    public PartyService(){
        partyDAO = new PartyDAO();
    }
    /**
     * 添加出游信息
     * @param
     * @param partydate
     * @return
     */
    public boolean add(String address, long perprice, String introduce, String partydate) {
        return partyDAO.add(address,perprice,introduce,partydate);
    }


    /**
     * 根据address查询用户信息
     * @return
     */
    public Party getParty() {
        return partyDAO.getParty();
    }


    /**
     * 添加报名的用户
     * @param username
     * @param perprice
     * @param phone
     * @return
     */
    public boolean addUser(String username, long perprice, String phone) {
        return partyDAO.addUser(username,perprice,phone);
    }


    /**
     * 查看报名信息
     * @return
     */
    public List<Party> getUser() {
        return partyDAO.getUser();
    }
}
