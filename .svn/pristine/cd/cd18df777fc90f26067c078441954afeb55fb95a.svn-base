package com.jero.esc.controller.appapi.userinfo;

import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.po.userinfo.AccountCard;
import com.jero.esc.service.userinfo.IAccountCardService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller("appAccountCardController")
@RequestMapping(value = "/appapi/userinfo")
public class AccountCardController extends AppBaseController {

    @Autowired
    private IAccountCardService accountCardService;

    /**
     * 卡列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/accountCard/list", method = RequestMethod.GET)
    public Object list() {
        String logId = logId();
        List<AccountCard> cardList = accountCardService.queryAllCard(logId);
        return AppJsonResult.success(cardList);
    }


    /**
     *添加卡
     * @param record 卡的json
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/accountCard/add")
    public AppJsonResult add(AccountCard record) {
        try {
            record.setAcId(UUIDUtil.getUUID());
            record.setAcIsdelete(false);
            record.setLogId(logId());
                if (accountCardService.addCard(record) > 0) {
                    return  AppJsonResult.success();
                }
        } catch (Exception e) {e.printStackTrace();}
        return AppJsonResult.error("银行卡添加失败");
    }


    /**
     * 删除卡
     * @param id 删除卡的id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/accountCard/delete")
    public  AppJsonResult deleteBankCard(String id) {
        try {
            AccountCard accountCard = new AccountCard();
            accountCard.setAcId(id);
            accountCard.setAcIsdelete(true);
            if (accountCardService.removeCard(accountCard) > 0) {
                return  AppJsonResult.success();
            }
        } catch (Exception e) {e.printStackTrace();}
        return  AppJsonResult.error("删除异常");
    }



}
